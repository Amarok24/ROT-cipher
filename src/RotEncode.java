/*
 * ROT cipher in Java.
 * Version: 1.0.0
 * Date: 2022-08-18
 * Author: Jan Prazak
 * Project page: https://github.com/Amarok24/ROT-cipher
 *
 * License: The Unlicense.
 * For more information, please refer to https://unlicense.org
 */

/**
 * Class RotEncode implements a simple rotation encoder which works
 * with printable ASCII characters. A ROT cipher should be self-reciprocal,
 * which means encoding & decoding is done with the same method.
 */
public class RotEncode
{
	private int rangeFrom;
	private int rangeTo;
	private int rotateBy;

	/**
	 * RotEncode without range specifications defaults to the ROT47 range
	 * (ASCII codes 33..126)
	 * 
	 * @param rotateBy
	 *          Rotate by this number of characters.
	 */
	public RotEncode(int rotateBy)
	{
		// Default ROT47 range is the full printable ASCII range 32..126 w/out 32
		rangeFrom			= 33;
		rangeTo				= 126;
		this.rotateBy	= rotateBy;
	}

	/**
	 * @param rangeFrom
	 *          A number between 32 and 125 (ASCII code).
	 * @param rangeTo
	 *          A number between 33 and 126 (ASCII code).
	 * @param rotateBy
	 *          Rotate by this number of characters.
	 */
	public RotEncode(int rangeFrom, int rangeTo, int rotateBy)
	{
		if((rangeFrom < 32 || rangeTo > 126) || rangeFrom >= rangeTo) {
			throw new Error("Given ROT range is invalid, must be between 32 and 126.");
		}
		this.rangeFrom	= rangeFrom;
		this.rangeTo		= rangeTo;
		this.rotateBy		= rotateBy;
	}

	/**
	 * The direction of rotation is always to the right.
	 */
	String rotate(String input) throws Error
	{
		StringBuilder result = new StringBuilder(input.length());
		int upperOverflow = rangeTo + 1;
		int charCode;
		int remainder;

		for(int i = 0; i < input.length(); i++) {
			// charCode may be 65533 (Unicode FFFD), which is a REPLACEMENT CHARACTER. This is often emitted when the data to be converted is corrupt, or when the encoding to convert into can't represent the correct character.
			charCode = input.codePointAt(i);

			if(charCode != 32 && (charCode < rangeFrom || charCode > rangeTo)) {
				var msg = String.format("Character '%s' (code %d) is out of ROT range.", input.charAt(i), charCode);
				throw new Error(msg);
			}

			if((charCode == 32) && rangeFrom > 32) {
				// Pass through the space character.
				result.appendCodePoint(charCode);
			}
			else {
				remainder = (charCode + rotateBy) % upperOverflow;
				result.appendCodePoint(remainder < rotateBy ? remainder + rangeFrom : remainder);
			}
		}

		return result.toString();
	}

}

public class App {

    public static void main(String[] args) {
        String s;

        // https://en.wikipedia.org/wiki/ROT13#Variants
        var ROT47 = new RotEncode(47);
        var ROT47modified = new RotEncode(32, 125, 47); // with `space` character, but without `~` character

        var ROT01 = new RotEncode(1);

        // https://en.wikipedia.org/wiki/Caesar_cipher
        var caesarCipher = new RotEncode(65, 90, 23);

        s = ROT47.rotate("%96 \"F:4< qC@H? u@I yF>AD ~G6C %96 {2KJ s@8]");
        // The Quick Brown Fox Jumps Over The Lazy Dog.
        System.out.println(s);

        s = ROT47.rotate(s);
        // %96 "F:4< qC@H? u@I yF>AD ~G6C %96 {2KJ s@8]
        System.out.println(s);

        s = ROT47.rotate("First and last !~");
        // u:CDE 2?5 =2DE PO
        System.out.println(s);
        /*
        s = ROT47.rotate("Invalid char: Ä. End."); // throws an error
        System.out.println(s);
         */
        s = caesarCipher.rotate("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG");
        // QEB NRFZH YOLTK CLU GRJMP LSBO QEB IXWV ALD
        System.out.println(s);

        // Just for demonstration purposes. This ROT method is wrong, because
        // a second rotation does not produce the original string.
        s = ROT01.rotate("ABC abc 123"); // BCD bcd 234
        System.out.println(s);

        s = ROT01.rotate(s); // "CDE cde 345" != "ABC abc 123"
        System.out.println(s);

        // The following ROT47 is a bit more cryptic, because it also rotates
        // the space character. To make it work repeatedly I had to keep the
        // same length of the range, so the last char "~" had to be cut off.

        s = ROT47modified.rotate("Hello world! 123");
        // w6==@OH@C=5PO`ab
        System.out.println(s);

        s = ROT47modified.rotate(s);
        // Hello world! 123
        System.out.println(s);

        // Uncomment the following line to demonstrate a range error.
        //  ROT47modified.rotate("Test, character ~ is out of range");
        // Error: Character '~' (code 126) is out of ROT range.
    }

}

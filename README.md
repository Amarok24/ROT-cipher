# RotEncode: an enhanced ROT cipher
ROT47 cipher with extra features (custom ASCII range and rotation), which allow some other cipher implementations, for example the Caesar cipher.

[ROT cipher on Wikipedia](https://en.wikipedia.org/wiki/ROT13)

[Caesar cipher on Wikipedia](https://en.wikipedia.org/wiki/Caesar_cipher)

---

## Ideas for further improvement
The RotEncode class should not work with built-in character table, but instead it should implement its own table, with the possibility to pass a fully customised char table as an argument. This would allow the creation of many other ciphers (ROT13, ROT18 ...).

Another class could inherit the RotEncode class and enhance its features to produce more advanced ciphers like the [Vigenere cipher](https://en.wikipedia.org/wiki/Vigen%C3%A8re_cipher)

## License

License: The Unlicense. For more information, please refer to http://unlicense.org
(A license with no conditions whatsoever which dedicates works to the public domain. Unlicensed works, modifications, and larger works may be distributed under different terms and without source code.)

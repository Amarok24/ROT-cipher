# RotEncode: an enhanced ROT cipher
ROT47 cipher with extra features (custom ASCII range and rotation), which allow some other cipher implementations, for example the Caesar cipher.

[ROT cipher on Wikipedia](https://en.wikipedia.org/wiki/ROT13)

[Caesar cipher on Wikipedia](https://en.wikipedia.org/wiki/Caesar_cipher)

---
## Run the compiled jar program
In the `/bin` folder there is a jar file with compiled Java code. How to run the program:

```sh
java -jar RotEncoder.jar
```

If you get an error message (java not found) it means you don't have the Java Runtime Environment (JRE) installed. In this case follow the instructions below.

## The Java Runtime Environment (JRE) and Java Development Kit (JDK)
To run compiled Java code you only need the JRE. The JDK contains not only the JRE, but also tools and files for Java programmers.

### GNU/Linux
In almost every **GNU/Linux** distribution there is an "openjdk" package available. Here is how to install it on Debian-based distros (you may need to change the JRE version number, I use 17 as an example).
```sh
sudo apt update
sudo apt install openjdk-17-jre
```
Here is also a brief article on how to install the whole Java Development Kit (JDK) on Debian and how to update the PATH variable: [Link](https://vitux.com/how-to-setup-the-java_home-path-in-debian-11/). 

### Windows and MacOS
On **Windows** and **MacOS** there are different ways, you will have to download an OpenJDK install package of your choice. There are several to choose from. Builds by Amazon, Oracle and Microsoft are 3 of the most known.
- [Java @ Amazon](https://aws.amazon.com/corretto)
- [Java @ Oracle](https://docs.oracle.com/en/java/javase/18/install/overview-jdk-installation.html)
- [Java @ Microsoft](https://www.microsoft.com/openjdk)

## Ideas for further improvement
The RotEncode class should not work with built-in character table, but should implement its own table instead, with the possibility to pass a fully customised char table as an argument. This would allow the creation of many other ciphers (ROT13, ROT18 ...).

Another class could inherit the RotEncode class and enhance its features to produce more advanced ciphers like the [Vigenere cipher](https://en.wikipedia.org/wiki/Vigen%C3%A8re_cipher).

A command line interface for the RotEncode class could be developed.

## License

License: The Unlicense. For more information, please refer to http://unlicense.org
(A license with no conditions whatsoever which dedicates works to the public domain. Unlicensed works, modifications, and larger works may be distributed under different terms and without source code.)

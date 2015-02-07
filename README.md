[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.dexafree/simplesec/badge.svg?style=flat)](https://maven-badges.herokuapp.com/maven-central/com.github.dexafree/simplesec)

# SimpleSec

SimpleSec is a Java library that aims to provide Java and Android developers a very simple way to use some of the most common hash and cipher functions.

Its workflow is made in a way that the developer never has to deal with any low level issue, nor having to catch exceptions.
Every function of the library receives String objects and returns String objects, so you never get to see even a `byte[]`.

## What is included

### Hash
* MD5
* SHA-1
* SHA-256
* SHA 512

### Cipher (symetric)
* AES
* TripleDES

It also provides a very basic wrapper for using Base64.

## Usage
For using it you only need to call the static methods of the function you want to use:


### Hash functions

```java
String myText = "Hello";

String md5Hash = MD5.hash(myText);

String sha1Hash = SHA1.hash(myText);

String sha256Hash = SHA256.hash(myText);

String sha512Hash = SHA512.hash(myText);
```

### Base64
The library provides an abstraction layer from the apache commons base64 codec, so you only get to see the final part, pass and receive Strings

```java
String myText = "Hello";

String base64Text = Base64.encode(myText);
String base64Decoded = Base64.decode(base64Text);

assertEquals(base64Decoded, myText);
```

### Symetric encryption
In order to use the symetric encryption functions, you need to provide the text and a key, which can be any length you want

```java
String myText = "Hello";
String myKey = "MY_SUPER_SECRET_AND_LONG_KEY_THAT_YOU_WOULD_NEVER_GUESS";

String aesEncrypted = AES.encrypt(myText, myKey);
String tripleDesEncrypted = TripleDES.encrypt(myText, myKey);

String aesDecrypted = AES.decrypt(aesEncrypted, myKey);
String tripleDesDecrypted = TripleDES.decrypt(tripleDesDecrypted, myKey);

assertEquals(aesDecrypted, myText);
assertEquals(tripleDesDecrypted, myText);
```

> ### Important
> As AES and TripleDES don't actually allow you to pass keys with a length over 32bits, the library will take care of that

## Including it to your project
You can either clone the repository and add the 'simplesec' module as a dependency, or if you are using Gradle as the build system, you can include it by simply adding this line ti your module's build.gradle:

```groovy
dependencies {
   ...
   compile 'com.github.dexafree:simplesec:1.0.3'
}
```

## Disclaimer
SimpleSec does not aim to be a super secure way to encrypt your text, but a way to use those common functions in a very simple way.

You are the only responsible about using it, and you can not blame me if you lose your key, encrypt badly your text, lose any data or if the NSA is able to read your messages.
This library has only been created as a way to simplify a commonly tough task, so if you think you want to have more control about your security, feel free not to use it and provide your own implementation (also to make any pull request you consider useful).

## LICENSE

SimpleSec is licensed under Apache v2 License, which means that it is Open Source and free to use and modify.

```
Copyright 2014 Dexafree

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

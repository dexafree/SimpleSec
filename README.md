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

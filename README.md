

project id | pasa_cbentley_jpasc_explorer
------------ | -------------
author | Charles-Philip Bentley
license | ![license CC by-nc-nd](https://img.shields.io/badge/license-CC%20by--nc--nd-red.svg?style=plastic)
tags | Java PascalCoin Blockchain Explorer Ant
created | July 2019
modified | ![GitHub last commit](https://img.shields.io/github/last-commit/cpbentley/pasa_cbentley_jpasc_pcore_test.svg?style=plastic)

Quote by Christopher Columbus
> Following the light of the sun, we left the Old World.

# JPasc PCore Tests

Stand alone GUI for exploring the Pascal chain.

## Table of Contents
  * [Latest Release](#Latest Release)
  * [Installation](#installation)
  * [Run as binary](#run-a-release)
  * [Run in Eclipse](#run-in-eclipse)

***
## Latest Release

## Installation

### How to Run / Build

[//]: # (This may be the most platform independent comment)

#### Setup <a name="setup"></a>

* Install Java 8 **JDK** (author used 191). You need the Java _Development_ Kit, which includes the Runtime (JRE). [Oracle JDK 8 Download Page](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html "Lastest JDK 8 from Oracle")
* Install Eclipse (author used 2019-06). [Eclipse Download Page](https://www.eclipse.org/downloads/ "https://www.eclipse.org/downloads/")
* When launching Eclipse, create a workspace or use an existing workspace where you will check out all the github repos.

* An Eclipse workspace compiles continuously all its projects and their files. Errors are reported in the problems view.

* Import the github repositories listed below. Following the given order, you should not see any compilation errors.

  1. Right click on link and copy link to clipboard
  2. In Eclipse, use the menu File -> Import
  ![eclipse_run_as.jpg](https://github.com/cpbentley/pasa_cbentley_app_hello_ctx/blob/master/res/tutorial/eclipse_import_git.jpg)
  3. In the dialog find Git -> Projects from Git -> Clone URI
  4. If you have copied the github repository url in the clipboard, you should see
    ![eclipse_run_as.jpg](https://github.com/cpbentley/pasa_cbentley_app_hello_ctx/blob/master/res/tutorial/eclipse_git_cloneuri.jpg)
  5. Select master branch
   ![eclipse_run_as.jpg](https://github.com/cpbentley/pasa_cbentley_app_hello_ctx/blob/master/res/tutorial/eclipse_git_branch.jpg)
  6. Next-Next
  7. Select import Eclipse Project.

* Import the final link (actual project of this repository) using the same process.
* Optional: Check the source code.

#### Github Repository Dependencies

num | id | Right Click -> Copy Link Address
----| -- | -------------
1 | pasa_cbentley_core_src4 | [Import Link](https://github.com/cpbentley/pasa_cbentley_core_src4)
2 | pasa_cbentley_byteobjects_src4 | [Import Link](https://github.com/cpbentley/pasa_cbentley_byteobjects_src4)
3 | pasa_cbentley_core_src5 | [Import Link](https://github.com/cpbentley/pasa_cbentley_core_src5)
3 | pasa_cbentley_core_src8 | [Import Link](https://github.com/cpbentley/pasa_cbentley_core_src8)
4 | pasa_dbolet_jpascalcoin_v3 | [Import Link](https://github.com/cpbentley/pasa_dbolet_jpascalcoin_v3)
5 | pasa_cbentley_swing | [Import Link](https://github.com/cpbentley/pasa_cbentley_swing)
5 | pasa_cbentley_swing_images | [Import Link](https://github.com/cpbentley/pasa_cbentley_swing_images)
5 | pasa_cbentley_swing_gif | [Import Link](https://github.com/cpbentley/pasa_cbentley_swing_gif)
5 | pasa_cbentley_jpasc_pcore | [Import Link](https://github.com/cpbentley/pasa_cbentley_jpasc_pcore)
5 | pasa_cbentley_jpasc_swing | [Import Link](https://github.com/cpbentley/pasa_cbentley_jpasc_swing)
final | pasa_cbentley_jpasc_explorer | [Import Link](https://github.com/cpbentley/pasa_cbentley_jpasc_explorer)

#### Run a release
[Up](#table-of-contents)

##### Windows

##### Command Line

#### Run in Eclipse
[Up](#table-of-contents)

Search in Eclipse for project **_pasa_cbentley_jpasc_pcore_test_**, inside src folder

 ![eclipse_run_as.jpg](https://github.com/cpbentley/pasa_cbentley_app_hello_ctx/blob/master/res/tutorial/eclipse_run_unit_test.jpg)
 
Right click on it and select Run As


## Tasks List

- [x] Pages Github
- [ ] Test all classes

[table of contents](#table-of-contents)

## Links

 * [Proguard Official Sourceforge Repository](https://sourceforge.net/projects/proguard/ "Proguard on sourceforge.net")


[table of contents](#table-of-contents)

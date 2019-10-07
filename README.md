

project id | pasa_cbentley_jpasc_explorer
------------ | -------------
author | Charles-Philip Bentley
license | ![license CC by-nc-nd](https://img.shields.io/badge/license-CC%20by--nc--nd-red.svg?style=plastic)
tags | Java PascalCoin Blockchain Explorer Ant
created | July 2019
modified | ![GitHub last commit](https://img.shields.io/github/last-commit/cpbentley/pasa_cbentley_jpasc_explorer.svg?style=plastic)

Quote by Christopher Columbus
> Following the light of the sun, we left the Old World.

# JPasc Explorer : Pascal Blockchain Explorer

Stand alone GUI for exploring the Pascal chain.

## Software requirements

1. Java 8
2. PascalCoin 4.0.2 

## Table of Contents

  * [Latest Release](#latest-release)
  * [Installation](#installation)
  * [Run as binary](#run-a-release)
  * [Run in Eclipse](#run-in-eclipse)

***

## Screenshots

![explorer_ss1_sales_sort_pri.png](https://github.com/cpbentley/pasa_cbentley_jpasc_explorer/blob/master/doc/explorer_ss1_sales_sort_pri.png)

![explorer_ss5_triple_sort.png](https://github.com/cpbentley/pasa_cbentley_jpasc_explorer/blob/master/doc/explorer_ss5_triple_sort.png)

## Latest Release

[↑](#table-of-contents)

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
    ![explorer_git.jpg](https://github.com/cpbentley/pasa_cbentley_app_hello_ctx/blob/master/res/tutorial/explorer_git.jpg)
  5. Select master branch
   ![eclipse_git_branch.jpg](https://github.com/cpbentley/pasa_cbentley_app_hello_ctx/blob/master/res/tutorial/eclipse_git_branch.jpg)
  6. Next you decide where the cloned repository will be created.
  ![eclipse_import_git_path.jpg](https://github.com/cpbentley/pasa_cbentley_app_hello_ctx/blob/master/res/tutorial/eclipse_import_git_path.jpg)
  7. Select import Eclipse Project.
   ![eclipse_import_git_choose.jpg](https://github.com/cpbentley/pasa_cbentley_app_hello_ctx/blob/master/res/tutorial/eclipse_import_git_choose.jpg)
  8. Eclipse project is selected. Press Finish
  ![eclipse_import_git_finish.jpg](https://github.com/cpbentley/pasa_cbentley_app_hello_ctx/blob/master/res/tutorial/eclipse_import_git_finish.jpg)
 

* Import the final link (actual project of this repository) using the same process.
* Optional: Check the source code.

#### Github Repository Dependencies

num | id | Right Click -> Copy Link Address
----| -- | -------------
1 | java_src4_compat_j2se | [Import Link](https://github.com/cpbentley/java_src4_compat_j2se)
2 | pasa_cbentley_core_src4 | [Import Link](https://github.com/cpbentley/pasa_cbentley_core_src4)
3 | pasa_cbentley_byteobjects_src4 | [Import Link](https://github.com/cpbentley/pasa_cbentley_byteobjects_src4)
4 | pasa_cbentley_core_src5 | [Import Link](https://github.com/cpbentley/pasa_cbentley_core_src5)
5 | pasa_cbentley_core_src8 | [Import Link](https://github.com/cpbentley/pasa_cbentley_core_src8)
6 | pasa_dbolet_jpascalcoin_v3 | [Import Link](https://github.com/cpbentley/pasa_dbolet_jpascalcoin_v3)
7 | pasa_cbentley_swing | [Import Link](https://github.com/cpbentley/pasa_cbentley_swing)
8 | pasa_cbentley_swing_images | [Import Link](https://github.com/cpbentley/pasa_cbentley_swing_images)
9 | pasa_cbentley_swing_gif | [Import Link](https://github.com/cpbentley/pasa_cbentley_swing_gif)
10 | pasa_cbentley_jpasc_pcore | [Import Link](https://github.com/cpbentley/pasa_cbentley_jpasc_pcore)
11 | pasa_jtattoo | [Import Link](https://github.com/cpbentley/pasa_jtattoo)
12 | pasa_cbentley_jpasc_swing | [Import Link](https://github.com/cpbentley/pasa_cbentley_jpasc_swing)
13 | pasa_cbentley_swing_skin | [Import Link](https://github.com/cpbentley/pasa_cbentley_swing_skin)
final | pasa_cbentley_jpasc_explorer | [Import Link](https://github.com/cpbentley/pasa_cbentley_jpasc_explorer)

After all this hard work, all the projects should compile without errors.

#### Eclipse: Create working set

Using a working set allows to narrow down the workspace view to a given set of projects.
Let's create a PascalCoin Simple Explorer working set

File -> New -> Other. A window appears. Select Java -> Working Set as shown below:

![create_java_working_set.jpg](https://github.com/cpbentley/pasa_cbentley_app_hello_ctx/blob/master/res/tutorial/create_java_working_set.jpg)

![eclipse_create_working_set_.jpg](https://github.com/cpbentley/pasa_cbentley_app_hello_ctx/blob/master/res/tutorial/eclipse_create_working_set_.jpg)

![eclipse_working_set_select.jpg](https://github.com/cpbentley/pasa_cbentley_app_hello_ctx/blob/master/res/tutorial/eclipse_working_set_select.jpg)

#### Pull on the latest

Select all projects in the working set.

![explorer_pull_multiple.jpg](https://github.com/cpbentley/pasa_cbentley_app_hello_ctx/blob/master/res/tutorial/explorer_pull_multiple.jpg)

![explorer_pull_multiple_ok.jpg](https://github.com/cpbentley/pasa_cbentley_app_hello_ctx/blob/master/res/tutorial/explorer_pull_multiple_ok.jpg)



#### Run a release
[Up](#table-of-contents)

##### Windows

##### Command Line

[↑](#table-of-contents)

#### Run in Eclipse


Search in Eclipse for project **_pasa_cbentley_jpasc_explorer_**, inside src folder

 ![explorer_run.jpg](https://github.com/cpbentley/pasa_cbentley_app_hello_ctx/blob/master/res/tutorial/explorer_run.jpg)
 
Right click on it and select Run As


## Tasks List

- [x] Pages Github
- [ ] Test all classes

[table of contents](#table-of-contents)

## Links

 * [Proguard Official Sourceforge Repository](https://sourceforge.net/projects/proguard/ "Proguard on sourceforge.net")


[table of contents](#table-of-contents)



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

![github_template_pascal_expl.jpg](https://github.com/cpbentley/pasa_cbentley_jpasc_explorer/blob/master/doc/github_template_pascal_expl.jpg)

## Requirements

### Software

1. Java 8 -> [Oracle JDK 8 Download Page](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html "Lastest JDK 8 from Oracle")
2. PascalCoin 4.0.2 (October 2019 1.0.x release) 
3. PascalCoin 5.3 (December 2020 1.1.x release)  [PascalCoin Releases] (https://github.com/PascalCoin/PascalCoin/releases "PascalCoin")

### Trust

This is blockchain world. Trust must be earned. Do not trust, verify!

Every release includes a -sources.jar. This jar file includes every single source files, including all library sources. 

You may unpack the sources.jar content into a Java Eclipse project and check the running code by yourself in debug mode. This section [Run in Eclipse](#run-in-eclipse) provides more.

## Table of Contents

  * [Requirements](#requirements)
  * [Screenshots](#screenshots)
  * [Releases](#releases)
  * [Run a release as binary](#run-a-release)
  * [Installation for Devs](#installation)
  * [Run source code in Eclipse](#run-in-eclipse)

***

## Screenshots

[↑ ToC ↑](#table-of-contents)

Here are screenshots of version 1.1 which adds support for Account and Coin Swaps, improved name search, and V5 account fields.

![explorer_v2_ss1_names.png](https://github.com/cpbentley/pasa_cbentley_jpasc_explorer/blob/master/doc/explorer_v2_ss1_names.png)

Here are screenshot of version 1.0

![explorer_ss7_poloniex.png](https://github.com/cpbentley/pasa_cbentley_jpasc_explorer/blob/master/doc/explorer_ss7_poloniex.png)

![explorer_ss1_sales_sort_pri.png](https://github.com/cpbentley/pasa_cbentley_jpasc_explorer/blob/master/doc/explorer_ss1_sales_sort_pri.png)

![explorer_ss2_rich_list.png](https://github.com/cpbentley/pasa_cbentley_jpasc_explorer/blob/master/doc/explorer_ss2_rich_list.png)

![explorer_ss3_account_detail.png](https://github.com/cpbentley/pasa_cbentley_jpasc_explorer/blob/master/doc/explorer_ss3_account_detail.png)

![explorer_ss4_pink.png](https://github.com/cpbentley/pasa_cbentley_jpasc_explorer/blob/master/doc/explorer_ss4_pink.png)

![explorer_ss8_flatlaf.png](https://github.com/cpbentley/pasa_cbentley_jpasc_explorer/blob/master/doc/explorer_ss8_flatlaf.png)

![explorer_ss5_triple_sort.png](https://github.com/cpbentley/pasa_cbentley_jpasc_explorer/blob/master/doc/explorer_ss5_triple_sort.png)

![explorer_ss6_donations.png](https://github.com/cpbentley/pasa_cbentley_jpasc_explorer/blob/master/doc/explorer_ss6_donations.png)

## Releases

[↑ ToC ↑](#table-of-contents)

Right click on a link below and save content as
or
Click on click, Github opens another page with a Download button.

### Latest Release

#### 1.1.14

![JPascExplorer-1.0.4-pro.jar](https://github.com/cpbentley/pasa_cbentley_jpasc_explorer/blob/master/releases/JPascExplorer-1.1.14-pro.jar)

![JPascExplorer-1.0.4-pro-sources.jar](https://github.com/cpbentley/pasa_cbentley_jpasc_explorer/blob/master/releases/JPascExplorer-1.1.14-pro-sources.jar)


### Old Releases


#### 1.0.4

![JPascExplorer-1.0.4-pro.jar](https://github.com/cpbentley/pasa_cbentley_jpasc_explorer/blob/master/releases/JPascExplorer-1.0.4-pro.jar)

![JPascExplorer-1.0.4-pro-sources.jar](https://github.com/cpbentley/pasa_cbentley_jpasc_explorer/blob/master/releases/JPascExplorer-1.0.4-pro-sources.jar)

### Run a release

[↑ ToC ↑](#table-of-contents)

Make sure Java is installed as described in [Installation](#installation). 

Once Java is on your system, you can run programs either on the command line or using the user interface

#### Windows

On Windows, you can run a java jar using the following method

![jpasc_explorer_running_from_windows.png](https://github.com/cpbentley/pasa_cbentley_jpasc_explorer/blob/master/doc/jpasc_explorer_running_from_windows.png)

#### Command Line

With the cmd line, go to the folder where the jar file is located and

java -jar JPascExplorer-1.0.4-pro.jar

[↑ ToC ↑](#table-of-contents)

## Installation

This section is written for people who want to setup an Eclipse/Java environment for development.

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

The pasa_cbentley_jpasc_explorer project uses the following entities

num | id | Right Click -> Copy Link Address
----| -- | -------------
1 | java_src4_compat_j2se | [Import Link](https://github.com/cpbentley/java_src4_compat_j2se)
2 | pasa_cbentley_core_src4 | [Import Link](https://github.com/cpbentley/pasa_cbentley_core_src4)
3 | pasa_cbentley_byteobjects_src4 | [Import Link](https://github.com/cpbentley/pasa_cbentley_byteobjects_src4)
4 | pasa_cbentley_core_src5 | [Import Link](https://github.com/cpbentley/pasa_cbentley_core_src5)
5 | pasa_cbentley_core_src8 | [Import Link](https://github.com/cpbentley/pasa_cbentley_core_src8)
6 | pasa_cbentley_core_j2se | [Import Link](https://github.com/cpbentley/pasa_cbentley_core_j2se/tree/master/pasa_cbentley_core_j2se)
7 | pasa_cbentley_core_swing 	| [Import Link](https://github.com/cpbentley/pasa_cbentley_core_swing)
8 | pasa_cbentley_swing 		| [Import Link](https://github.com/cpbentley/pasa_cbentley_swing)
9 | pasa_cbentley_swing_images 	| [Import Link](https://github.com/cpbentley/pasa_cbentley_swing_images)
10 | pasa_cbentley_swing_gif 	| [Import Link](https://github.com/cpbentley/pasa_cbentley_swing_gif)
11 | pasa_cbentley_jpasc_pcore 	| [Import Link](https://github.com/cpbentley/pasa_cbentley_jpasc_pcore)
12 | pasa_jtattoo 				| [Import Link](https://github.com/cpbentley/pasa_jtattoo)
13 | JFormDesigner_FlatLaf 		| [Import Link](https://github.com/cpbentley/JFormDesigner_FlatLaf)
14 | pasa_cbentley_swing_skin 	| [Import Link](https://github.com/cpbentley/pasa_cbentley_swing_skin)
15 | pasa_cbentley_jpasc_swing 	| [Import Link](https://github.com/cpbentley/pasa_cbentley_jpasc_swing)
16 | pasa_cbentley_jpasc_jsonrpc | [Import Link](https://github.com/cpbentley/pasa_cbentley_jpasc_jsonrpc)
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


#### Run in Eclipse

[↑ ToC ↑](#table-of-contents)

Search in Eclipse for project **_pasa_cbentley_jpasc_explorer_**, inside src folder

 ![explorer_run.jpg](https://github.com/cpbentley/pasa_cbentley_app_hello_ctx/blob/master/res/tutorial/explorer_run.jpg)
 
Right click on it and select Run As


## Tasks List

- [x] Pages Github
- [x] V5
- [ ] Test all classes

[table of contents](#table-of-contents)

## Links

 * [Proguard Official Sourceforge Repository](https://sourceforge.net/projects/proguard/ "Proguard on sourceforge.net")
 * [Pascal RPC Wiki](https://www.pascalcoin.org/development/rpc "Pascal RPC Wiki")
 * [Free PASA: Official Pascal Account Distribution BROKEN](https://freepasa.org/ "Free PASA: Official Pascal Account Distribution")


[table of contents](#table-of-contents)

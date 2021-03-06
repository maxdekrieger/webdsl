# WebDSL
Main repository for the WebDSL domain-specific language for web applications.

## Installation
Either follow the [installation instructions][1], or build from source.
See also [how to get WebDSL in Eclipse][2].

## Building

### Install Dependencies (macOS + brew)

`brew install wget autoconf automake maven ant nailgun`

### Build WebDSL compiler
Invoke the following commands from the root of the repository:

    ./bootstrap
    ./configure --prefix=/usr/local
    make
    make install

You can check the current version of your WebDSL installation:

    webdsl version

It will report the hash of the commit from which WebDSL was built.

> Note: If you get this error when invoking `make`:
>
>     Making all in src
>     make[1]: *** No rule to make target `libwebdsl-front.rtree',
>       needed by `src-gen/org/webdsl/webdsl_generator/Main.java'.  Stop.
>     make: *** [all-recursive] Error 1
>
> Clean the temporary files from the repository, e.g.:
>
>     git clean -fXd
>
> Then reissue the commands for building WebDSL.

## Build and run a WebDSL application

Example application: https://github.com/webdsl/elib-example

### Command-line build

- Download latest WebDSL compiler jar: http://webdsl-2015.ewi.tudelft.nl/compiler/webdsl.zip
- Extract the zip file. 
- Add the webdsl/bin directory to your path, or use the full path, and run in the project directory:
`webdsl run elib-example`

### IDE build

- Get an Eclipse with latest WebDSL pluging pre-installed at
http://buildfarm.metaborg.org/view/WebDSL/job/webdsl-eclipsegen/lastSuccessfulBuild/artifact/dist/eclipse/ or use updatesite http://webdsl.org/update to install plugin.
- Import the project into your Eclipse workspace.
- Right-click the project and select 'Convert to a WebDSL Project', click 'Finish' to use default settings.
- Build the project with ctrl+alt+b or cmd+alt+b, this will also deploy and run the application on Tomcat.
- Open the 'Servers' view to manage the Tomcat instance.



[1]: https://webdsl.org/singlepage/Download
[2]: https://webdsl.org/selectpage/Download/WebDSLplugin

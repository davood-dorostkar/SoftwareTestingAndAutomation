# Software_Testing_And_Automation_Specialization

## Java
### install JDK (java development kit)
You need this for compiling java code.
1. windows

- [windows openJDK](https://learn.microsoft.com/en-gb/java/openjdk/download)
- [other available JDK builds](https://code.visualstudio.com/docs/java/java-tutorial#_installing-a-java-development-kit-jdk)


1. linux


install latest version from apt:
```
sudo apt install default-jdk
```
if you do not need GUI development:
```
sudo apt install default-jdk
```
install specific java version:
```
sudo apt install openjdk-8-jdk-headless
```

### Install JRE (java runtime environment)
JRE is required to run java apps, but cannot help in development. if you installed JDK, JRE will be installed as well, so avoid installing or you will get conflicts. if you have JRE installed already, remove it first.

if you need to install JRE:

latest standard version:
```
sudo apt install default-jre
```
specific version:
```
sudo apt install openjdk-8-jre
```
No GUI:
```
sudo apt install openjdk-8-jre-headless
```

### install an IDE
- VSCode
  - install `Extension Pack for Java` extension
- [intelliJ Commubity version](https://www.jetbrains.com/idea/download/)
- [Eclipse](https://www.eclipse.org/downloads/packages/)

### Using JUnit
- VScode
  - hit `ctrl+shift+p`, and type `java create project` to start a project
  - in the left pane click on test icon
  - enable java testing
  - select JUnit, it will download junit and add it to project
  - open your test file and click on run icon at top right


Program that creates a java class file.

Currently WIP:
- [] Save class file to a specific folder.
- [] Change logic for extends
- [] Add package input
- [] Ask if you wou like to build a project dir.
- [x] Add input validity

To run:
```
git clone
cd JavaClassTemplate/source
javac -d ../classes net/kevinjr/*.java
cd ../classes
java net/kevinjr/Main
```
To create a JAR file:
Compile the same way as above.
Go to classes directory in the terminal and enter the following command.
`jar -cvmf manifest.txt classConstruct.jar net` 

If no errors a JAR file will be created in the classes directory.
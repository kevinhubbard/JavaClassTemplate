Program that creates a java class file.

Currently WIP:
- [] Save class file to a specific folder.
- [] Change logic for extends
- [] Add package input
- [] Ask if you would like to build a project dir.

To run:
```
git clone
cd /source
javac -d ../source net/kevinjr/*.java
cd ../classes
jar -cvmf manifest.txt classConstruct.jar net
```
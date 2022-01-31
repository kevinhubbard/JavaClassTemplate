Program that creates a java class file.

Currently WIP:
- [] Save class file to a specific folder.
- [x] Change logic for extends
- [] Add package input
- [] Ask if you wou like to build a project dir.
- [x] Add input validity

Compile: ***Must have JVM installed***
```
git clone
cd JavaClassTemplate/source
javac -d ../classes net/kevinjr/*.java
```

Run:  
```
cd ../classes; java net/kevinjr/Main
```

Create JAR:  
Compile the same way as above.  
Go to classes directory.
```
jar -cvmf manifest.txt classConstruct.jar net
``` 
If no errors a JAR file will be created in the classes directory.
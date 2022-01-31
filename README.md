Program that creates a java class file.  

Current WIP for version 2:  
- [x] Save class file to a specific folder.
- [x] Change logic for extends
- [] Add package input
- [] Build a project directory option.
- [x] Add input validity
- [] Show editable import/implement list.

Compile: ***Must have JVM installed***
```
git clone https://github.com/kevinhubbard/JavaClassTemplate.git;
cd JavaClassTemplate/source;
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
Program that creates a java class file.  

Current WIP for version 2:  
- [] Add Constructor option
- [] Build a project directory option.
- [] Show editable import/implement list.
- [] Add package input
- [] Add startup popup, demonstrating how to add info.
- [x] Updated GUI
- [x] Save class file to a specific folder.
- [x] Change logic for extends
- [x] Add input validity

Compile: ***Must have JVM installed***
```
git clone https://github.com/kevinhubbard/JavaClassTemplate.git;
cd JavaClassTemplate/source;
javac -d ../classes net/kevinjr/*.java; cd ../
```

Run:  
```
cd ./classes; java net/kevinjr/Main
```

Create JAR:  
Compile the same way as above.  
Go to classes directory.
```
jar -cvmf manifest.txt "Class Constructor".jar net
``` 
If no errors a JAR file will be created in the classes directory.
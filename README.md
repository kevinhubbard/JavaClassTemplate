Program that creates a java class file.  

Current WIP for version 2:  
- [x] Add Constructor, package and abstract class option.
- [] Build a project directory option.
- [x] Show editable import/implement list.
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

Run:  First navigate to classes/ directory.
```
java -splash:../images/ccLogo.png net/kevinjr/Main
```

Create JAR:  
Compile the same way as above.  
Go to classes directory.
```
jar -cvmf manifest.mf "Class Constructor".jar net ../images/ccLogo.png
``` 
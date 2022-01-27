import java.io.*;
import java.util.*;

public class ClassConstructor {
	String EXT = ".java";
	String className;
	String importString;
	String extendString;
	String implemString;
	boolean isMainClass;
	File file;

	public ClassConstructor(String n, boolean m, ArrayList<String> i, ArrayList<String> e, ArrayList<String> t, File f) {
		className = n;
		isMainClass = m;
		generateImportString(i);
		generateExtendString(e);
		generateImplementString(t);
		file = f;
		createFile();
	}

	public void generateImportString(ArrayList<String> imp) {
		importString = "";
		if (imp.size() == 0 ) {
			System.out.println("this class doesnt import anything.");
		} else {
			for (String obj : imp) {
				importString += "import " + obj + ";\n";
			}
			importString += "\n";
		}
	} 

	public void generateExtendString(ArrayList<String> extendList) {
		extendString = "";
		if (extendList.size() == 0 ) {
			System.out.println("this class does not extend anything.");
		} else {
			for (String parent : extendList) {
				extendString += " extends " + parent;
			}
		}
	}

	public void generateImplementString(ArrayList<String> interfaceList) {
		implemString = "";
		if (interfaceList.size() == 0 ) {
			System.out.println("this class does not implement any interfaces.");
		} else {
			implemString = " implements ";
			int test = interfaceList.size();
			for (String interfaceString : interfaceList) {
				if (test > 1) {
					implemString += interfaceString + ", ";
					test--;
				} else {
					implemString += interfaceString;
				}
			}
		}
	}

	public void createFile() {
		if (isMainClass) {
			try {
				
				PrintWriter outputFile = new PrintWriter(className + EXT);
				outputFile.print(importString);
				outputFile.print("public class " + className + extendString + implemString + " {\n\t\n");
				outputFile.print("\tpublic static void main(String[] args) {\n\t\t\n\t}\n}");
				outputFile.close();
			} catch (IOException ex) {ex.printStackTrace();}
			System.out.println("main class made");
		} else {
			try {
				
				PrintWriter outputFile = new PrintWriter(className + EXT);
				outputFile.print(importString);	
				outputFile.print("public class " + className + extendString + implemString + " {\n\t\n}");
				outputFile.close();
			} catch (IOException ex) {ex.printStackTrace();}
			System.out.println("not a main class");
		}
	}
}
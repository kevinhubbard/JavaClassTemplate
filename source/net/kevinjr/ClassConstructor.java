package net.kevinjr;

import java.io.*;
import java.util.*;

public class ClassConstructor {
	final String EXT = ".java";
	String className, importString, extendString, implemString;
	boolean isMainClass;



	public boolean validClassName(String classTestStr) {
		boolean boolTest = false;
		classTestStr.replaceAll("\\s", "");
		if (classTestStr.length() != 0) {
			boolTest = true;
		}
		return boolTest;
	}

	public boolean validExtend(String extStr) {
		boolean boolTest = false;
		if (extStr == null) {
			System.out.println("does not extend class");
		} else {
			generateExtendString(extStr);
		}
		return boolTest;
	}


	public void generateMainClass(boolean tb) {
		if (tb == true) {
			isMainClass = true;
		} else {
			isMainClass = false;
		}
	}


	public String returnS() {
		String t = "";
		if (isMainClass) {
			t = "is main class";
		} else {
			t = "not main class.";
		}
		return t;
	}




	public void generateClassString(String classStr) {
		className = classStr.substring(0,1).toUpperCase() + classStr.substring(1);
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

	public void generateExtendString(String extendInput) {
		extendString += " extends " + extendInput;
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
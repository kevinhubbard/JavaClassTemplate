package net.kevinjr;

import java.io.*;
import java.util.*;

public class ClassConstructor {
	final String EXT = ".java";
	String className, importString, extendString, implemString;
	boolean mainBool;

	ArrayList<String> importList = new ArrayList<String>();
	ArrayList<String> implementList = new ArrayList<String>();


//~~~~~~~~~~~~~~~~~~~VALIDATION METHODS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public boolean validClassName(String classTestStr) {
		boolean classTest = false;
		classTestStr = classTestStr.replaceAll("\\s", "");
		if (classTestStr.length() != 0) {
			classTest = true;
			className = classTestStr;
		}
		return classTest;
	}

	public boolean validImport(String importStr) {
		boolean importTest = false;
		importStr = importStr.replaceAll("\\s", "");
		if (importStr == null || importStr.length() == 0) {
			System.out.println("not valid import String");
		} else {
			importList.add(importStr);
			importTest = true;
		}
		return importTest;
	}

	public boolean validExtend(String extStr) {
		boolean extendTest = false;
		extStr = extStr.replaceAll("\\s", "");
		if (extStr == null || extStr.length() == 0) {
			System.out.println("not valid extend String");
		} else {
			extendString = extStr;
			extendTest = true;
		}
		return extendTest;
	}

	public boolean validImplement(String impleStr) {
		boolean impleTest = false;
		impleStr = impleStr.replaceAll("\\s", "");
		if (impleStr == null || impleStr.length() == 0) {
			System.out.println("not valid implement String");
		} else {
			implementList.add(impleStr);
			impleTest = true;
		}
		return impleTest;
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~



	public void isMainClass(boolean tb) {
		if (tb == true) {
			mainBool = true;
		} else {
			mainBool = false;
		}
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

	public void showInfo() {
		System.out.println("Class name is: " + className);
		if (mainBool) {
			System.out.println("is main Class.");
		} else {
			System.out.println("is not main class.");
		}
		if (importList.size() > 0) {
			System.out.println("Class imports: ");
			for (String i : importList) {
				System.out.print(i + " ");
			}
		} else {
			System.out.println("Does not Import anything.");
		}
		if (extendString == null || extendString.length() == 0) {
			System.out.println("Does not Extend anything.");
		} else {
			System.out.println("Class extends: " + extendString);
		}
		if (implementList.size() > 0) {
			System.out.println("Class imports: ");
			for (String l : implementList) {
				System.out.print(l + " ");
			}
		} else {
			System.out.println("Does not Implement anything.");
		}
	}

	public void createFile() {
		if (mainBool) {
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
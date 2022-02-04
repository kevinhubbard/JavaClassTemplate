package net.kevinjr;

import java.io.*;
import java.util.*;

public class ClassConstructor {
	final String EXT = ".java";
	String className, importString, extendString, implemString, saveLocation;
	boolean mainBool;
	ArrayList<String> importList = new ArrayList<String>();
	ArrayList<String> implementList = new ArrayList<String>();

//~~~~~~~~~~~~~~~~~~~VALIDATION METHODS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public boolean validName(String classTestStr) {
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
//~~~~~~~~~~~~~~~~~~~~~~~SET METHODS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public void isMainClass(boolean tb) {
		if (tb == true) {
			mainBool = true;
		} else {
			mainBool = false;
		}
	}

	public void setClassString(String classStr) {
		className = classStr.substring(0,1).toUpperCase() + classStr.substring(1);
	}

	public void setImportString(ArrayList<String> importInput) {
		if (importInput.size() == 0 ) {
			System.out.println("This class does not import anything.");
			importString = "";
		} else {
			importString = "";
			for (String obj : importInput) {
				importString += "import " + obj + ";\n";
			}
			importString += "\n";
		}
	} 

	public void setExtendString(String extendInput) {
		if (extendInput == null || extendInput.length() == 0) {
			System.out.println("This class does not extend anything.");
			extendString = "";
		} else {
			extendString = " extends " + extendInput;
		}
	}

	public void setImplementString(ArrayList<String> implementInput) {
		if (implementInput.size() == 0 ) {
			System.out.println("This class does not implement anything.");
			implemString = "";
		} else {
			implemString = " implements ";
			int test = implementInput.size();
			for (String i : implementInput) {
				if (test > 1) {
					implemString += i + ", ";
					test--;
				} else {
					implemString += i;
				}
			}
		}
	}

	public void setSaveLocation(String l) {
		saveLocation = l + "/";
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	private void resetFields() {
		className = "";
		importString = "";
		extendString = "";
		implemString = "";
		saveLocation = "";
		importList.clear();
		implementList.clear();
		mainBool = false;
	}

	public void createFile() {
		setClassString(className);
		setImportString(importList);
		setExtendString(extendString);
		setImplementString(implementList);
		if (mainBool) {
			try {
				PrintWriter outputFile = new PrintWriter(saveLocation + className + EXT);
				outputFile.print(importString);
				outputFile.print("public class " + className + extendString + implemString + " {\n\t\n");
				outputFile.print("\tpublic static void main(String[] args) {\n\t\t\n\t}\n}");
				outputFile.close();
			} catch (IOException ex) {ex.printStackTrace();}
			System.out.println("main class made");
		} else {
			try {
				PrintWriter outputFile = new PrintWriter(saveLocation + className + EXT);
				outputFile.print(importString);	
				outputFile.print("public class " + className + extendString + implemString + " {\n\t\n}");
				outputFile.close();
			} catch (IOException ex) {ex.printStackTrace();}
			System.out.println("not a main class");
		}
		resetFields();
	}
}
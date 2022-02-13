package net.kevinjr;

import java.io.*;
import java.util.*;

public class ClassConstructor {
	final static String EXT = ".java";
	private static String className, accessString, importString, extendString, implemString, constructString, saveLocation;
	private static boolean mainBool, privateBool, constructBool, dirBool;
	private static ArrayList<String> importList = new ArrayList<String>();
	private static ArrayList<String> implementList = new ArrayList<String>();

//~~~~~~~~~~~~~~~~~~~VALIDATION METHODS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public static boolean validName(String classTestStr) {
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

	public static void setupBools(boolean mb, boolean pb, boolean cb, boolean dir) {
		// CHECK FOR MAIN CLASS
		if (mb == true) {
			mainBool = true;
		} else {
			mainBool = false;
		}

		// CHECK FOR PRIVATE CLASS
		if (pb == true) {
			accessString = "private";
		} else {
			accessString = "public";
		}

		// CHECK FOR CONSTRUCTOR CLASS
		if (cb == true) {
			constructString = "\n\t//Constructor\n\tpublic " + className + "() {\n\t\n\t}";
		} else {
			constructString = "";
		}

		// CHECK FOR PROJECT DIRECTORY CREATION
		if (dir == true) {
			dirBool = true;
		} else {
			dirBool = false;
		}
	}

	public static void setClassString(String classStr) {
		className = classStr.substring(0,1).toUpperCase() + classStr.substring(1);
	}

	public static void setImportString(ArrayList<String> importInput) {
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

	public static void setExtendString(String extendInput) {
		if (extendInput == null || extendInput.length() == 0) {
			System.out.println("This class does not extend anything.");
			extendString = "";
		} else {
			extendString = " extends " + extendInput;
		}
	}

	public static void setImplementString(ArrayList<String> implementInput) {
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

	public static void setSaveLocation(String l) {
		saveLocation = l + "/";
	}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	private static void resetFields() {
		className = "";
		importString = "";
		extendString = "";
		implemString = "";
		accessString = "";
		constructString = "";
		saveLocation = "";
		importList.clear();
		implementList.clear();
		mainBool = false;
		privateBool = false;
		constructBool = false;
		dirBool = false;
	}

	public static void createFile() {
		setClassString(className);
		setImportString(importList);
		setExtendString(extendString);
		setImplementString(implementList);
		if (mainBool) {
			try {
				PrintWriter outputFile = new PrintWriter(saveLocation + className + EXT);
				outputFile.print(importString);
				outputFile.print(accessString + " class " + className + extendString + implemString + " {\n\t" + constructString + "\n");
				outputFile.print("\n\tpublic static void main(String[] args) {\n\t\t\n\t}\n}");
				outputFile.close();
			} catch (IOException ex) {ex.printStackTrace();}
			System.out.println("main class made");
		} else {
			try {
				PrintWriter outputFile = new PrintWriter(saveLocation + className + EXT);
				outputFile.print(importString);	
				outputFile.print(accessString + " class " + className + extendString + implemString + " {\n\t" + constructString + "\n}");
				outputFile.close();
			} catch (IOException ex) {ex.printStackTrace();}
			System.out.println("not a main class");
		}
		resetFields();
	}
}
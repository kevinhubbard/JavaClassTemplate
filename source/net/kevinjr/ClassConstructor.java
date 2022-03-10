package net.kevinjr;

import java.io.*;
import java.util.*;

public class ClassConstructor {
	final String EXT = ".java";
	private String packageString, importString, accessString,  className, extendString, implemString, constructString, saveLocation;
	private boolean mainBool, privateBool, constructBool, dirBool;
	private ArrayList<String> implementList = new ArrayList<String>();

//~~~~~~~~~~~~~~~~~~~VALIDATION METHODS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public boolean validateName(String classTestStr) {
		boolean classTest = false;
		classTestStr = classTestStr.replaceAll("\\s", "");
		if (classTestStr.length() != 0) {
			classTest = true;
			className = classTestStr.substring(0,1).toUpperCase() + classTestStr.substring(1);
		}
		return classTest;
	}

	public boolean validateExtend(String extStr) {
		boolean valid = false;
		extStr = extStr.replaceAll("\\s", "");
		if (extStr == null || extStr.length() == 0) {
			System.out.println("validExtend: not valid extend");
			extendString = "";
		} else {
			System.out.println("validExtend: valid extend");
			extendString =  " extends " + extStr;
			valid = true;
		}
		return valid;
	}

	public boolean validImplement(String impleStr) {
		boolean valid = false;
		impleStr = impleStr.replaceAll("\\s", "");
		if (impleStr == null || impleStr.length() == 0) {
			System.out.println("validImplement: not valid implement");
		} else {
			System.out.println("validImplement: valid implement");
			implementList.add(impleStr);
			valid = true;
		}
		return valid;
	}

	public boolean validatePackage(String packStr) {
		boolean valid = false;
		packStr = packStr.replaceAll("\\s", "");
		if (packStr == null || packStr.length() == 0) {
			System.out.println("validatePackage: no package added");
			packageString = "";
		} else {
			System.out.println("validPackage: valid package");
			packageString = "package " + packStr + ";\n\n";
			valid = true;
		}
		return valid;
	}
//~~~~~~~~~~~~~~~~~~~~~~~SET METHODS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public void setupBools(boolean mb, boolean pb, boolean cb, boolean dir) {
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

	public void setImportString(ArrayList<String> list) {
		importString = "";
		if (list.size() == 0) {
			System.out.println("This class does not import anything.");
		} else {
			for (String obj : list) {
				importString += "import " + obj + ";\n";
			}
			importString += "\n";
		}
	} 

	public void setImplementString(ArrayList<String> iList) {
		implemString = "";
		if (iList.size() == 0 ) {
			System.out.println("This class does not implement anything.");
		} else {
			implemString = " implements ";
			int test = iList.size();
			for (String i : iList) {
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
		accessString = "";
		constructString = "";
		saveLocation = "";
		implementList.clear();
		mainBool = false;
		privateBool = false;
		constructBool = false;
		dirBool = false;
	}

	public void createFile() {
		System.out.println("\n");

		setImplementString(implementList);


		if (mainBool) {
			try {
				PrintWriter outputFile = new PrintWriter(saveLocation + className + EXT);
				outputFile.print(packageString);
				outputFile.print(importString);
				outputFile.print(accessString + " class " + className + extendString + implemString + " {\n\t" + constructString);
				outputFile.print("\n\tpublic static void main(String[] args) {\n\t\t\n\t}\n}");
				outputFile.close();
			} catch (IOException ex) {ex.printStackTrace();}
			System.out.println("main class made");
		} else {
			try {
				PrintWriter outputFile = new PrintWriter(saveLocation + className + EXT);
				outputFile.print(packageString);
				outputFile.print(importString);	
				outputFile.print(accessString + " class " + className + extendString + implemString + " {\n\t" + constructString + "\n}");
				outputFile.close();
			} catch (IOException ex) {ex.printStackTrace();}
			System.out.println("not a main class");
		}
		resetFields();
	}
}
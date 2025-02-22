package net.kevinjr;

import java.io.*;
import java.util.*;

/**
* This program takes user input and creates the framework of a java file.
* 
* @author Kevin H
* @version 1.0.1
* @since 2022-01-16
*/


public class ClassConstructor {
	final String EXT = ".java";
	private String packageString = "", importString = "", accessString,  className, extendString = "", implemString = "", constructString, saveLocation, tempStr = "";;
	private boolean mainBool, privateBool, constructBool, dirBool;
	private ArrayList<String> implementList = new ArrayList<String>();

	public String getImportString() {
		return importString;
	}

	public String getAccessString() {
		return accessString;
	}

	public void setClassName(String name) {
		this.className = name.substring(0,1).toUpperCase() + name.substring(1);
	}

	public boolean validateName(String classTestStr) {
		boolean valid = false;
		classTestStr = classTestStr.replaceAll("\\s", "");
		if (classTestStr.length() != 0) {
			valid = true;
			className = classTestStr.substring(0,1).toUpperCase() + classTestStr.substring(1);
		}
		return valid;
	}

	public boolean validateExtend(String extStr) {
		boolean valid = false;
		extStr = extStr.replaceAll("\\s", "");
		if (extStr.length() != 0) {
			extendString = " extends " + extStr;
			valid = true;
		} else {
			extendString = "";
		}
		return valid;
	}

	public boolean validatePackage(String packStr) {
		boolean valid = false;
		packStr = packStr.replaceAll("\\s", "");
		if (packStr.length() != 0) {
			packageString = "package " + packStr + ";\n\n";
			valid = true;
		} else {
			packageString = "";
		}
		return valid;
	}

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
			String header = className.substring(0,1).toUpperCase() + className.substring(1);
			constructString = "\n\t//Constructor\n\tpublic " + header + "() {\n\t\n\t}";
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

/*	public void tempSet() {
		packageString = "";
		importString = "";
		extendString = "";
		implemString = "";
	}*/

	private void resetFields() {
		className = "";
		packageString = "";
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

	public boolean fileExists() {
		boolean exists = false;
		File f = new File(saveLocation+className+EXT);
		if (f.exists()) {
			System.out.println("File already Exists.");
			exists = true;
		} else {
			System.out.println("File DOes NOT EXIST.");
		}

		return exists;
	}

	public void createFile() {
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

	public String generateTempFile() {
		tempStr = "";
		if (mainBool) {
			tempStr += packageString;
			tempStr += importString;
			tempStr += accessString + " class " + className + extendString + implemString + " {\n\t" + constructString;
			tempStr += "\n\tpublic static void main(String[] args) {\n\t\t\n\t}\n}";
		} else {
			tempStr += packageString;
			tempStr += importString;
			tempStr += accessString + " class " + className + extendString + implemString + " {\n\t" + constructString + "\n}";
		}
		importString = "";
		implementList = null;
		return tempStr;
	}
}
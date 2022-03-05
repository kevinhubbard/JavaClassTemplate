package net.kevinjr;

import java.io.*;
import java.util.*;

public class ClassConstructor {
	final String EXT = ".java";
	private String className, accessString, importString, extendString, implemString, packageString, constructString, saveLocation;
	private boolean mainBool, privateBool, constructBool, dirBool;
	private ArrayList<String> importList = new ArrayList<String>();
	private ArrayList<String> implementList = new ArrayList<String>();

//~~~~~~~~~~~~~~~~~~~VALIDATION METHODS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	public boolean validName(String classTestStr) {
		boolean classTest = false;
		classTestStr = classTestStr.replaceAll("\\s", "");
		if (classTestStr.length() != 0) {
			classTest = true;
			className = classTestStr.substring(0,1).toUpperCase() + classTestStr.substring(1);
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
			System.out.println("extend string = nada");
			extendString = "";
		} else {
			extendString =  " extends " + extStr;
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

	public boolean validatePackage(String packStr) {
		boolean packTest = false;
		packStr = packStr.replaceAll("\\s", "");
		if (packStr == null || packStr.length() == 0) {
			System.out.println("not a package");
			packageString = "";
		} else {
			packageString = "package " + packStr + ";\n\n";
			packTest = true;
		}
		return packTest;
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

/*	public void setExtendString(String extendInput) {
		if (extendInput == null || extendInput.length() == 0) {
			System.out.println("This class does not extend anything.");
			extendString = "";
		} else {
			extendString = " extends " + extendInput;
		}
	}*/

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

	public void createFile() {
		setImportString(importList);
		//setExtendString(extendString);
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
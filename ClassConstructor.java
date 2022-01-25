import java.io.*;
import java.util.*;

public class ClassConstructor {
	String EXT = ".java";
	String className;
	//String importString;
	String extendString = " extends ";
	String implemString = " implements ";
	boolean isMainClass;

	ArrayList<String> importList = new ArrayList<String>();

	public ClassConstructor(String n, boolean m, ArrayList<String> i, ArrayList<String> e, ArrayList<String> t) {
		className = n;
		isMainClass = m;
		importList = i;
		generateExtendString(e);
		generateImplementString(t);
		createFile();
	}

	public void generateExtendString(ArrayList<String> extendList) {
		for (String parent : extendList) {
			extendString += parent;
		}
	}

	public void generateImplementString(ArrayList<String> interfaceList) {
		for (String interfaceString : interfaceList) {
			implemString += interfaceString + ", ";
		}
	}

	public String insertExtendString() {
		String te = "";
		if (extendString.length() > 9) {
			te = extendString;
		} else {
			System.out.println("Class did not extend anything.");
		}
		return te;
	}

	public String insertImplementString() {
		String is = "";
		if (implemString.length() > 12) {
			is = implemString;
		} else {
			System.out.println("Class did not implement anything.");
		}
		return is;
	}

	public void createFile() {
		if (isMainClass) {
			try {
				PrintWriter outputFile = new PrintWriter(className + EXT);
				if (importList.size() != 0) {
					for (String item : importList) {
						outputFile.print(item + "\n");
					}
					outputFile.println();
				}
				outputFile.print("public class " + className + insertExtendString() + insertImplementString() + "{\n\t\n");
				outputFile.print("\tpublic static void main(String[] args) {\n\t\t\n\t}\n}");
				outputFile.close();
			} catch (IOException ex) {ex.printStackTrace();}
			System.out.println("main class made");
		} else {
			try {
				PrintWriter outputFile = new PrintWriter(className + EXT);
				if (importList.size() != 0) {
					for (String item : importList) {
						outputFile.print(item + "\n");
					}
					outputFile.println();
				}	
				outputFile.print("public class " + className + insertExtendString() + insertImplementString() + "{\n\t\n}");
				outputFile.close();
			} catch (IOException ex) {ex.printStackTrace();}
			System.out.println("not a main class");
		}
	}
}
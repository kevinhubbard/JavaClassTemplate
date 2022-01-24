import java.io.*;

public class ClassConstructor {
	String EXT = ".java";
	String className;
	String importString;
	String extendString;
	String implemString;
	boolean isMainClass;

	public ClassConstructor(String n, boolean m, String i, String e, String t) {
		className = n;
		isMainClass = m;
		importString = i;
		extendString = e;
		implemString = t;
		createFile();
	}

	public void createFile() {
		if (isMainClass) {
			try {
				PrintWriter outputFile = new PrintWriter(className + EXT);
				if (importString != null) {
					outputFile.print("import " + importString + ";\n\n");
				}
				outputFile.print("public class " + className + " {\n\t\n");
				outputFile.print("\tpublic static void main(String[] args) {\n\t\t\n\t}\n}");
				outputFile.close();
			} catch (IOException ex) {ex.printStackTrace();}
			System.out.println("main class made");
		} else {
			try {
				PrintWriter outputFile = new PrintWriter(className + EXT);
				if (importString != null) {
					outputFile.print("import " + importString + ";\n\n");
				}	
				outputFile.print("public class " + className + " {\n\t\n}");
				outputFile.close();
			} catch (IOException ex) {ex.printStackTrace();}
			System.out.println("not a main class");
		}

		System.out.println("Class Name: " + className);
		System.out.println("Is main class: " + isMainClass);
		System.out.println("Imports: " + importString);
		System.out.println("Extends: " + extendString);
		System.out.println("Implements: " + implemString);
	}
}
import java.io.*;

public class ClassConstructor {
	String cName;
	String importSt;
	String extendSt;
	String implemSt;
	String EXT = ".java";
	boolean mainCl;

	public ClassConstructor(String name, boolean mainT) {
		cName = name;
		mainCl = mainT;
		createFile();
	}

	public void createFile() {
		if (mainCl) {
			try {
				PrintWriter outputFile = new PrintWriter(cName + EXT);
				outputFile.print("public class " + cName + " {\n\n");
				outputFile.print("\tpublic static void main(String[] args) {\n\n\t}\n}");
				outputFile.close();
			} catch (IOException ex) {ex.printStackTrace();}
			System.out.println("main class made");
		} else {
			try {
				PrintWriter f = new PrintWriter(cName + EXT);
				f.print("public class " + cName + "{\n\n}");
				f.close();
			} catch (IOException ex) {ex.printStackTrace();}
			System.out.println("not a main class");
		}
	}
}
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Main {

	public void start() {
		Scanner scan = new Scanner(System.in);
		String programName;
		final String EXT = ".java";

		System.out.println("Whats the programs Class name:");
		programName = scan.nextLine();

		try {
			PrintWriter outputFile = new PrintWriter(programName + EXT);
			outputFile.print("public class " + programName + " {\n");
			outputFile.print("\t public static void main(String [] args) {\n");
			outputFile.print("\t\tSystem.out.println(\"Good Work Man.\");\n");
			outputFile.print("\t}\n}");
			outputFile.close();
		} catch (IOException ex) {ex.printStackTrace();}
	}


	public static void main(String[] args) {
		new Gui();
		Main m = new Main();

		m.start();
	}
}
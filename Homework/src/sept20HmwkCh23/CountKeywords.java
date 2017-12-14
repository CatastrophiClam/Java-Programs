package sept20HmwkCh23;

import java.util.*;
import java.io.*;

public class CountKeywords {
	 public static void main(String[] args) throws Exception {
	 //Scanner input = new Scanner(System.in);
	 //System.out.print("Enter a Java source file: ");
	 String filename = args[0];
	 File file = new File(filename);
	 if (file.exists()) {
		 System.out.println("The number of keywords in " + filename
		 + " is "+ countKeywords(file));
	 }
	 else {
		 System.out.println("File " + filename + " does not exist");
	 }
 }

	 public static int countKeywords(File file) throws Exception {
		 int count = 0;
		 Scanner input = new Scanner(file);
		 while (input.hasNextLine()) {
			 String sentence = input.nextLine();
			 count += verify(sentence);
		 }
		 input.close();
		 return count;
	 }
	 
	 public static int verify(String sentence){
		 // Array of all Java keywords + true, false and null
		 String[] keywordString = {"abstract", "assert", "boolean",
		 "break", "byte", "case", "catch", "char", "class", "const",
		 "continue", "default", "do", "double", "else", "enum",
		 "extends", "for", "final", "finally", "float", "goto",
		 "if", "implements", "import", "instanceof", "int",
		 "interface", "long", "native", "new", "package", "private",
		 "protected", "public", "return", "short", "static",
		 "strictfp", "super", "switch", "synchronized", "this",
		 "throw", "throws", "transient", "try", "void", "volatile",
		 "while", "true", "false", "null"};
		 Set<String> keywordSet = new HashSet<String>(Arrays.asList(keywordString));
		 
	 }
}

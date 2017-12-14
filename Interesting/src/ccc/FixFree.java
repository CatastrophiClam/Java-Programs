package ccc;
import java.io.*;
import java.util.Scanner;

public class FixFree {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File file = new File("Test.txt.txt");
		Scanner reader = new Scanner(file);
		int numGroups = Integer.parseInt(reader.nextLine());
		String str1;
		String str2;
		String str3;
		for (int i = 0; i < numGroups; i++){
			str1 = reader.nextLine();
			str2 = reader.nextLine();
			str3 = reader.nextLine();
			if (!hasPrefix(str1, str2, str3) && !hasSuffix(str1, str2, str3)){
				System.out.print("No");
			}else{
				System.out.print("Yes");
			}
		}
		reader.close();
	}
	
	public static boolean hasPrefix(String str1, String str2, String str3){
		if (!checkAllPrefix(str1, str2)){
			if (!checkAllPrefix(str2, str3)){
				if (!checkAllPrefix(str3, str1)){
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @param str1
	 * @param str2
	 * @returns true if str1 and str2 are prefixes
	 */
	public static boolean checkAllPrefix(String str1, String str2){
		boolean hasPrefixes = true;
		if (str1.length()>str2.length()){
			for (int i = 0; i < str2.length(); i++){
				if (str2.charAt(i)!=str1.charAt(i)){
					hasPrefixes = false;
					break;
				}
			}
		}else if (str1.length()<str2.length()){
			for (int i = 0; i < str1.length(); i++){
				if (str1.charAt(i)!=str2.charAt(i)){
					hasPrefixes = false;
					break;
				}
			}
		}else{
			return str1.equals(str2);
		}
		return hasPrefixes;
	}
	
	public static boolean hasSuffix(String str1, String str2, String str3){
		if (!checkAllSuffix(str1, str2)){
			if (!checkAllSuffix(str2, str3)){
				if (!checkAllSuffix(str3, str1)){
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @param str1
	 * @param str2
	 * @returns true if str1 and str2 are prefixes
	 */
	public static boolean checkAllSuffix(String str1, String str2){
		boolean hasSuffixes = true;
		if (str1.length()>str2.length()){
			for (int i = 1; i < str2.length(); i++){
				if (str2.charAt(str2.length()-i)!=str1.charAt(str1.length()-i)){
					hasSuffixes = false;
					break;
				}
			}
		}else if (str1.length()<str2.length()){
			for (int i = 1; i < str1.length(); i++){
				if (str1.charAt(str1.length()-i)!=str2.charAt(str2.length()-i)){
					hasSuffixes = false;
					break;
				}
			}
		}else{
			return str1.equals(str2);
		}
		return hasSuffixes;
	}

}

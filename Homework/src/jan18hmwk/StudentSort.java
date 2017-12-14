package jan18hmwk;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class StudentSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		ArrayList<String> studentList = new ArrayList<String>();
		ArrayList<Integer> studentScores = new ArrayList<Integer>();
		int maximum;
		System.out.print("Enter number of students: ");
		int numStudents = scan.nextInt();
		System.out.print("Enter the names of the students : ");
		for (int i = 0; i < numStudents; i++){
			studentList.add(scan.nextLine());
		}
		System.out.print("Enter their respective scores: ");
		for (int i = 0; i < numStudents; i++){
			studentScores.add(scan.nextInt());
		}
		while(studentList.size()>0){
			maximum = Collections.max(studentScores);
			System.out.print(studentList.get(studentScores.indexOf(maximum))+": ");
			System.out.println(maximum);
			studentList.remove(studentScores.indexOf(maximum));
			studentScores.remove((Integer)maximum);
		}
	}

}

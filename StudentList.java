import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {

//		Check arguments
		if(args[0].equals("a")) {
			System.out.println("Loading data ...");			
			try {
				BufferedReader studentFileReader = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String studentNames = studentFileReader.readLine();
				String studentNameArray[] = studentNames.split(", ");
				for(String student : studentNameArray) {
					System.out.println(student);
				}
			} catch (Exception e){

			}
			System.out.println("Data Loaded.");
		}

		else if(args[0].equals("r")) {
			System.out.println("Loading data ...");			
			try {
				BufferedReader studentFileReader = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String studentNames = studentFileReader.readLine();
				char studentNameCharArray[] = studentNames.toCharArray();
				int studentNumber = 0;
				for(char c : studentNameCharArray) {
					if(c ==' ') {
						studentNumber++;
					}
				}
				String studentNameArray[] = studentNames.split(", ");
				Random rand = new Random();
				int randomStudentIndex = rand.nextInt(studentNumber + 1);
				System.out.println(studentNameArray[randomStudentIndex]);
			} catch (Exception e){

			}
			System.out.println("Data Loaded.");			
		}

		else if(args[0].charAt(0) == '+'){
			System.out.println("Loading data ...");			
			try {
				BufferedReader studentFileReader = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String studentNames = studentFileReader.readLine();
				BufferedWriter studentFileWriter = new BufferedWriter(
						new FileWriter("students.txt", false));
				String studentToAdd = args[0].substring(1);
				Date d = new Date();
				String df = "dd/mm/yyyy-hh:mm:ss a";
				DateFormat dateFormat = new SimpleDateFormat(df);
				String formattedDate= dateFormat.format(d);
				studentFileWriter.write(studentNames + ", " + studentToAdd + "\nList last updated on " + formattedDate);
				studentFileWriter.close();
			} catch (Exception e){

			}
			System.out.println("Data Loaded.");	
		}

		else if(args[0].charAt(0) == '?') {
			System.out.println("Loading data ...");			
			try {
				BufferedReader studentFileReader = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String studentNames = studentFileReader.readLine();
				String studentNameArray[] = studentNames.split(", ");
				boolean done = false;
				String studentToFind = args[0].substring(1);
				for(int idx = 0; idx<studentNameArray.length && !done; idx++) {
					if(studentNameArray[idx].equals(studentToFind)) {
						System.out.println("We found it!");
						done=true;
					}
				}
				if(!done){
					System.out.println("Student not found!");
				}
			} catch (Exception e){

			}
			System.out.println("Data Loaded.");				
		}

		else if(args[0].equals("c")) {
			System.out.println("Loading data ...");			
			try {
				BufferedReader studentFileReader = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String studentNames = studentFileReader.readLine();
				char studentNameCharArray[] = studentNames.toCharArray();
				int studentNumber = 0;
				for(char c : studentNameCharArray) {
					if(c == ' ') {
						studentNumber++;
					}
				}
				System.out.println((studentNumber + 1) +" word(s) found");
			} catch (Exception e){

			}
			System.out.println("Data Loaded.");				
		}

		else{
			System.out.println("Please enter any of these : a | c | r | +word | ?word");
		}
	}
}
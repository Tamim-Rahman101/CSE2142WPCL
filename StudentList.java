import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {

	public static String fileReader(){
		try {
			BufferedReader studentFileReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(Constants.STUDENT_FILE_NAME)));		// to read students.txt file, where all student names are saved
			 return studentFileReader.readLine();
		} catch (Exception e){

		}
		return null;
	}

	public static void fileWriter(String studentNames, String studentToAdd) {
		try {
			String formattedDate = new SimpleDateFormat(Constants.DATE_FORMAT_SYSTEM).format(new Date());		// to create a formatted date time (dd-mm-yyyy  hh-mm-ss  a)
			BufferedWriter studentFileWriter = new BufferedWriter(
					new FileWriter(Constants.STUDENT_FILE_NAME, false));		// to write on students.txt file after removing previous data

			// writes student names and the time, date when this file was modified (new name added)
			studentFileWriter.write(studentNames + Constants.SPLIT + studentToAdd + Constants.LAST_UPDATED_MESSAGE + formattedDate);
			studentFileWriter.close();
		}catch (Exception e){

		}
	}

	public static void main(String[] args) {
		if(args[0].equals(Constants.ARG_A)) {			// checks if the given argument is 'a'
			System.out.println(Constants.LOADING_MESSAGE);
			for (String student : fileReader().split(Constants.SPLIT)) {		// to print the student names of students.txt file
				System.out.println(student);
			}
			System.out.println(Constants.LOADED_MESSAGE);
		}

		else if(args[0].equals(Constants.ARG_C)) {				// checks if the given argument is 'c'
			System.out.println(Constants.LOADING_MESSAGE);
			String studentNameArray[] = fileReader().split(Constants.SPLIT);			// creates an array of string that contains student names
			System.out.println(studentNameArray.length);								// the length of the array is the total number of student
			System.out.println(Constants.LOADED_MESSAGE);
		}

		else if(args[0].equals(Constants.ARG_R)) {				// checks if the given argument is 'r'
			System.out.println(Constants.LOADING_MESSAGE);
			String studentNameArray[] = fileReader().split(Constants.SPLIT);			// creates an array of string that contains student names
			int randomStudentIndex = new Random().nextInt(studentNameArray.length);		// the length of the array is used to create a random number
			System.out.println(studentNameArray[randomStudentIndex]);					// prints the student name using the created random number
			System.out.println(Constants.LOADED_MESSAGE);
		}

		else if(args[0].charAt(0) == Constants.ARG_ADD){			// checks if the given arguments first letter is '+'
			System.out.println(Constants.LOADING_MESSAGE);
			fileWriter(fileReader(), args[0].substring(1));		// to write the new name on students.txt file
			System.out.println(Constants.LOADED_MESSAGE);
		}

		else if(args[0].charAt(0) == Constants.ARG_FIND) {			// checks of the given arguments first letter is '?'
			System.out.println(Constants.LOADING_MESSAGE);
			String studentNameArray[] = fileReader().split(Constants.SPLIT);		// creates an array of string that contains student names
			for(int idx = 0; idx<studentNameArray.length; idx++) {					// to search if the array contains the given student name
				if(studentNameArray[idx].equals(args[0].substring(1))) {
					System.out.println(Constants.FOUND_MESSAGE);
					System.out.println(Constants.LOADED_MESSAGE);
					return;
				}
			}
			System.out.println(Constants.NOT_FOUND_MESSAGE);			// gives a message if the student name not found
			System.out.println(Constants.LOADED_MESSAGE);
		}

		else{
			System.out.println(Constants.WRONG_INPUT_MESSAGE);			// gives a message if the argument is invalid
		}
	}
}
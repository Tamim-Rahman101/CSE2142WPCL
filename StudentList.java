import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {

	public static String fileReadder(){
		String studentNames = null;
		try {
			BufferedReader studentFileReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(Constants.STUDENT_FILE_NAME)));
			 studentNames = studentFileReader.readLine();
		} catch (Exception e){

		}
		return studentNames;
	}

	public static void fileWriter(String studentNames, String studentToAdd) {
		try {
			Date date = new Date();
			String df = Constants.DATE_FORMAT_SYSTEM;
			DateFormat dateFormat = new SimpleDateFormat(df);
			String formattedDate= dateFormat.format(date);
			BufferedWriter studentFileWriter = new BufferedWriter(
					new FileWriter(Constants.STUDENT_FILE_NAME, false));
			studentFileWriter.write(studentNames + Constants.SPLIT + studentToAdd + Constants.LAST_UPDATED_MESSAGE + formattedDate);
			studentFileWriter.close();
		}catch (Exception e){

		}
	}

	public static void main(String[] args) {

//		Check arguments
		if(args[0].equals(Constants.ARG_A)) {
			System.out.println(Constants.LOADING_MESSAGE);
			String studentNames = fileReadder();
			String studentNameArray[] = studentNames.split(Constants.SPLIT);
			for(String student : studentNameArray) {
				System.out.println(student);
			}
			System.out.println(Constants.LOADED_MESSAGE);
		}

		else if(args[0].equals(Constants.ARG_R)) {
			System.out.println(Constants.LOADING_MESSAGE);
			String studentNames = fileReadder();
			char studentNameCharArray[] = studentNames.toCharArray();
			int studentNumber = 0;
			for(char c : studentNameCharArray) {
				if(c == Constants.SPACE) {
					studentNumber++;
				}
			}
			String studentNameArray[] = studentNames.split(Constants.SPLIT);
			Random rand = new Random();
			int randomStudentIndex = rand.nextInt(studentNumber + 1);
			System.out.println(studentNameArray[randomStudentIndex]);
			System.out.println(Constants.LOADED_MESSAGE);
		}

		else if(args[0].equals(Constants.ARG_C)) {
			System.out.println(Constants.LOADING_MESSAGE);
			String studentNames = fileReadder();
			char studentNameCharArray[] = studentNames.toCharArray();
			int studentNumber = 0;
			for(char c : studentNameCharArray) {
				if(c == Constants.SPACE) {
					studentNumber++;
				}
			}
			System.out.println((studentNumber + 1) + Constants.COUNTED_WORD_MESSAGE);
			System.out.println(Constants.LOADED_MESSAGE);
		}

		else if(args[0].charAt(0) == Constants.ARG_ADD){
			System.out.println(Constants.LOADING_MESSAGE);
			String studentNames = fileReadder();
			String studentToAdd = args[0].substring(1);
			fileWriter(studentNames, studentToAdd);
			System.out.println(Constants.LOADED_MESSAGE);
		}

		else if(args[0].charAt(0) == Constants.ARG_FIND) {
			System.out.println(Constants.LOADING_MESSAGE);
			String studentNames = fileReadder();
			String studentNameArray[] = studentNames.split(Constants.SPLIT);
			boolean done = false;
			String studentToFind = args[0].substring(1);
			for(int idx = 0; idx<studentNameArray.length && !done; idx++) {
				if(studentNameArray[idx].equals(studentToFind)) {
					System.out.println(Constants.FOUND_MESSAGE);
					done=true;
				}
			}
			if(!done){
				System.out.println(Constants.NOT_FOUND_MESSAGE);
			}
			System.out.println(Constants.LOADED_MESSAGE);
		}

		else{
			System.out.println(Constants.WRONG_INPUT_MESSAGE);
		}
	}
}
import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {

	public static String fileReadder(){
		try {
			BufferedReader studentFileReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(Constants.STUDENT_FILE_NAME)));
			 return studentFileReader.readLine();
		} catch (Exception e){

		}
		return null;
	}

	public static void fileWriter(String studentNames, String studentToAdd) {
		try {
			String formattedDate = new SimpleDateFormat(Constants.DATE_FORMAT_SYSTEM).format(new Date());
			BufferedWriter studentFileWriter = new BufferedWriter(
					new FileWriter(Constants.STUDENT_FILE_NAME, false));
			studentFileWriter.write(studentNames + Constants.SPLIT + studentToAdd + Constants.LAST_UPDATED_MESSAGE + formattedDate);
			studentFileWriter.close();
		}catch (Exception e){

		}
	}

	public static void main(String[] args) {
		if(args[0].equals(Constants.ARG_A)) {
			System.out.println(Constants.LOADING_MESSAGE);
			for (String student : fileReadder().split(Constants.SPLIT)) {
				System.out.println(student);
			}
			System.out.println(Constants.LOADED_MESSAGE);
		}

		else if(args[0].equals(Constants.ARG_R)) {
			System.out.println(Constants.LOADING_MESSAGE);
			int studentNumber = 0;
			for(char c : fileReadder().toCharArray()) {
				if(c == Constants.SPACE) {
					studentNumber++;
				}
			}
			String studentNameArray[] = fileReadder().split(Constants.SPLIT);
			int randomStudentIndex = new Random().nextInt(studentNumber + 1);
			System.out.println(studentNameArray[randomStudentIndex]);
			System.out.println(Constants.LOADED_MESSAGE);
		}

		else if(args[0].equals(Constants.ARG_C)) {
			System.out.println(Constants.LOADING_MESSAGE);
			int studentNumber = 0;
			for(char c : fileReadder().toCharArray()) {
				if(c == Constants.SPACE) {
					studentNumber++;
				}
			}
			System.out.println((studentNumber + 1) + Constants.COUNTED_WORD_MESSAGE);
			System.out.println(Constants.LOADED_MESSAGE);
		}

		else if(args[0].charAt(0) == Constants.ARG_ADD){
			System.out.println(Constants.LOADING_MESSAGE);
			fileWriter(fileReadder(), args[0].substring(1));
			System.out.println(Constants.LOADED_MESSAGE);
		}

		else if(args[0].charAt(0) == Constants.ARG_FIND) {
			System.out.println(Constants.LOADING_MESSAGE);
			String studentNameArray[] = fileReadder().split(Constants.SPLIT);
			boolean done = false;
			for(int idx = 0; idx<studentNameArray.length && !done; idx++) {
				if(studentNameArray[idx].equals(args[0].substring(1))) {
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
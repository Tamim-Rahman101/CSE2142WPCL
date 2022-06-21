import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {

//		Check arguments
		if(args[0].equals("a")) {
			System.out.println("Loading data ...");			
			try {
				BufferedReader s = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String r = s.readLine();
				String i[] = r.split(", ");
				for(String j : i) {
					System.out.println(j);
				}
			} catch (Exception e){

			}
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) {
			System.out.println("Loading data ...");			
			try {
				BufferedReader s = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String r = s.readLine();
				char a[] = r.toCharArray();
				int count=0;
				for(char c:a) {
					if(c ==' ') {
						count++;
					}
				}
				String i[] = r.split(", ");
				Random x = new Random();
				int y = x.nextInt(count + 1);
				System.out.println(i[y]);
			} catch (Exception e){

			}
			System.out.println("Data Loaded.");			
		}
		else if(args[0].charAt(0) == '+'){
			System.out.println("Loading data ...");			
			try {
				BufferedReader sr = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String r = sr.readLine();
				BufferedWriter s = new BufferedWriter(
						new FileWriter("students.txt", false));
				String t = args[0].substring(1);
				Date d = new Date();
				String df = "dd/mm/yyyy-hh:mm:ss a";
				DateFormat dateFormat = new SimpleDateFormat(df);
				String fd= dateFormat.format(d);
				s.write(r + ", " + t + "\nList last updated on " + fd);
				s.close();
			} catch (Exception e){

			}
			System.out.println("Data Loaded.");	
		}
		else if(args[0].charAt(0) == '?') {
			System.out.println("Loading data ...");			
			try {
				BufferedReader s = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String r = s.readLine();
				String i[] = r.split(", ");
				boolean done = false;
				String t = args[0].substring(1);
				for(int idx = 0; idx<i.length && !done; idx++) {
					if(i[idx].equals(t)) {
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
				BufferedReader s = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String D = s.readLine();
				char a[] = D.toCharArray();
				int count=0;
				for(char c:a) {
					if(c ==' ') {
						count++;
					}
				}
				System.out.println((count + 1) +" word(s) found");
			} catch (Exception e){

			}
			System.out.println("Data Loaded.");				
		}
		else{
			System.out.println("Please enter any of these : a | c | r | +word | ?word");
		}
	}
}
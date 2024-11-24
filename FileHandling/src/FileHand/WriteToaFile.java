package FileHand;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToaFile {
	public static void main(String[] args) throws IOException {
		String path = "C:\\Users\\Kajal\\Desktop\\FileHandlingExam\\kajal1.txt";
		FileWriter fWriter =null;
		try {
			File file = new File(path);
		    fWriter = new FileWriter(file);
		    fWriter.write("File in java are seriously good!");
		    System.out.println("Successfully written.");
			
		} catch (Exception e) {
			System.out.println("An error has occured.");
			e.printStackTrace();
		}
		finally {
			fWriter.close();
		}
	}

}

package FileHand;

import java.io.File;

public class DeleteAFile {
	public static void main(String[] args) {
		String path = "C:\\Users\\Kajal\\Desktop\\FileHandlingExam\\sample.txt.txt";
	    
		File file = new File(path);
		if(file.delete()) {
			System.out.println("The deleted file is : " + file.getName());
		}
		else {
			System.out.println("Failed in deleting the file.");
		}
		
	}
}

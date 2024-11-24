package FileHand;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadAFile {
	public static void main(String[] args) throws IOException {
		String path = "C:\\Users\\Kajal\\Desktop\\FileHandlingExam\\kajal1.txt"; 
		FileInputStream fipStream=null;
		try {
			File file = new File(path);
			fipStream = new FileInputStream(file);
			System.out.println("File content is : ");
			
			int c=0;
			while((c=fipStream.read())!=-1) {
				System.out.print((char)c);
			}
			
		} catch (Exception e) {
			System.out.println("Some error exception...");
			e.printStackTrace();
		
		}
		finally {
			fipStream.close();
		}
	}
}

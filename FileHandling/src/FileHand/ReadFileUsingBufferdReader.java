package FileHand;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileUsingBufferdReader {
	public static void main(String[] args) throws IOException {
		String path = "C:\\Users\\Kajal\\Desktop\\FileHandlingExam\\kajal1.txt";
		BufferedReader bReader = null;
		try {
			File file = new File(path);
			bReader = new BufferedReader(new FileReader(file));
			System.out.println("File content is: ");

			int c = 0;
			while ((c = bReader.read()) != -1) {
				System.out.print((char) c);
			}

		} catch (Exception e) {
			System.out.println("Some error exception..");
			e.printStackTrace();
		} finally {
			bReader.close();
		}
	}

}

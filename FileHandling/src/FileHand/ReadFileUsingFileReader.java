package FileHand;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileUsingFileReader {
	public static void main(String[] args) throws IOException {
		String path = "C:\\Users\\Kajal\\Desktop\\FileHandlingExam\\kajal1.txt";
		FileReader fReader = null;
		try {
			File file = new File(path);
			fReader = new FileReader(file);
			System.out.println("File content is :");

			int c = 0;
			while ((c = fReader.read()) != -1) {
				System.out.print((char) c);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fReader.close();
		}
	}
}

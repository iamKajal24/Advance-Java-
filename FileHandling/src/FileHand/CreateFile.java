package FileHand;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/*
 * Create a file in java using :
 * 1. file
 * 2. fileOutStream
 * 3. Java NIO utils
 * @author kajal
 */

public class CreateFile {
	public static void main(String[] args) {

		String path = "C:\\Users\\Kajal\\Desktop\\FileHandlingExam\\kajal.txt";

//		1. using file
//		File objFile = new File(path);
//		try {
//			boolean flag = objFile.createNewFile();
//			if (flag) {
//				System.out.println("file is created");
//			} else {
//				System.out.println("file is alredy prsent...");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

// **********************************************************************
		// 2. fileOutputStream along with scanner

//		try {
//			Scanner scanner = new Scanner(System.in);
//			System.out.println("Enter the file name with location path : ");
//			String fileName = scanner.nextLine();
//
//			FileOutputStream foStream = new FileOutputStream(fileName, true);
//			System.out.println("enter the file content :");
//			String content = scanner.nextLine();
//			byte b[] = content.getBytes();
//			foStream.write(b);
//			foStream.close();
//			System.out.println("file is saved on the given location path :");
//
//		} catch (Exception e) {
//			System.out.println("some exception is comimg....");
//			e.printStackTrace();
//		}
		
		
//******************************************************************************

		// 3. java nio package

		try {
			Path location = Paths.get("C:\\Users\\Kajal\\Desktop\\FileHandlingExam\\gfg.txt");
			Path newpath  =   Files.createFile(location);
			System.out.println("new file created at : " + newpath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

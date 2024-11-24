package FileHand;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.SequenceInputStream;

public class MergeFile {
	public static void main(String[] args) {
		String file1 = "C:\\Users\\Kajal\\Desktop\\FileHandlingExam\\kajal1.txt";
		String file2 = "C:\\Users\\Kajal\\Desktop\\FileHandlingExam\\createfile.txt";
		String mergeFile ="C:\\Users\\Kajal\\Desktop\\FileHandlingExam\\gfg.txt"; 
		try {
			FileInputStream f1 = new FileInputStream(file1);
			FileInputStream f2 = new FileInputStream(file2);
			FileOutputStream foutput = new FileOutputStream(mergeFile);
			
			SequenceInputStream combo= new SequenceInputStream(f1,f2);
			int j;
			while((j=combo.read())!=-1) {
				foutput.write(j);
			}	
			combo.close();
			System.out.println("succefully merge file ");
			f1.close();
			f2.close();
		} catch (Exception e) {
			System.out.println("Some error exception...");
			e.printStackTrace();
		}
		
	}
}

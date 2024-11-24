package FileHand;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyContentFromAnotherFile {
    public static void main(String[] args) {
        String sourcePath = "C:\\Users\\Kajal\\Desktop\\FileHandlingExam\\kajal1.txt";
        String destinationPath = "C:\\Users\\Kajal\\Desktop\\FileHandlingExam\\createfile.txt";

        // Use try-with-resources for automatic resource management
        try (FileInputStream read = new FileInputStream(sourcePath);
             FileOutputStream write = new FileOutputStream(destinationPath)) {

            // Read and write data byte by byte
            int c;
            while ((c = read.read()) != -1) {
                write.write(c);
            }

            System.out.println("Data Copied Successfully!");

        } catch (FileNotFoundException e) {
            System.err.println("Error: One of the specified files was not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error: An I/O error occurred while copying the file.");
            e.printStackTrace();
        }
    }
}

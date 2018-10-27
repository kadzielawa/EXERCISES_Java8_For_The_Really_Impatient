package Java_8_for_impatient_EXERCISES.Chapter1_Lambdas;

import java.io.File;
import java.util.Scanner;

/**
 * Using the list(FilenameFilter) method of the java.io.File class, write a method
 that returns all files in a given directory with a given extension. Use a lambda
 expression, not a FilenameFilter . Which variables from the enclosing scope does
 it capture?
 */

public class Exercise3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pass the path to scanning directory");
        String path = scanner.nextLine();
        File dir = new File(path);

        System.out.println("Pass the extension");
        String extension = scanner.nextLine();

        String[] paths;

        paths =  dir.list(
                (filePath,fileName) -> {
                    return fileName.toLowerCase().endsWith(extension);
                }
        );

        for (String file : paths) {
            System.out.println(file);
        }
    }
}

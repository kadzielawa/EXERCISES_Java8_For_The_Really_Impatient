package Java_8_for_impatient_EXERCISES.Chapter1_Lambdas;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Using the listFiles(FileFilter) and isDirectory methods of the java.io.File class,
 write a method that returns all subdirectories of a given directory. Use a
 lambda expression instead of a FileFilter object. Repeat with a method
 expression
 */
public class Exercise2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pass the path to scanning directory");
        String path;
        path = scanner.nextLine();
        File dir = new File(path);
        ArrayList<String> subdirectories = new ArrayList<>();
        File[] subDirs =  dir.listFiles(
                file-> file.isDirectory()
        );

        for (File file : subDirs) {
            System.out.println(file.getName());
        }
    }
}

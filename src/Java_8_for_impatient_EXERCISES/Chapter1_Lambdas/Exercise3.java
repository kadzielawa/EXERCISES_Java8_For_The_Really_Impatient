package Java_8_for_impatient_EXERCISES.Chapter1_Lambdas;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

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

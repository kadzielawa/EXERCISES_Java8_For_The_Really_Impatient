package Java_8_for_impatient_EXERCISES.Chapter1_Lambdas;

import java.io.File;
import java.util.Arrays;
/**
 * Given an array of File objects, sort it so that the directories come before the files,
 * and within each group, elements are sorted by path name. Use a lambda expression,
 * not a Comparator.
 *
 */

public class Exercise4 {
 
    public void sortByLamda(String path) {
        File files = new File(path);
        File[] myFiles = files.listFiles();
        Arrays.asList(myFiles).forEach(System.out::println);
        Arrays.sort(
                myFiles, (a, b) -> {
                    if ((a.isDirectory() && b.isFile())) {
                        return -1;
                    } else if (a.isFile() && b.isDirectory()) {
                        return 1;
                    } else {
                        return a.getName().compareTo(b.getName());
                    }
                });
        Arrays.asList(myFiles).forEach(System.out::println);
    }

    public static void main(String[] args) {
        Exercise4 ex4 = new Exercise4();
        ex4.sortByLamda(".");
    }
}
package AssignmentSeven;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Q3 {
    /*Q3. Write a program that will count the number of lines in each file that is specified on the command line.

    Assume that the files are text files.

    Note that multiple files can be specified, as in "java LineCounts file1.txt file2.txt file3.txt". Write each file name,
    along with the number of lines in that file, to standard output. If an error occurs while trying to read from one of the files,
    you should print an error message for that file, but you should still process all the remaining files.*/

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length == 0) {
            System.out.println("Empty");
            return;
        }

        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i] + "the number of lines is : ");
            countLines(args[i]);
        }
    }

    private static void countLines(String fileName) throws FileNotFoundException {
        BufferedReader input = new BufferedReader(new FileReader(fileName));
        int count = 0;
        try {
            String line = input.readLine();
            while (line != null) {
                count++;
                line = input.readLine();
            }
        } catch (IOException e) {
            System.out.println("Problem with reading the file.");
            return;
        }
        System.out.println(count);
    }
}

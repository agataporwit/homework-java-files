package filenumbers;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Write a program that counts occurrences of a given integer in a given file.
 * Integers in file are supposed to be stored in a simple format: one integer
 * per line. The program must ask user to input the name of the text file to be
 * analyzed. a. Display a small menu, like this one: Enter file name OR enter
 * STOP to quit the program. If a file with the name provided by the user does
 * not exist, the user must be notified AND asked to input the correct file
 * name. If the user enters "STOP" - the whole program must quit. b. Use input
 * validation loop and exceptions mechanism to validate the file name. 2. Next
 * ask the user to enter an integer to search for and count occurrences of. Use
 * input validation loop to validate the type of user input. 3. Open the file
 * with the given name. Use try/catch block to handle any exceptions that may
 * occur. All the file processing code must be placed in the try block. 4. File
 * is supposed to contain only integers, one number per line of text. But you
 * cannot assume that the structure of the file is always correct. When you read
 * the next line of text file, try parsing it into integer. If an exception
 * occurs - just skip the line and continue with the next iteration of your
 * file-reading loop. There is no need to inform the user when such an exception
 * happens. 5. As you read the numbers, count the occurrences of the integer
 * provided by the user. Output the number of occurrences into the screen when
 * file ends. 6. Debugging: You can create your own text file with a very simple
 * structure to make debugging easier. Make sure to test your code on files with
 * perfect structure as well as files that have non-integers appearing on some
 * of the strings. * Name your solution file FileNumbers.java.
 *
 *
 * /**
 *
 * @author agatajelen
 *
 */
public class FileNumbers  {

    public static void main(String[] args) {
        //Scanner object to read from the console
        boolean go = true;  
        try {
            //calling our file analyzing method that throws an IOException
            readingFile("Please enter a numeric value OR\n enter 'STOP' to terminate");
            go = false;
            //catching, if any, IOExceptions
        } catch (IOException e) {

            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

    }
// reading file, throws exceptions 
    public static void readingFile(String prompt)
            throws IOException {
        Scanner input = new Scanner(System.in);
        String fileName;
        File f;
        //do while loop
        do {
            System.out.println("Enter File name OR \nEnter 'STOP' to quite the program.");
            fileName = input.nextLine();
            //getting the user input that is of the file name to be processed
            //path of this file
            f = new File(fileName);

            //finding if this file exists, if not ask the user again 
            if (!f.exists() && !fileName.equals("STOP")) {
                System.out.println(fileName + " does not exist\n");
            }
            if (fileName.equals("STOP")) {
                System.exit(0);
            }

            //if the user input equals 'STOP' the program is then terminated
        
        } while (!f.exists());

        //validating user input
        int validInput, counter = 0;

        do {
            System.out.println("Please enter a numeric value:");
            while (!input.hasNextInt()) {

                if (input.next().equals("STOP")) {
                    System.exit(0);
                }
                System.out.println("That is not a number");

                
            }
            if (fileName.equals("STOP")) {
                System.exit(0);
            }

            validInput = input.nextInt();
        } while (validInput == 0);

        Scanner reader = new Scanner(f);

        //analyzing the file that the user chose, all within the try-block
        //Parsing each line of this file
        //if the value is not a number skip to next line
        int t;
        String text;

        while (reader.hasNext()) {
            //reading the file : line by line
            text = reader.nextLine();
          //parsing int
            
            try {
                t = Integer.parseInt(text);
                if (validInput == t) {
                    counter++;
                }
            } 
            catch (NumberFormatException e) {
            }
        }

        //printing number of occurrences
        System.out.println(counter);
    }
}
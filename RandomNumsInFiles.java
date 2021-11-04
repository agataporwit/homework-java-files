package randomnumsinfiles;

import java.util.Scanner; //Utility Scanner imported for collecting user feedback
import java.io.*;//java.io added to handle exceptions as they arise
import java.util.Random;//java utility for random number generation

/**
 * @author Agata Jelen  2018
 * 
 * Algorithm Notes: The main method requests a file name from the user to save the file for analyzing later. 
 * The user then receives prompts for howMany, rangeFrom and rangeTo, which call the validateInt method to
 * ensure that proper values are input. Once the appropriate integers are returned, they are sent into 
 * the randomNumbsFile method to generate random numbers to the user's specifications.
 * 
 * From randomNumbsFile a new file is created and a for loop is established starting at 0 and 
 * incrementing by one until the loop reaches the user's howMany count provided by the user. 
 * The random number generator takes the rangeTo value to calculate the maximum number available 
 * and adds the rangeTo value for the minimum value (to ensure the numbers remain between these parameters). 
 * Each time the loop iterates the values are printed into the new file. Upon completion the file is closed.
 * 
 * The main method calls the second method fileAnalysis. 
 * This method requests a fileName from the user (as Part 2 requests, however this is commented out to ensure 
 * Part 3 functions properly), then scans the file for integers and counts the number of integers, the sum of 
 * those integers and evaluates the greatest and smallest integer from the file. Upon completion of the processing, the user is prompted for a name to save the analysis file in. Then this file is created and PrintWriter outputs (prints) the name of the file, number of integers in the file and the largest and smallest integers in the random number file. 
 * I have commented out part of the assignment, to allow the fileName originally provided in the main method, to be called into the method for file analysis bypassing the request for a file name. If you choose to remove the comments, there is a duplicate Scanner input (same variable name) down at line 152.
 * 
 */
public class RandomNumsInFiles {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws IOException {
        //String fileName declared for opening and writing to the file
        String fileName;
        //String inputFileName declared for part two where the user is prompted for the name of the file. Commented out for running the current analysis on the first fileName to reduce redundancy.
        String inputFileName=null;
        //String outputFileName declared for fileAnalysis
        String outputFileName=null;


        //Scanner keyboard added to collect user input
        Scanner keyboard = new Scanner(System.in);
        //User is prompted to input the file name
        System.out.print("What would you like to name the file? ");
        //User imput is collected and trimmed and assigned to fileName
        fileName = keyboard.next().trim();

        //int howMany declared calling validateInt method with prompt for number (quantity) of numbers to generate
        int howMany = validateInt("How many random numbers would you like to generate? ");
        //int rangeFrom declared calling validateInt method with prompt for the lowest possible random number to generate
        int rangeFrom = validateInt("Which number should be the lowest possible to generate? ");
        //int rangeTo declared calling validateInt method with prompt for the maximum possible random number to generate
        int rangeTo = validateInt("Which number should be the largest possible to generate? ");
        
        //try statement added for randomNumbsFile method
        try {
            //method is called with user input from above
            randomNumbsFile(fileName, howMany, rangeFrom, rangeTo);
        }//catch statement added to catch any IOExceptions in the method 
        catch (IOException e) {
            //System output error message
            System.out.print("ERROR:");
            //Exception generated output message for the error
            System.out.print(e.getMessage());
        }
        //int b commented out for part 2 -
       // int b = fileAnalysis(inputFileName, outputFileName);
        
        //method is called using fileName provided from user passed as an argument to the method fileAnalysis
        int b = fileAnalysis(fileName, outputFileName);
        //Output for the total number of integers found in the file
        System.out.printf("\nThat file had %d integers!", b);
    }

    /**
     *
     * @param fileName - fileName from main is passed as a parameter into the method
     * @param howMany - the number of random numbers to be generated is passed as a parameter into the method
     * @param rangeFrom - the minimum number to be generated from the random number generation is passes as a parameter into the method
     * @param rangeTo - the maximum number to be generated from the random number generator is passed as a parameter into the method.
     * @throws FileNotFoundException
     */
    public static void randomNumbsFile(String fileName, int howMany, int rangeFrom, int rangeTo) throws IOException {
        //file is opened
        File file = new File(fileName);

        // PrintWriter declared to write into the file
        PrintWriter outputFile = new PrintWriter(file);
        //for loop started to generate and print out random numbers starting at 0 and up to the number specified by the user as howMany to output, incrementing by one each loop.
        for (int i = 0; i < howMany; i++) {
            //random number object declared
            Random rand = new Random();
            //int randomNum declared to store the output from the random number generation
            int randomNum = rand.nextInt(rangeTo) + rangeFrom;
            //random numbers are printing on lines to the file
            outputFile.println(randomNum);
        }
        //file is closed
        outputFile.close();
    }
/**
 * 
 * @param inputFileName - the name of the file with the random numbers (or user specified number)
 * @param outputFileName - the name of the output file for saving file analysis
 * @return - this method returns the sum of the integers in the file
 * @throws IOException 
 */
    public static int fileAnalysis(String inputFileName, String outputFileName) throws IOException {
        //int intCounter is declared to count the number of integers in the file
        int intCounter = 0;
        //int intSum is declared to total the amounts of the integers
        int intSum = 0;
        //int greatestInt declared and initialized to hold the value of the greatest generated number
        int greatestInt = 0;
        //int leastInt is declared and initialized to hold the value of the smallest generated number
        int leastInt = 0;
        //int tempInt declared to compare the values to determine the greatest and smallest int
        int tempInt;

        /*The following code was added for part two where we are to prompt the user for an input name
        //scanner input added to read the file name to open from the user for String inputFileName
          Scanner input = new Scanner(System.in);
        //Prompt is provided to user for the file name
          System.out.print("What is the name of the file you would like to open? ");
        //user input is assigned to String inputFileName
          inputFileName = input.next();*/
        
        //file is opened for reading
        File file = new File(inputFileName);
        //scanner is added to read the content from within the file
        Scanner readFile = new Scanner(file);
        //for loop added starting at 0, incrementing by one, until the readFile runs out of lines to read
        for (int i = 0; readFile.hasNextLine(); i++) {
            //String convert the lines read into a string
            String tmp = readFile.nextLine();
               //int k formats the string into integer format
                int k = Integer.parseInt(tmp);
                //if successful int counter increments for each int found
                intCounter++;
                //sum adds to the total the value of the integer
                intSum += k;
                //if statement used for the initial value to ensure the greatest and least is the first random number
                if (i == 0) {
                    //greatest is assigned value of k
                    greatestInt = k;
                    //least is assigned value of k
                    leastInt = k;
                    }
                //else statement added for the remaining random numbers for comparison of greatest and least
                else {
                    //temp holds the value of k
                    tempInt = k;
                    //if temp is greater than or equal to the greatestInt
                    if (tempInt >= greatestInt) {
                        //greatestInt is assigned the value of tempInt (or k)
                        greatestInt = tempInt;
                    }//if else statement is used for if the tempInt is smaller than or equal to the leastInt 
                    else if (tempInt <= leastInt) {
                        //leastInt is assigned the value of tempInt or k
                        leastInt = tempInt;
                    }

                }
        }
        //Scanner is added to store the user's input for saving the analysis file
        Scanner output=new Scanner(System.in);
        //User is prompted for a fileName to save the analysis to
        System.out.print("What would you like to call the output file? ");
        //user input is assigned to outputFileName
        outputFileName = output.next();
        
        //try statement for opening the output file
        try{//PrintWriter outputDocument is declared while opening the new file outputFileName
            PrintWriter outputDocument = new PrintWriter(new File(outputFileName));
            //if the file name is correct, the remainder of this try statement will execute
        //The initial fileName for the file being scanned is printed on a line with corresponding output
        outputDocument.println("Numeric Data File Name: "+inputFileName);
        //the Number of random numbers generated in the file are printed on a line with corresponding output
        outputDocument.println("Number of Integers in file: "+intCounter);
        //the sum of those random numbers is printed on a line with corresponding output
        outputDocument.println("The total of all integers in file: "+intSum);
        //the largest random number integer is printed on a line with corresponding output
        outputDocument.println("The largest integer in the set: "+greatestInt);
        //the smallest random number integer is printed on a line with corresponding output
        outputDocument.println("The smallest integer in the set: "+leastInt);
        //the document is closed
        outputDocument.close();}
        
        //catch statement for if the program encounters an exception when opening the document
        catch(IOException e)
        {//error message is output to the user
         System.out.printf("Invalid File Name! Error: %s",e.getMessage());
        //0 is returned
        return 0;
        }
        
        //the total number of integers is returned to the main method
        return intCounter;
    }
/**
 * 
 * @param prompt - this is the prompts for the integers for int howMany (number of randomNumbers generated), int rangeFrom for the lowest possible random number to be generated, and rangeTo for the maximum possible random number to be generated
 * @return - appropriately parsed integers from the user input
 * @throws NumberFormatException 
 */
   public static int validateInt(String prompt) throws NumberFormatException {
        //boolean runMethod declared to run the program until valid integer is obtained
        boolean runMethod = true;
        //scanner for collecting user feedback for var n
        Scanner input = new Scanner(System.in);
        //int n initialization
        int n = 0;
        //while loop started for validating the integer
        while (runMethod) {
            //system prompt output to user for input
            System.out.print(prompt);
            //userInput string declared for user input for integer, trimmed to remove excess whitespace
            String userInput = input.next().trim();
            //try statement added to format string to integer
            try {
                //Integer parsing to change userInput format from string to integer
                n = Integer.parseInt(userInput);
                //if no exception is caught, loop ends and returns the value for n
                runMethod=false;
            } //catch statement added for input that cannot be parsed to integer
            catch (NumberFormatException e) {
                //error message from inputValidation file
                System.out.println("INPUT ERROR: Please enter an integer number!!");
                //error message from exception displayed
                System.out.println(e.getMessage());
                //method loops for integer value
                runMethod = true;
            }
        }
        //once correct integer input is received, value for int n is returned to main
        return n;
}
}
package fileanalysismethod;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 *
 */
public class FileAnalysisMethod
{
    /**Method opens provided file and reads its data for integer numbers
     * then makes a report if input file was found and wasn't empty
     * In report included value of numbers, total sum of integers, highest number, an lowest number
     * Method ignores all not-integer numbers in the input file
     * 
     * @param inputFileName is name of the file from where our program will read data
     * @param outputFileName is the file where program writes a report about analyzing data from input file
     * @return 0 if input file is not found
     * @throws IOException 
     */
public static  int fileAnalysis (String inputFileName, String outputFileName) throws IOException
{
    int total = 0; //for total sum
    int number = 0; //  for random generator
    int counter = 0; // value of numbers
    int max = Integer.MIN_VALUE; // the highest number
    int min = Integer.MAX_VALUE;   //// the lowest number   
    File inFile = new File(inputFileName);
    Scanner inputfile = new Scanner(inFile);
    // check if the file exist
    if(inFile.exists())
        {
            // file is found
            System.out.println("Reading data from file "+ inputFileName); 
        }
        else
        {
            //Exit from program. File was not found
            System.out.println("File with the name "+ inputFileName + " does not exist. Quit.");
            return 0;
        }
    // set up a loop until there is no any integer in a file
    while(inputfile.hasNext())
    {
        // check if on the next line is integer
        if (inputfile.hasNextInt())
        {
            number = inputfile.nextInt(); // assign to the current number
            total += number; // update sum 
            counter++; // count the integer
            //verify if number greater than max
            if(max < number)
            {
                max = number; // update max
            }
            //verify if number lower than min
             if(min > number)
            {
                min = number; // update min
            }
        }
        else
        {
            inputfile.next(); // ignores not integer data in the file
        }
    }
    System.out.println("Data was sucsesfully read");
    inputfile.close(); // close input file
    PrintWriter outputFile = null; // create new PrintWriter
    try
    {
        File outfile = new File(outputFileName);
        outputFile = new PrintWriter(outfile);
        if(outfile.exists())
        {
            System.out.println("This file with name "+ outputFileName +" already exist."+
                                        "Its content will be replaced"); // notice about replacing
        }
        else
        {
            System.out.println("Create a new file with name "+ outputFileName);
        }
        // Print out report int the output file
        outputFile.println("Numeric data file name: " + inputFileName);
        outputFile.println("Number of integers: " + counter);
        outputFile.println("The total of all integers in file: " + total);
        outputFile.println("The largest integer in the set: " + max);
        outputFile.println("The smallest integer in the set: "+ min);        
    }
   
    catch(FileNotFoundException e)
    {
        System.out.println("Error: file not found!");
        System.out.println(e.getMessage());
    }
     catch(IOException e)
    {
        System.out.println("Error: something went wrong");
        System.out.println(e.getMessage());
    }
    finally
    {
        if(outputFile != null)
            {
                outputFile.close(); // save and close file here  
            }
            System.out.println("Report is ready. File saved and closed.");
    }
    return counter;
}
    /**This method runs fileAnalysis() method with different hard-coded values
     * @param args
     * @throws java.io.IOException
     * @throw IOException
     */
    public static void main(String[] args) throws IOException
    {
        try
        {
/* Test 1 normal program execution expected here: */
            fileAnalysis ("myDoc.txt", "myReport.txt");
 /* Test 2 -- file not found exception expected here          
            fileAnalysis ("myDoc1.txt", "myReport1.txt");*/
        }
        catch(IOException e)
        {
            System.out.println("Error: file not found");
            System.out.println(e.getMessage());
        }
    }
    
}
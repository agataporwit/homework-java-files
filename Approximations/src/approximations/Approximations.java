/*
ex Approximations
The value ex can be approximated by the following sum:
1 + x + x2/2! + x3/3! + …+ xn/n!
The expression n! is called the factorial of n and is defined as: n! = 1*2*3* …*n.
Write a program that takes a value of x as input and outputs four approximations of ex done using four different values of n: 5, 10, 50, and 100. Output the value of x the user entered and the set of all four approximations into the screen.
Sample formula use: calculating e7 using approximation with n = 5
1 + 7 + 72/2! + 73/3! + 74/4! + 75/5!
Requirements
1. Input validation is needed - do not allow the user to enter anything but integer. Use exception-handling technique discussed in class and implemented in InputValidation.java example to complete the feature.
2. Please do not do any calculations by writing out the entire sums by hand, use loops and running total calculations instead.
3. Factorial function produces large numbers and it grows very quickly. If you start using regular integers to store factorials, you’ll get integer overflows easily. I would suggest using long to store factorials. On top of that, I would recommend to adjust your calculations in such a way that you never get to calculate the actual factorial values. Look at the pattern in the sum: each next term of the sum can be derived from the previous one by means of a very simple calculation.
4. Test your code. Make sure the calculations are correct by checking the actual values of ex online. The bigger the value of n – the closer the resulting value must be to the actual value of ex.
Name your solution project Approximations.java.

@author Agata Jelen CSD 141 Winter 2018
 */
package approximations;

import java.util.Scanner;

public class Approximations
{

    public static void main(String[] args) {
        System.out.print("Enter the power of e as an integer: ");
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();

        try
        {
            int x = Integer.parseInt(str);

            if (x < 0)
                throw new NumberFormatException("The value must be 0 or greater.");

            approximate(x);
        }
        catch(NumberFormatException e)
        {
            System.out.println(e.toString());
        }
    }

    /**
     * This methods approximates the value of e^x using the following formula.
     * 1 + x + x2/2! + x3/3! + …+ xn/n!
     * The 3 values of n are used 5, 10, 50 and 100
     *
     * @param x The x is the exponent of e
     */
    public static void approximate(int x)
    {
        // Accumulative result as we increment the values of n
        double result = 1;
        // The previous sum term in the series of sums
        double prev = 1;

        // The i is the sum term number
        int i = 1;
        // The narr is the list of values for n
        int[] narr = {5,10,50,100};

        // Loop for each value of n
        for (int n : narr)
        {
            // Increment the i for each new sum and add it to the total result while
            // keeping track of the previous sum.
            for (; i <= n; i++)
            {
                result += (prev = prev * (double)x / (double)i);
            }

            // For each n, print the result
            System.out.println("e^" + x + " = " + result + " (approximated using n = " + n + ")");
        }
    }
}
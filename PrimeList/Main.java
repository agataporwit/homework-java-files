package PrimeList;

import java.util.*;


/*
Assignment 6
@author Agata Jelen, CSD 143 Spring 2018
Prime Number List
Write an application that calculates and stores the first 50 prime numbers (starting at 2) in a Java LinkedList.
Use an iterator to display the contents of the list, 10 numbers to a line.
*/
public class Main {

    public static void main(String[] args) {

        //linked list
        LinkedList<Integer> primes = new LinkedList<Integer>();

        primes.add(2); //first prime number

        int flag; //flag to check prime or not

        //loop till we find 50 primes

        for ( int i = 3; primes.size() < 50; i++ )

        {
            flag = 1; //assume i is prime

            //prime test
            for ( int j = 2; j <= Math.sqrt(i); j++ )
            {

                //if any divisor

                if (i % j == 0)

                {

                    flag = 0; //set flag to 0

                    break; //break the loop

                }

            }

            //if flag is 1 then it is prime

            if (flag == 1)

                primes.add(i);

        }

        //iterator

        Iterator<Integer> itr = primes.iterator();

        //print 50 primes

        for ( int i = 0; itr.hasNext(); i++ )

        {

            System.out.print(itr.next() + " ");

            if (i % 10 == 9) //line break after 10 numbers

                System.out.println();

        }

    }

}

package NumberPalindrom;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class NumberPalindrome {


    public Set<String> getPermutations(String input) {

        Set<String> strSet = new HashSet<String>();
        permutations("", input, strSet);
        return strSet;
    }


    public static void permutations(String consChars, String input, Set<String> strSet) {

        if (input.isEmpty()) {
            strSet.add(consChars + input);
            return;
        }

        for (int i = 0; i < input.length(); i++) {
            permutations(consChars + input.charAt(i),
                    input.substring(0, i) + input.substring(i + 1), strSet);
        }
    }

    public static int getPalindrome(String numberString, Set<String> permutations) {
        Set<String> palindromes = new HashSet<String>();
        for (String number : permutations) {

            StringBuilder builder = new StringBuilder();
            builder.append(number);
            builder = builder.reverse();

            String reverseNumber = builder.toString();
            if (reverseNumber.equals(number)) {
                palindromes.add(reverseNumber);
            }
        }

        if (palindromes.size() == 0) {
            return -1;
        } else {
            String palindrome = new ArrayList<String>(palindromes).get(0);
            return Integer.parseInt(palindrome);
        }
    }

    public static void main(String a[]) {
        NumberPalindrome numberPalindrome = new NumberPalindrome();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number as string to check for possible palindrome:\n");
        String inputNumber = scanner.next();
        System.out.println("Input Number : " + inputNumber);


        Set<String> output = numberPalindrome.getPermutations(inputNumber);

        int palindrome = getPalindrome(inputNumber, output);

        if (palindrome == -1) {
            System.out.println("-1");
        } else {
            System.out.println("Possible palindrome for the given number string : " + inputNumber + " is : " + palindrome);
        }

    }

}
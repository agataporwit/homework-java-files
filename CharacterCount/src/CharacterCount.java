public class CharacterCount
{

    public static void main(String[] args) {
        printCount("dylabn");
    }

    /**
     * 
     * @ author Agata Jelen 
     * This method takes an ASCII string and prints out a table showing
     * each ASCII character in the string along with it's occurrence count in the string.
     * Note: The behavior is undefined if the string contains non-ASCII characters.
     * @param str The string containing only ASCII characters.
     */
    public static void printCount(String str)
    {
        short[] arr = new short[128];

        for (byte b : str.getBytes())
        {
            arr[b]++;
        }

        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] > 0)
            {
                System.out.print((char)i);
                System.out.println(" " + arr[i]);
            }
        }
    }
}
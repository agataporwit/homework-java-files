package Assignment4_Agata_Jelen_CSD143;

class TestScores {
    private int scores[]=new int[5];
    public TestScores(int test [])throws InvalidTestScores
    {
        //input validation test score
        for(int i=0; i<5; i++)
            if (test[i] < 0 || test[i] > 100) //condition
                throw new InvalidTestScores(test[i]);
            else
                scores[i] = test[i];

        System.out.println("An average score is: " +Average());
    }

    public double Average()
    {
        int sum =0;
        double avg;
        for(int i=0; i<5; i++)
        {
            sum+=scores[i];
        }
        return sum/5;

    }
}

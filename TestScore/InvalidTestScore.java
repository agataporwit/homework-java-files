package Assignment4_Agata_Jelen_CSD143;

class InvalidTestScores extends Exception{
    public InvalidTestScores(int n){
        super("Error: Your number can't be less than 0 and greater then a 100. \nTry Again !");
    }
}

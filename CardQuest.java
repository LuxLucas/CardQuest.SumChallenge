import java.util.Scanner;

public class CardQuest implements ICardQuest{
    int[] cards                 = new int[9];
    int[] cardsOnTable          = new int[3];
    int[] firstGroupOfCards     = new int[3];
    int[] secondGroupOfCards    = new int[3];

    private boolean inIntArray(int[] intArray, int searchItem) {
        for(int i: intArray){
            if(i == searchItem){
                return true;
            }
        }
        return false;
    }

    private int lastEmptyIndexInIntArray(int[] intArray){
        for(int i = 0; i < intArray.length ; i++){
            if(intArray[i] == 0){
                return i;
            }
        }
        return -1;
    }

    private void shuffleCards(){
        int[] shuffledNumbers = new int[cards.length];
        int lastEmptyIndex;

        while(inIntArray(shuffledNumbers, 0)){
            int randomNumber = (int)((Math.random() * cards.length)+1);
            if(!inIntArray(shuffledNumbers, randomNumber) && inIntArray(shuffledNumbers, 0)){
                lastEmptyIndex = lastEmptyIndexInIntArray(shuffledNumbers);
                shuffledNumbers[lastEmptyIndex] = randomNumber;
            }
        }

        cards = shuffledNumbers.clone();
    }

    private int[] slicedIntArray(int[] intArray, int begin, int end){
        int[] slicedIntArray = new int[(end - begin)+1];
        int lastEmptyIndex;

        for(int i = 0; i < intArray.length -1; i++){
            if(i >= begin && i <= end){
                lastEmptyIndex = lastEmptyIndexInIntArray(slicedIntArray);
                slicedIntArray[lastEmptyIndex] = intArray[i];
            }
        }

        return slicedIntArray.clone();
    }

    private void distributeCards(){
        firstGroupOfCards   = slicedIntArray(cards, 0, 2);
        secondGroupOfCards  = slicedIntArray(cards, 3, 5);
        cardsOnTable        = slicedIntArray(cards, 6, 8);
    }

    private int maxIntInIntArray(int[] intArray){
        int max = intArray[0];
        for(int i: intArray){
            if(i > max){
                max = i;
            }
        }
        return max;
    }

    private int minIntInIntArray(int[] intArray){
        int min = intArray[0];
        for(int i: intArray){
            if(i < min){
                min = i;
            }
        }
        return min;
    }

    private int sumOfItemsInIntArray(int[] intArray){
        int sum = 0;

        for(int i: intArray){
            sum += i;
        }

        return sum;
    }

    private int question(){
        Scanner in = new Scanner(System.in);
        int sumFirstGroup   = sumOfItemsInIntArray(firstGroupOfCards);
        int sumSecondGroup  = sumOfItemsInIntArray(secondGroupOfCards);

        System.out.println("\nEm uma mesa há nove cartões numerados de 1 a 9. Ana e Beto pegaram três cartões cada um.");
        System.out.printf("A soma dos números dos cartões de Ana é %d e a soma dos números dos cartões de Beto é %d. ", sumFirstGroup, sumSecondGroup);
        System.out.println("\nQual é a diferença entre o maior e o menor dos números dos três cartões deixados sobre a mesa? ");
        System.out.print("\nSua resposta: ");

        int response = in.nextInt();
        in.close();

        return response;
    }

    private int correctResponse(){
        int minCardOnTable  = minIntInIntArray(cardsOnTable);
        int maxCardOnTale   = maxIntInIntArray(cardsOnTable);

        return maxCardOnTale - minCardOnTable;
    }

    public void play(){
        shuffleCards();
        distributeCards();

        int response = question();
        if(response == correctResponse()){
            System.out.println("Resposta certa, parabéns!");
        }else{
            System.out.printf("Resposta errada. O correto é %d", correctResponse());
        }

    }
}
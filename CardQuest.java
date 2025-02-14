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
        for(int i = 0; i < intArray.length -1; i++){
            if(intArray[i] == 0){
                return i;
            }
        }
        return -1;
    }

    private void shuffleCards(){
        int[] shuffledNumbers = new int[cards.length];

        while(inIntArray(shuffledNumbers, 0)){
            int randomNumber = (int)((Math.random() * cards.length)+1);
            if(!inIntArray(shuffledNumbers, randomNumber)){
                int lastEmptyIndex = lastEmptyIndexInIntArray(shuffledNumbers);
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

    public void play(){
        System.out.print("Testando...");
    }
}
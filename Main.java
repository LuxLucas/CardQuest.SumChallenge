public class Main {
    public static void main(String[] args) {
        int[] arrayTest = new int[9];
        arrayTest = new int[] {0, 1};
        //CardQuest cardQuest = new CardQuest();
        //cardQuest.play();
        int numberRandom = (int)((Math.random() * 9)+1);
        System.out.print(numberRandom);
    }
}

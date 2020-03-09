public class gameTester{

    public static void main(String[] args) {
        ChessGame bruh = new ChessGame();
        System.out.println("Hello");
        System.out.println(bruh);

        //bruh.placeKnight(4, 20);
        //System.out.println(bruh);

        bruh.placeQueen(68, 30, false);
        bruh.placeQueen(28, 70, false);
        //bruh.maxQueenInfluence();
        System.out.println(bruh);
    }

    

}
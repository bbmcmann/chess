//import java.awt.Color;

public class Board{

    private Square squares[][];

    public Board(){
        squares = new Square[8][8];
        for(int row = 0; row < squares.length; row++){
            boolean isBlack = false;
            if(row % 2 == 0){
                isBlack = true;
            }
            for(int col = 0; col < squares[0].length; col++){
                int rank = squares.length - row;
                int file = col+1;
                String color = "w";
                if(isBlack){
                    color = "b";
                }
                squares[row][col] = new Square(rank, file, color);
                isBlack = !isBlack;
            }
        }
    }

    public Square getSquare (int rank, int file){       
        return squares[squares.length-rank][file-1];    
    }

    public void clearBoard(){
        for(int i = squares[0].length-1; i >= 0; i--){
            for(int j = squares.length-1; j >= 0; j--){
                if(squares[i][j].getColor().equals("b")){
                    squares[i][j].setPiece("#");
                }
                else{
                    squares[i][j].setPiece("@");
                }
            }
        }
    }
}



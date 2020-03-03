import java.awt.Color;

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
                Color color = Color.WHITE;
                if(isBlack){
                    color = Color.BLACK;
                }
                squares[row][col] = new Square(rank, file, color);
                isBlack = !isBlack;
            }
        }
    }

    public Square getSquare (int rank, int file){       //this may not be right
        return squares[squares.length-rank][file-1];    //it is just for modeling purposes
    }
}


//clearBoard()
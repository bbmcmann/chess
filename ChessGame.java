public class ChessGame{

    private Board board;

    public ChessGame(){
        this.board = new Board();
    }

    public int placeRook(int rank, int file){
        int influence = 0;
        if(board.getSquare(rank, file) != null){
            
            board.getSquare(rank, file).setPiece("r");
            //loop through the rank
            for(int i = 1; i <= 8; i++){
                board.getSquare(rank,i).toggleHighlight();
                influence ++;
            }
            //loop through the file
            for(int i = 1; i <= 8; i++){
                board.getSquare(i,file).toggleHighlight();
                influence ++;
            }

        }
        return influence;
    }

    public void inefficentlyPlaceRook(int rank, int file){
        if(board.getSquare(rank, file) != null){

            board.getSquare(rank, file).setPiece("r");
            //with this method you must highlight it first
            //then later in the loop it will be unhighlighted,
            //a piece cannot move to where it already is
            board.getSquare(rank, file).toggleHighlight();
            //loop through the ENTIRE board
            for(int i = 1; i <= 8; i++){
                for(int j = 1; j <= 8; j++){
                    //check to see if current square is somewhere a rook can move
                    if(i == rank || j == file){
                        board.getSquare(i, j).toggleHighlight();
                    }

                }                
            }
        }
    }

    public int placeKnight(int rank, int file){
        int influence = 0;
        if(board.getSquare(rank, file) != null){

            board.getSquare(rank, file).setPiece("k");

            for(int i = 1; i <= 8; i++){
                for(int j = 1; j <= 8; j++){
                    //check to see if current square is somewhere a knight can move
                    if(dist(rank, file, i, j) == Math.sqrt(5)){
                        board.getSquare(i, j).toggleHighlight();
                        influence ++;
                    }

                }                
            }


        }
        return influence;
    }

    public int placeBishop(int rank, int file){
        int influence = 0;
        if(board.getSquare(rank, file) != null){

            board.getSquare(rank, file).setPiece("b");

            for(int i = 1; i <= 8; i++){
                for(int j = 1; j <= 8; j++){
                    //check to see if current square is somewhere a bishop can move
                    if(Math.abs(rank-i) == Math.abs(file-j)){
                        board.getSquare(i, j).toggleHighlight();
                        influence ++;
                    }

                }                
            }


        }
        return influence;
    }

    public int placeQueen(int rank, int file, boolean onlyInfluence){
        int influence = 0;
        if(board.getSquare(rank, file) != null){

            if(!onlyInfluence){
                board.getSquare(rank, file).setPiece("q");
            }
            
            for(int i = 1; i <= 8; i++){
                for(int j = 1; j <= 8; j++){
                    //check to see if current square is somewhere a bishop can move
                    if(Math.abs(rank-i) == Math.abs(file-j)){
                        if(!onlyInfluence){
                            board.getSquare(i, j).toggleHighlight();
                        }
                        influence ++;
                    }

                }                
            }

            for(int i = 1; i <= 8; i++){
                if(!onlyInfluence){
                    board.getSquare(rank,i).toggleHighlight();
                }
                influence ++;
            }
            //loop through the file
            for(int i = 1; i <= 8; i++){
                if(!onlyInfluence){
                    board.getSquare(i,file).toggleHighlight();
                }
                influence ++;
            }


        }
        return influence;
    }

    //NOT DONE!!!
    public int maxQueenInfluence(){
        int maxInfluence = 0;
        for(int i = 1; i <= 8; i++){
            for(int j = 1; j <= 8; j++){
                if(placeQueen(i, j, true) > maxInfluence){
                    maxInfluence = placeQueen(i, j, true);
                }
                //board.clearBoard();
            }                
        }

        for(int i = 1; i <= 8; i++){
            for(int j = 1; j <= 8; j++){
                if(placeQueen(i, j, true) == maxInfluence){
                    board.getSquare(i, j).toggleHighlight();
                }
            }                
        }

        return maxInfluence;
    }

    public double dist(int r1, int f1, int r2, int f2){
        int x = Math.abs(f1-f2);
        int y = Math.abs(r1-r2);
        double dist = Math.sqrt((x*x)+(y*y));
        return dist;
    }

    public String toString(){
        String textBoard = "";
        for(int i = 1; i <= 8; i++){
            for(int j = 1; j <= 8; j++){
                textBoard = textBoard + board.getSquare(i, j).getPiece() + " ";
            } 
            textBoard = textBoard + "\n";
        }
        return textBoard;
    }
}
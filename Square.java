//import java.awt.Color;

public class Square{
    private int rank, file;
    //private Color color;
    private String color;
    private boolean isHighlighted = false;
    private String piece;

    public Square(int rank, int file, String color){
        this.rank = rank;
        this.file = file;
        this.color = color;
        if(color.equals("w")){
            this.piece = "@";
        }
        else{
            this.piece = "#";
        }
    }

    public void toggleHighlight(){
        this.isHighlighted = !this.isHighlighted;
        if(isHighlighted && !piece.equals("p") && !piece.equals("r") && !piece.equals("k") && !piece.equals("b") && !piece.equals("q") && !piece.equals("K")){
            this.piece = ".";
        }
        else if(!piece.equals("p") && !piece.equals("r") && !piece.equals("k") && !piece.equals("b") && !piece.equals("q") && !piece.equals("K")){
            if(this.color.equals("b")){
                this.piece = "#";
            }
            else{
                this.piece = "@";
            }     
        }
    }

    public boolean isHighlighted(){
        return this.isHighlighted;
    }

    public int getRank(){ return this.rank; }
    public int getFile(){ return this.file; }
    public String getColor(){ return this.color; }

    public String getPiece() { return this.piece; }
    public void setPiece(String piece){
        this.piece = piece;
    }

}
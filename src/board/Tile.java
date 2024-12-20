package src.board;

import src.pieces.Piece;

public class Tile {
    
    private int xPos;
    private int yPos;
    private Piece piece;

    Tile(int xPos, int yPos, Piece piece){

        this.xPos = xPos;
        this.yPos = yPos;
        this.piece = piece;
    }

    public void setPiece(Piece piece){
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public boolean isOccupied(){
        return piece != null;
    }

    public int getXPos (){
        return xPos;
    }
    public int getYPos (){
        return yPos;
    }

}

package src.pieces;
import java.util.List;

import src.board.ChessBoard;
import src.board.Tile;

public abstract class Piece {

    private boolean isWhite;
    private String pieceType;

    public Piece(boolean isWhite, String pieceType){
        this.isWhite = isWhite;
        this.pieceType = pieceType;
    }

    public boolean isWhite(ChessBoard board){
        return isWhite;
    }

    public String getPieceType(){
        return pieceType;
    }

    public abstract List<Tile> candidateMoves(ChessBoard board, Tile currentTile);

    public List<Tile> getPossibleMoves(ChessBoard board, Tile currentTile);

    public abstract boolean isValidMove(ChessBoard board, Tile startTile, Tile endTile);

}

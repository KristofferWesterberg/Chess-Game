package src.board;

public class ChessBoard {

    private Tile [][] board;


    ChessBoard (){

        board = new Tile[8][8];
        initBoard();
    }

    public void initBoard(){

        // empty board
        for (int row = 2; row < 7; row++) {
            for (int col = 0; col < 8; col++){
                board[row][col] = new Tile(row, col, null);
            }
        }

        //black
        initPieces(false, 0, 1);
        //white
        initPieces(true, 8, 7);
    }


    public void initPieces(boolean color, int kingRow, int pawnRow){

        board[kingRow][0].setPiece(new Rook(color));
        board[kingRow][7].setPiece(new Rook(color));

        board[kingRow][1].setPiece(new Knight(color));
        board[kingRow][6].setPiece(new Knight(color));

        board[kingRow][2].setPiece(new Bishop(color));
        board[kingRow][5].setPiece(new Bishop(color));

        board[kingRow][3].setPiece(new Queen(color));
        board[kingRow][4].setPiece(new King(color));

        for (int col = 0; col < 8; col++) {
            board[pawnRow][col].setPiece(new Pawn(color));
        }
    }

    public Tile getTile(int row, int col){
        return board[row][col];
    }
    
}
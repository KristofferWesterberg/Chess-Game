package src.view;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class BoardPanel extends JPanel {

    private static final int TILE_SIZE = 75; 
    private static final Color HIGHLIGHT_COLOR = new Color(70, 177, 225);   
    //private static final Color HIGHLIGHT_CHECK = new Color(255, 93, 93);   
    private static final String[] START_BACK_POSITION = {"Rook", "Knight", "Bishop", "Queen", "King", 
    "Bishop", "Knight", "Rook"};

    private JLabel[][] boardTiles = new JLabel[8][8];
    private Set<Point> highlightedTiles = new HashSet<>();
    private HashMap<String, ImageIcon> pieceImages;
    
        public BoardPanel(HashMap<String, ImageIcon> pieceImages){

        this.pieceImages = pieceImages;
        setLayout(new GridLayout(8, 8));
        setPreferredSize(new Dimension(TILE_SIZE*8, TILE_SIZE*8));

        initBoardView();
    }


    private void initBoardView(){

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                boardTiles[row][col] = new JLabel();
                boardTiles[row][col].setPreferredSize(new Dimension(TILE_SIZE, TILE_SIZE));
                boardTiles[row][col].setOpaque(true);
                
                if ((row + col) % 2 == 0) {
                    boardTiles[row][col].setBackground(getColor(row, col)); 
                } else {
                    boardTiles[row][col].setBackground(getColor(row, col));
                }

                add(boardTiles[row][col]);

                if (row < 2 || row > 5){
                    setPieceImage(row, col);
                }            
            }
        }
            
    }

    private Color getColor( int row, int col){

        Color color;

        if ((row + col) % 2 == 0) {
            color = new Color(230, 203, 168); 
        } else {
            color = new Color(139, 90, 43);
        }
        return color;
    }

    private void setPieceImage(int row, int col){
        
        String color ="";
        String pieceName = "";

        if (row < 2) {
            color = "b";
        }else{
            color = "w";
        }
        
        if(row %7 ==0){
            pieceName = color +START_BACK_POSITION[col];
        }else{
            pieceName = color+"Pawn";
        }
            
        ImageIcon pieceImage = pieceImages.get(pieceName);
        boardTiles[row][col].setIcon(pieceImage);
    }

    // Kanske lägga till highlighta kungen här?
    public void highlightMovableTiles(Set<Point> newMovableTiles){
        
        resetHighlights();

        for (Point p : newMovableTiles) {
            int row = p.x;
            int col = p.y;
            boardTiles[row][col].setBackground(HIGHLIGHT_COLOR);
            highlightedTiles.add(p);
        }
    }

    private void resetHighlights(){

        for (Point p : highlightedTiles) {
            int row = p.x;
            int col = p.y;
            boardTiles[row][col].setBackground(getColor(row, col));
        }
        highlightedTiles.clear();
    }

    public void updatePieceMove(int startRow, int startCol, int endRow, int endCol){

        JLabel startTile =boardTiles[startRow][startCol];
        JLabel endTile =boardTiles[endRow][endCol];

        ImageIcon movedPiece = (ImageIcon) startTile.getIcon();

        startTile.setIcon(null);
        endTile.setIcon(movedPiece);

        repaint();
        revalidate();

    }

    // TODO: Add promotion option to other pieces 

    public void updatePromotion(int row, int col, boolean isWhite){

        ImageIcon queen;
        if (isWhite) {
             queen = pieceImages.get("wQueen");
        }else{
            queen = pieceImages.get("bQueen");
        }
        boardTiles[row][col].setIcon(queen);
    }

}

    // Behöver logik från controller för att implementera bättre
    // Rockad
    // schack


        // Tills senare: gameOver



package src.view;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;


public class Frame extends JFrame {

    private BoardPanel boardPanel;
    private SideBarPanel sideBarPanel;

    private static final String IMAGE_PATH = "/resources/images/";

    public Frame(){


        setTitle("Chess Game");
        setSize(800, 800); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setResizable(false);

        setLayout(new BorderLayout());

        HashMap<String, ImageIcon> pieceImages = loadImages();

        boardPanel = new BoardPanel(pieceImages);
        sideBarPanel = new SideBarPanel(pieceImages);

        add(boardPanel, BorderLayout.CENTER);
        add(sideBarPanel, BorderLayout.EAST);
        pack();


        setVisible(true);

    }

    private HashMap<String, ImageIcon> loadImages() {
    
        HashMap<String, ImageIcon> pieceImages = new HashMap<>();

        String[] pieceNames = {
            "wPawn", "bPawn", "wRook", "bRook", 
            "wKnight", "bKnight", "wBishop", "bBishop", 
            "wQueen", "bQueen", "wKing", "bKing"
        };

        for (String pieceName : pieceNames) {
                String filePath = IMAGE_PATH + pieceName + ".png";
                ImageIcon image = new ImageIcon(getClass().getResource(filePath));
                pieceImages.put(pieceName, image);
        }
        return pieceImages;

    }

    // TODO: Game over screen

    public BoardPanel getBoardPanel(){
        return boardPanel;
    }
    public SideBarPanel getSideBarPanel(){
        return sideBarPanel;
    }

    // public static void main(String[] args) {
    //     Frame f = new Frame();

    //     BoardPanel bp = f.getBoardPanel();

    // }
}
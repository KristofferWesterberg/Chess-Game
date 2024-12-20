package src.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;

import java.util.HashMap;

public class SideBarPanel extends JPanel{

    private JPanel blackCapturedPanel;
    private JPanel whiteCapturedPanel;
    private HashMap<String, ImageIcon> pieceImages;

    public SideBarPanel(HashMap<String, ImageIcon> pieceImages){

        this.pieceImages = pieceImages;

        setLayout(new BorderLayout());

        JPanel capturedPiecesPanel = new JPanel();
        capturedPiecesPanel.setLayout(new GridLayout(2, 1));

        blackCapturedPanel = createCapturedPanel("Black");
        whiteCapturedPanel = createCapturedPanel("White");

        capturedPiecesPanel.add(whiteCapturedPanel);
        capturedPiecesPanel.add(blackCapturedPanel);

        add(capturedPiecesPanel, BorderLayout.CENTER);

        setPreferredSize(new Dimension(200, 600));
    }

    private JPanel createCapturedPanel(String color) {

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), 
        color + " Pieces Captured", TitledBorder.CENTER, TitledBorder.TOP));
        
        return panel;
    }

    public void updateCapturedPanel(String pieceType) {

        ImageIcon pieceImage = pieceImages.get(pieceType);
        Image scaledImage = pieceImage.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(scaledImage);
        JLabel pieceLabel = new JLabel(resizedIcon);

        if (pieceType.startsWith("b")) {

            blackCapturedPanel.add(pieceLabel);
            // for dynamically adding components
            blackCapturedPanel.revalidate();
            blackCapturedPanel.repaint();
        }else {
            
            whiteCapturedPanel.add(pieceLabel);
            whiteCapturedPanel.revalidate();
            whiteCapturedPanel.repaint();
        }

    }



}



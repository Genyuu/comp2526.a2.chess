package Chess;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Pieces.*;

/**
 * Engine class creates and maintains the GUI component of the chess game.
 * 
 * @author Chris Cho, A00972501, Set A
 * @version 3.0
 */
public class Engine extends JPanel {
    private Board board;
    private JPanel menuBar;
    private JButton set;
    private JButton clear;
    private menuHandler menu;
    
    /** 
     * Engine constructor. Creates and adds the menu, menu buttons,
     * menu handler, and board.
     */
    public Engine() {
        // Set-up Layout 
        setLayout(new BorderLayout());
        
        menu = new menuHandler();
        menuBar = new JPanel();
        
        set = new JButton("SET");
        set.addActionListener(menu);
        
        clear = new JButton("CLEAR");
        clear.addActionListener(menu);
        
        menuBar.add(set);
        menuBar.add(clear);
        
        add(menuBar, BorderLayout.NORTH);
        
        board = new Board();
        
        add(board, BorderLayout.CENTER);
        board.setPiece(new Bishop(1), 3, 3);
        board.setPiece(new Queen(2), 5, 5);
    }
    
    private void addMenu() {
    	
    }
    
    /**
     * Manages the menu button events.
     * @author Chris Cho, A00972501, Set A
     * @version 3.0
     */
    public class menuHandler implements ActionListener {
        /**
         * Performs the appropriate methods depending on which menu button was clicked.
         * 
         * <p>If "SET" has been clicked, it will clear the board and
         * reset the pieces on the board.</p>
         * 
         * <p>If "CLEAR" has been clicked, it will just clear all
         * the pieces on the board.</p>
         */
        public void actionPerformed(ActionEvent e) {
            if ("SET".equals(e.getActionCommand())) {
                board.clearBoard();
                board.setBoard();
            }
            if ("CLEAR".equals(e.getActionCommand())) {
                board.clearBoard();
            }
        }
    }
}

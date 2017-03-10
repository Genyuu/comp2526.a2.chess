package Chess;

/* -------------------------------------------------------------------------------------------------------------------
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 *                                     THIS IS A DEPRICATED VERSION, PLEASE USE chessEngine
 * 
 *                                              MAY BE USED AGAIN FOR LATER USE
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * -------------------------------------------------------------------------------------------------------------------
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Pieces.*;

/**
 * Engine class creates and maintains the GUI component of the chess game.
 * 
 * 
 * @author Chris Cho, A00972501, Set A
 * @version 3.0
 */
public class Engine extends JPanel {
    private Board board;
    private JMenuBar menuBar1;
    private JMenu fileMenu;
    private JMenuItem newMenuItem;
    private JPanel menuBar;
    private JButton set;
    private JButton clear;
    private menuHandler menu;
    private Piece[][] piece;
    
    /** 
     * Engine constructor. Creates and adds the menu, menu buttons,
     * menu handler, and board.
     */
    public Engine() {
        // Set-up Layout 
        //setLayout(new BorderLayout());
        
        // Menu
        /*menu = new menuHandler();
        menuBar = new JPanel();
        
        set = new JButton("SET");
        set.addActionListener(menu);
        
        clear = new JButton("CLEAR");
        clear.addActionListener(menu);
        
        menuBar.add(set);
        menuBar.add(clear);*/
        
        //add(menuBar, BorderLayout.NORTH);
        
        // initialize board;
        
        board = new Board();
        this.add(board);
        //add(board, BorderLayout.CENTER);
        initPieces();
        initBoard();
    }
    
    public final void initPieces() {
        piece = new Piece[2][6];
        
        piece[0][0] = new King(1);
        piece[0][1] = new Queen(1);
        piece[0][2] = new Bishop(1);
        piece[0][3] = new Knight(1);
        piece[0][4] = new Rook(1);
        piece[0][5] = new Pawn(1);
        
        piece[1][0] = new King(2);
        piece[1][1] = new Queen(2);
        piece[1][2] = new Bishop(2);
        piece[1][3] = new Knight(2);
        piece[1][4] = new Rook(2);
        piece[1][5] = new Pawn(2);
    }
    
    public final void initBoard() {
        // Pawns
        for (int i = 0; i < 8; i++) {
            board.setPiece(piece[0][5], i, 6);
            board.setPiece(piece[1][5], i, 1);
        }
        
        board.setPiece(piece[0][4], 0, 7); // Rook
        board.setPiece(piece[0][3], 1, 7); // Knight
        board.setPiece(piece[0][2], 2, 7); // Bishop
        board.setPiece(piece[0][1], 3, 7); // Queen
        board.setPiece(piece[0][0], 4, 7); // King
        board.setPiece(piece[0][2], 5, 7); // Bishop
        board.setPiece(piece[0][3], 6, 7); // Knight
        board.setPiece(piece[0][4], 7, 7); // Rook
        
        board.setPiece(piece[1][4], 0, 0);
        board.setPiece(piece[1][3], 1, 0);
        board.setPiece(piece[1][2], 2, 0); // Bishop
        board.setPiece(piece[1][1], 3, 0); // Queen
        board.setPiece(piece[1][0], 4, 0); // King
        board.setPiece(piece[1][2], 5, 0); // Bishop
        board.setPiece(piece[1][3], 6, 0);
        board.setPiece(piece[1][4], 7, 0);
    }
    
    public final void clear() {
        board.clearBoard();
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
                clear();
                initBoard();
            }
            if ("CLEAR".equals(e.getActionCommand())) {
                clear();
            }
        }
    }
}

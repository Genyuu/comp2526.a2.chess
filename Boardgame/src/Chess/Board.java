package Chess;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JPanel;
import Pieces.*;

/**
 * The board class creates and controls a grid of tiles and also
 * controls the pieces which goes inside the tiles. 
 * <p>The board is also responsible for managing the GUI event
 * listeners of tile clicks, and deal with the piece movement
 * Appropriate to the event. </p>
 * <p>Game logic & rules are also mostly handled by the board.</p>
 * 
 * @author Chris Cho, A00972501, Set A
 * @version 3.0
 */

public class Board extends JPanel implements java.io.Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    // Dimension size of each tile.
    private int maxSize;
    
    // Amount of tiles on the board grid.
    private int gridSize;
    
    // Player play turn.
    private int turn;
    
    // Dimension of the tile.
    private Dimension size;
    
    // Array of tiles.
    private Tile[][] tile;
    
    // Color 1 of the checkered tiles.
    private Color color1;
    
    // Color 2 of the checkered tiles.
    private Color color2;
    
    // Location value of the clicked tile.
    private Point point;
    
    // Location value of the activated tile.
    private Point pointActivated;
    
    // Collection of at least one of all possible piece in the chess game
    private Piece[][] piece;
    
    // Tile click event listener
    private tileHandler tileListener;
    
    /**
     * Board constructor.
     * <p>This is the zero-parameter version. It...
     * <li>Sets up the number of the tiles</li>
     * <li>Sets up the size of the tiles</li>
     * <li>Sets up the color of the tiles</li>
     * <li>Sets up the grid layout</li>
     * <li>Generates the tiles and adds them to the board</li>
     * </p>
     */
    public Board() {
        gridSize = 8;
        maxSize = 100;
        tile = new Tile[8][8];
        size = new Dimension(maxSize, maxSize);
        color1 = Color.WHITE;
        color2 = Color.GRAY;
        pointActivated = new Point(-1,-1);
        
        tileListener = new tileHandler();
        
        setLayout(new GridLayout(gridSize,gridSize));

        generateTiles(gridSize, color1, color2);
    }
    
    // Creates and adds board tiles.
    private void generateTiles(int s, Color c1, Color c2) {
        for (int y = 0; y < s; y++) {
            for (int x = 0; x < s; x++) {
                if ((y + x) % 2 != 0) {
                    tile[y][x] = new Tile(c1, size);
                } else {
                    tile[y][x] = new Tile(c2, size);
                }
                this.add(tile[y][x]);
                tile[y][x].addActionListener(tileListener);
            }
        }
    }
    
    /**
     * Creates all possible chess pieces needed for a chess game.
     * Includes 1 of each piece for 2 players.
     */
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
    
    /**
     * Assigns all necessary chess pieces to their initial positions of a chess game.
     */
    public final void initBoard() {
        turn = 1;
        // Pawns
        for (int i = 0; i < 8; i++) {
            tile[1][i].setPiece(piece[1][5]);
            tile[6][i].setPiece(piece[0][5]);
        }
        
        tile[0][0].setPiece(piece[1][4]);
        tile[0][1].setPiece(piece[1][3]);
        tile[0][2].setPiece(piece[1][2]);
        tile[0][3].setPiece(piece[1][1]);
        tile[0][4].setPiece(piece[1][0]);
        tile[0][5].setPiece(piece[1][2]);
        tile[0][6].setPiece(piece[1][3]);
        tile[0][7].setPiece(piece[1][4]);
        
        tile[7][0].setPiece(piece[0][4]);
        tile[7][1].setPiece(piece[0][3]);
        tile[7][2].setPiece(piece[0][2]);
        tile[7][3].setPiece(piece[0][1]);
        tile[7][4].setPiece(piece[0][0]);
        tile[7][5].setPiece(piece[0][2]);
        tile[7][6].setPiece(piece[0][3]);
        tile[7][7].setPiece(piece[0][4]);
    }
    
    public void setPiece(Piece p, int x, int y) {
        turn = 1;
        tile[y][x].setPiece(p);
    }
    
    /**
     * Clears the board of all pieces.
     */
    public final void clearBoard() {
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                tile[y][x].clearPiece();
            }
        }
    }
    
    /**
     * 
     * @return
     */
    public Tile[][] getTiles() {
    	return tile;
    }
    
    /**
     * Evaluates the click on a tile. 
     * <p>If the event source (srcTile) caught from the tileHandler 
     * actionListener matches up completely with one of the tiles on
     * the board, this method will return the position of that tile
     * as a point object.</p>
     * 
     * @param srcTile
     * @return the position of the clicked tile as a point object
     */
    private Point evalClick(Object srcTile) {
        Point p = null;
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (srcTile == tile[y][x]) {
                    p = new Point(x, y);
                }
            }
        }
        return p;
    }
    
    // Checks if a tile is currently active.
    private final Boolean isDeactive() {
        return ((pointActivated.x == -1 || pointActivated.y == -1));
    }
    
    // Checks if the selected tile has a piece.
    private final Boolean hasPiece() {
        return (!(tile[point.y][point.x].isEmpty()));
    }
    
    // Checks if the move source and destination has pieces of the same player.
    private final boolean hasSamePlayer() {
    	return (tile[point.y][point.x].getPiece().getPlayer() ==
    			tile[pointActivated.y][pointActivated.x].getPiece().getPlayer());
    }
    
    // 
    private final Boolean checkTurn() {
    	return (tile[point.y][point.x].piece.getPlayer() == turn);
    }
    
    /**
     * Checks the current player turn if the enable condition is on
     * @param on enable condition for checking the turn, will check turns if true
     * @return true when the clicked piece belongs to the player on his turn.
     */
    private final Boolean checkTurn(boolean on) {
        if (on) {
            return (tile[point.y][point.x].piece.getPlayer() == turn);
        }
        return true;
    }
    
    /** 
     * Changes the turn if the enable condition
     * @param on enable condition for changing turns, will not change turns if it is not on
     * 
     */
    private final void changeTurn(boolean on) {
    	if (on && turn == 1) {
    		turn = 2;
    	} else {
    		turn = 1;
    	}
    }
    
    // Activates the clicked tile.
    private final void activate() {
        pointActivated = point;
        tile[point.y][point.x].setEnabled(false);
    }
    
    // Move the piece to the destination tile.
    private final void move() {
        tile[point.y][point.x].setPiece(tile[pointActivated.y][pointActivated.x].getPiece());
        tile[pointActivated.y][pointActivated.x].clearPiece();
    }
    
    // Deactivates the activated tile.
    private final void deactivate() {
        tile[pointActivated.y][pointActivated.x].setEnabled(true);
        pointActivated.x = -1;
        pointActivated.y = -1;
    }
    
    /**
     * Evaluates whether the 
     * @return true if valid; false otherwise.
     */
    private boolean validateMove() {
        // Checking tile for friendly piece.
        if (hasPiece() && hasSamePlayer()) {
        	return false;
        } else {
            return tile[pointActivated.y][pointActivated.x]
                   .piece.validMove(pointActivated.x, pointActivated.y, point.x, point.y, tile);
        }
    }
    
    /**
     * Listens for and evaluates the clicks on the board
     * @author Chris Cho, A00972501, Set A
     * @version 3.0
     */
    public class tileHandler implements ActionListener, Serializable {
        /**
         * 
         */
        private static final long serialVersionUID = 1L;

        /**
         * Evaluation of the piece click, activation, movement and de-activation.
         * 
         * <p>The listener will first evaluate and find the identity of the clicked tile.
         * Once the location of the tile has been found, this listener will determine
         * whether the click on the tile is an activation click or a movement click.</p>
         * 
         * <p>An 'activation' click is when the user wants to choose a piece they wish to control.
         * It is identified by determining if a piece is already active or not. If the click is an
         * activation, and a non-empty piece has been clicked, the listener will activate the tile
         * to a 'movement' ready state.</p>
         * 
         * <p>Otherwise, the click is recognized as a 'movement' click and will move the previously
         * activated piece to the new tile clicked by the user after a validation process. Whether
         * the piece actually moved or not, the listener will de-activate the previous activation
         * at the end.</p>
         */
        public void actionPerformed(ActionEvent e) {
            point = evalClick(e.getSource());
            
            if (isDeactive()) {
                if (hasPiece()) {
                    if (checkTurn(true)) {
                    	activate();
                    }
                }
            } else {
                if (validateMove()) {
                    if (!hasPiece() || !hasSamePlayer()) {
                    	move();
                    	changeTurn(true);
                    }
                }
                deactivate();
            }
        }
    }
}

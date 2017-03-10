package Chess;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import Pieces.Piece;

/**
 * Individual tile data of the chess board.
 * <p>Controls and manages the piece stored within it.</p>
 * <p>Tile inherits from the JButton class and functions
 * fundamentally the same, however with some additional
 * 'piece' management methods.</p>
 * 
 * @author Chris Cho, A00972501, Set A
 * @version 1.0
 */
public class Tile extends JButton implements java.io.Serializable {
    /**
     * the piece this tile controls. Is null when empty.
     */
    protected Piece piece;
    
    /**
     * Tile constructor. assigns its size and background color.
     * @param c color of the tile
     * @param s dimension value of the tile's size
     */
    public Tile(Color c, Dimension s) {
        piece = null;
        this.setBackground(c);
        this.setPreferredSize(s);
    }
    
    /**
     * Sets the piece to a particular piece.
     * @param p piece to set this tile with.
     */
    public void setPiece(Piece p){
        piece = p;
        
        this.setIcon(p.getIcon());
    }
    
    /**
     * Empty the piece within this tile by turning it null.
     */
    public void clearPiece() {
        piece = null;
        this.setIcon(null);
    }
    
    /**
     * Evaluates whether this tile is empty or not.
     * @return true if the tile is 'empty'; false otherwise
     */
    public boolean isEmpty() {
        if (this.getPiece() == null) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Returns the piece this tile currently contains.
     * @return the piece this tile contains; null if empty.
     */
    public Piece getPiece() {
        return piece;
    }
}
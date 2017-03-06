package Pieces;

import javax.swing.ImageIcon;

/**
 * Rook.
 * 
 * @author Chris Cho, A00972501, Set A
 * @version 1.0
 */
public class Rook extends Piece{

    /**
     * Rook constructor. Assigns the player value to its super constructor and assigns its image icon.
     * @param p the owner of this piece
     */
    public Rook(int p) {
        super(p);
        if (p == 1) {
            pieceIcon = new ImageIcon("icons\\wRook.png");
        } else {
            pieceIcon = new ImageIcon("icons\\bRook.png");
        }
    }

    /**
     * Evaluates the valid move based on rook's movement rules.
     * The rook's move is not valid when both destination x and y points are different their original x and y points.
     */
    public boolean validMove(int x, int y, int destX, int destY) {
        if ((destX != x && destY != y)) {
            return false;
        } else {
            return true;
        }
    }
}

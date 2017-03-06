package Pieces;

import javax.swing.ImageIcon;

/**
 * Queen chess piece.
 * @author Chris Cho, A00972501, Set A
 * @version 1.0
 */
public class Queen extends Piece{
    /**
     * Queen constructor.
     * @param p the owner of this piece.
     */
    public Queen(int p) {
        super(p);
        if (p == 1) {
            pieceIcon = new ImageIcon("icons\\wQueen.png");
        } else {
            pieceIcon = new ImageIcon("icons\\bQueen.png");
        }
    }

    /**
     * Evaluates the validity of this move based on the queen piece's movement rules.
     * The move is only valid when it is either moving horizontally or vertically or diagonally.
     */
    public boolean validMove(int x, int y, int destX, int destY) {
        return (!(destX != x && destY != y)) || ((Math.pow((destX - x),2)) == (Math.pow((destY - y), 2)));
    }

}

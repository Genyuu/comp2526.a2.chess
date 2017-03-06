package Pieces;

import javax.swing.ImageIcon;

/**
 * King chess piece.
 * 
 * @author Chris Cho, A00972501, Set A
 * @version 1.0
 */
public class King extends Piece{
    /**
     * King constructor.
     * @param p the owner of this piece
     */
    public King(int p) {
        super(p);
        if (p == 1) {
            pieceIcon = new ImageIcon("resources\\wKing.png");
        } else {
            pieceIcon = new ImageIcon("resources\\bKing.png");
        }
    }

    /**
     * Evaluates the validity of the move based on the king piece's movement rules.
     * validation is true when the king has moved 1 distance either vertically, horizontally or diagonally.
     */
    public boolean validMove(int x, int y, int destX, int destY) {
        return ((destX == x + 1 && destY == y + 1) || 
                (destX == x - 1 && destY == y - 1) ||
                (destX == x + 1 && destY == y - 1) ||
                (destX == x - 1 && destY == y + 1) ||
                (destX == x + 1 && destY == y) ||
                (destX == x - 1 && destY == y) ||
                (destX == x && destY == y + 1) ||
                (destX == x && destY == y - 1));
    }

}

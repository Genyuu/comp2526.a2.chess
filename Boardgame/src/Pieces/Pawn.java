package Pieces;

import javax.swing.ImageIcon;

import Chess.Tile;

/**
 * Pawn chess piece.
 * @author Chris Cho, A00972501, Set A
 * @version 1.0
 */
public class Pawn extends Piece{

    /**
     * Pawn constructor.
     * @param p the owner of this piece.
     */
    public Pawn(int p) {
        super(p);
        if (p == 1) {
            pieceIcon = new ImageIcon("icons\\wPawn.png");
        } else {
            pieceIcon = new ImageIcon("icons\\bPawn.png");
        }
    }

    /**
     * Evaluates the validity of this move based on the pawn's movement rules.
     * <p>First, the pawn is only able to move forward and never backwards.
     * 'forward' is determined <br/>by the piece's owner. If the piece's owner is
     * player 1, its 'forward' is up and down if the piece's owner is player 2.</p>
     * <p>If the piece is at its initial position, the pawn is permitted to advance 2 tiles forward.
     * Otherwise it can only go 1 tile forwards.</p>
     */
    public boolean validMove(int x, int y, int destX, int destY, final Tile[][] t) {
        if (player == 1) {
            if (y == 6) {
                // Returns true if there is a piece diagonal to this one
                if ((destX == x+1 || destX == x-1) && (destY == y-2 || destY == y-1) && !t[destY][destX].isEmpty()) {
                    return true;
                }
                if (destX == x && destY == y-2) {
                    return (t[destY][destX].isEmpty() && t[destY+1][destX].isEmpty());
                }
                return (destX == x && destY == y-1 && t[destY][destX].isEmpty());
            }
            
            if ((destX == x+1 || destX == x-1) && destY == y-1 && !t[destY][destX].isEmpty()) {
                return true;
            }
            
            return (destX == x && destY == y-1 && t[destY][destX].isEmpty());

        } else {
            if (y == 1) {
                // Returns true if there is a piece diagonal to this one
                if ((destX == x+1 || destX == x-1) && (destY == y+2 || destY == y+1) && !t[destY][destX].isEmpty()) {
                    return true;
                }
                if (destX == x && destY == y+2) {
                    return (t[destY][destX].isEmpty() && t[destY-1][destX].isEmpty());
                }
                return (destX == x && destY == y+1 && t[destY][destX].isEmpty());
            }
            
            if ((destX == x+1 || destX == x-1) && destY == y+1 && !t[destY][destX].isEmpty()) {
                return true;
            }
            
            return (destX == x && destY == y+1 && t[destY][destX].isEmpty());
        }
    }

}

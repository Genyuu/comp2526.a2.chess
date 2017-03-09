package Pieces;

import javax.swing.ImageIcon;

import Chess.Tile;

/**
 * Knight chess piece.
 * 
 * @author Chris Cho, A00970251, Set A
 * @version 1.0
 */
public class Knight extends Piece {
    /**
     * Knight constructor. 
     * @param p the owner of this piece
     */
    public Knight(int p) {
        super(p);
        if (p == 1) {
            pieceIcon = new ImageIcon("icons\\wKnight.png");
        } else {
            pieceIcon = new ImageIcon("icons\\bKnight.png");
        }
    }

    /**
     * Evaluates the validity of the move based on the knight pieces movement rules.
     * The movement is valid when it moves 2 tiles forward a direction and 1 tile to the left or right from its direction.
     */
    public boolean validMove(int x, int y, int destX, int destY, final Tile[][] t) {
        if ((destX == (x+2) && destY == (y+1))
            ||(destX == (x+2) && destY == (y-1))
            ||(destX == (x-2) && destY == (y+1))
            ||(destX == (x-2) && destY == (y-1))
            ||(destX == (x+1) && destY == (y+2))
            ||(destX == (x-1) && destY == (y+2))
            ||(destX == (x+1) && destY == (y-2))
            ||(destX == (x-1) && destY == (y-2)))
        {
            return true;
        } else {
            return false;
        }
    }
}

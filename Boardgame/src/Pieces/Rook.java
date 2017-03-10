package Pieces;

import javax.swing.ImageIcon;
import Chess.Tile;

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
    public boolean validMove(int x, int y, int destX, int destY, final Tile[][] t) {
        if (!(destX != x && destY != y)) {
            //top
            if (destY < y) {
                for (int i = x, j = y-1; j > destY; j--) {
                    System.out.println(i + "," + j);
                    if (!t[j][i].isEmpty())
                        return false;
                }
            }
            
            //right
            if (destX > x) {
                for (int i = x+1, j = y; i < destX; i++) {
                    if (!t[j][i].isEmpty())
                        return false;
                }
            }
            
            //bot
            if (destY > y) {
                for (int i = x,j = y+1; j < destY; j++) {
                    if (!t[j][i].isEmpty())
                        return false;
                }
            }
            
            //left
            if (destX < x) {
                for (int i = x-1, j = y; i > destX; i--) {
                    if (!t[j][i].isEmpty())
                        return false;
                }
            }
            return true;
        }
        return false;
    }
}

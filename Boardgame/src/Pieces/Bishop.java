package Pieces;

import javax.swing.ImageIcon;
import Chess.Tile;
import java.awt.Point;
import java.lang.Math;

/**
 * Bishop chess piece.
 * 
 * @author Chris Cho, A00972501, Set A
 * @version 1.0
 */
public class Bishop extends Piece{
    private Point validAreas;
    
    /**
     * Bishop constructor.
     * @param p the owner of this piece
     */
    public Bishop(int p) {
        super(p);
        if (p == 1) {
            pieceIcon = new ImageIcon("icons\\wBishop.png");
        } else {
            pieceIcon = new ImageIcon("icons\\bBishop.png");
        }
    }
    
    public Point getLocation() {
        return validAreas;
    }
    
    /** 
     * Evaluates the validity of the move based on the knight pieces movement rules.
     * The movement is only valid when the move distance of x and y are both the same.
     * Direction is irrelevant, only magnitude is considered.
     */
    public boolean validMove(int x, int y, int destX, int destY) {
        return ((Math.pow((destX - x),2)) == (Math.pow((destY - y), 2)));
    }

    public boolean valid(int x, int y, int destX, int destY, final Tile[][] t) {
        boolean condition;
        int topRightStop;
        int topLeftStop;
        int botRightStop;
        int botLeftStop;
        //front right
        for (int i = (x+1), j = (y-1); i < 8 && j >= 0; i++, j--) {
            if (!t[j][i].isEmpty()) {
                
                break;
            }
        }
        
        //front left
        for (int i = (x-1), j = (y-1); i >= 0 && j >= 0; i--, j--) {
            if (!t[j][i].isEmpty()) {
                break;
            }
        }
        
        //back right
        for (int i = (x+1), j = (y+1); i < 8 && j < 8; i++, j++) {
            if (!t[j][i].isEmpty()) {
                break;
            }
        }
        
        //back left
        for (int i = (x-1), j = (y-1); i >= 0 && j < 8; i--, j++) {
            if (!t[j][i].isEmpty()) {
                break;
            }
        }
    }
}

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
    public boolean validMove(int x, int y, int destX, int destY, final Tile[][] t) {
        if (Math.abs(destX-x) == Math.abs(destY-y)) {
            //top right
            if (destX > x && destY < y) {
                for (int i = x+1, j = y-1; i < destX; i++, j--) {
                    //System.out.println(i + ", " + j);
                    if (!t[j][i].isEmpty()) {
                        //System.out.println("PIECE BLOCK: " + "[" + i + "," + j + "]\n");
                        return false;
                    }
                }
                //System.out.println("Completed Scan\n");
            }
            
            //top left
            if (destX < x && destY < y) {
                for (int i = x-1, j = y-1; i > destX; i--, j--) {
                    //System.out.println(i + ", " + j);
                    if (!t[j][i].isEmpty()) {
                        //System.out.println("PIECE BLOCK: " + "[" + i + "," + j + "]\n");
                        return false;
                    }
                }
                //System.out.println("Completed Scan\n");
            }
            
            //bot right
            if (destX > x && destY > y) {
                for (int i = x+1, j = y+1; i < destX; i++, j++) {
                    //System.out.println(i + ", " + j);
                    if (!t[j][i].isEmpty()) {
                        //System.out.println("PIECE BLOCK: " + "[" + i + "," + j + "]\n");
                        return false;
                    }
                }
                //System.out.println("Completed Scan\n");
            }
            
            //bot left
            if (destX < x && destY > y) {
                for (int i = x-1, j = y+1; i > destX; i--, j++) {
                    //System.out.println(i + ", " + j);
                    if (!t[j][i].isEmpty()) {
                        //System.out.println("PIECE BLOCK: " + "[" + i + "," + j + "]\n");
                        return false;
                    }
                }
                //System.out.println("Completed Scan\n");
            }
            return true;
        }
        return false;
    }
}

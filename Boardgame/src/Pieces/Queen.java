package Pieces;

import javax.swing.ImageIcon;

import Chess.Tile;

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
    public boolean validMove(int x, int y, int destX, int destY, final Tile[][] t) {
        return (diagonal(x,y,destX,destY,t) || straight(x,y,destX,destY,t));
    }

    private boolean diagonal(int x, int y, int destX, int destY, final Tile[][] t) {
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
                for (int i = x-1, j = y+1; i >= destX; i--, j++) {
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
    
    private boolean straight(int x, int y, int destX, int destY, final Tile[][] t) {
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

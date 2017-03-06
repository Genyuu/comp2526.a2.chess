package Chess;

import javax.swing.JFrame;

/**
 * Main class creates and drives the chess program.
 * 
 * @author Chris Cho, A00972501, Set A
 * @version 2.0
 */
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Chess");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.getContentPane().add(new Engine());
        frame.pack();
        frame.setSize(800,850);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

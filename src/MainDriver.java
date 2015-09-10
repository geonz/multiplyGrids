/**
 * Created by Sue on 9/6/2015.
 */
import javax.swing.JFrame;


public class MainDriver {


    public static void main(String[] args) {

        JFrame frame = new JFrame("Making a Multiplication Array");
        // okay, let's see if adding the location helps.

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridPanel chpanel = new GridPanel(7,8);  // this was "makesquares" in the chess game.
        frame.getContentPane().add(chpanel);
        SendFactorsPanel drawMoves = new SendFactorsPanel();
        frame.getContentPane().add(drawMoves);


//		SendFactorsPanel drawMoves3 = new SendFactorsPanel();
        frame.getContentPane().add(drawMoves);
        // so in *this* example you need to declare, and then it adds both panels.
        // but if you think you add another it looks exactly the same.
        frame.pack();
        frame.setVisible(true);

    }

}
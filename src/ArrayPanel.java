/**
 * Created by Sue on 9/6/2015.
 */
import java.awt.Dimension;

import javax.swing.JPanel;
// aug 7 this is not being used at all yet. SEPT 6  BUT WE ARE BRINGING IT OVER TO JIDEA ANYWAY

// okay this is something that will require a *little* thought but
// make this just like the gridsquares except it's 10 by 10 and each square includes
// text of a number.
//

public class ArrayPanel extends JPanel {
    private Square oneSquare;
    private Square [][] squareGrid;

    int numColumns = 5;   // this will be part of the possible constructions, later, so that it could be changed for bigger numbers.
    int numRows = 5;
    private  int WIDTH = 200;
    private int HEIGHT = 200;


    public ArrayPanel (int x, int y)
    {
        numColumns = x;
        numRows = y;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        squareGrid = new Square[numColumns][numRows];  // this is making the array iwth the little squares

        // let us construct a grid of the squares
        for (int i = 0; i < numColumns; i++)
            for (int j = 0; j < numRows; j++)// this is how to do the 2D array.  Which is cool.
            {     oneSquare = new Square(i,j);
                oneSquare.setInGroup(false); // this starts it out as "just here."
                squareGrid [i][j] = oneSquare;
            }// now our array is filled with oneSquares.

    }

    public ArrayPanel ()
    {

    }


}

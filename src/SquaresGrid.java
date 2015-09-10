import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

// this is where the "board size" is determined -- for the display. Bcause this *is* a panel.
// If I change it *here* (up top) it is okay.  HOWEVER:  we all know that if it's not a constant
// it shouldn't be instantiated up here at the top.
public class SquaresGrid extends JPanel {  // this is parallel to MakeSquares, I think.
    private Square oneSquare;
    private Square [][] squareGrid;

    int num_columns;
    int num_rows;

    private  int WIDTH = 400;
    private int HEIGHT = 400;


// here is where we build an array.  So "gridSquares" is the class that has the array of squares.
    //
    // It is a separate class because it is a separate panel for people to look at.
    // I *think* you want separate classes more often than not.

    public SquaresGrid()
    {
        num_columns = 10;
        num_rows= 10;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        squareGrid = new Square[num_columns][num_rows];  // this is making the array iwth the little squares

        // let us construct a grid of the squares
        for (int i = 0; i < num_columns; i++)
            for (int j = 0; j < num_rows; j++)// this is how to do the 2D array.  Which is cool.
            {     oneSquare = new Square(i,j);
                oneSquare.setInGroup(false); // this starts it out as "just here."
                squareGrid [i][j] = oneSquare;
            }// now our array is filled with oneSquares.

    }
    // this one is *not* used at this poisnt.
    public SquaresGrid(int x, int y)
    {
        num_columns=x;
        num_rows=y;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        squareGrid = new Square[num_columns][num_rows];  // this is making the array iwth the little squares

        // let us construct a grid of the squares
        for (int i = 0; i < num_columns; i++)
            for (int j = 0; j < num_rows; j++)// this is how to do the 2D array.  Which is cool.
            {     oneSquare = new Square(i,j);
                oneSquare.setInGroup(false); // this starts it out as "just here."
                squareGrid [i][j] = oneSquare;
            }// now our array is filled with oneSquares.
    }


    protected void paintComponent (Graphics g)
    {
        super.paintComponent(g);
        for (int i = 0; i < num_columns; i++)
            for (int j = 0; j <num_rows; j++)
            {
                squareGrid[i][j].draw(g);// we have to go make this.
                // You're not drawing the whole array; you're drawing that one squre pice of the array.

            }

    }


    // accessors and mutators
    public Square getOneSquare() {
        return oneSquare;
    }

    public void setOneSquare(Square oneSquare) {
        this.oneSquare = oneSquare;
    }

    public Square[][] getSquareGrid() {
        return squareGrid;
    }

    public void setSquareGrid(Square[][] squareGrid) {
        this.squareGrid = squareGrid;
    }



    public int getWIDTH() {
        return WIDTH;
    }

    public void setWIDTH(int wIDTH) {
        WIDTH = wIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public void setHEIGHT(int hEIGHT) {
        HEIGHT = hEIGHT;
    }

    public int getNum_columns() {
        return num_columns;
    }

    public void setNum_columns(int num_columns) {
        this.num_columns = num_columns;
    }

    public int getNum_rows() {
        return num_rows;
    }

    public void setNum_rows(int num_rows) {
        this.num_rows = num_rows;
    }



}

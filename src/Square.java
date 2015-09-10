/**
 * Created by Sue on 9/6/2015.
 */
import java.awt.Color;
import java.awt.Graphics;

//import javax.swing.ImageIcon;


public class Square {

    private Color color;   // so we can make the background what we'd like ... we have to decide.
    private int colnum;  // so we can plop them into an array
    private int rownum;
    private int sideSize;  // so we can make them as big or small as we want
    private boolean inGroup;

    // We'll have to see if this is really necessary.
//	private MakeGrid gridMaker;  that was not necessary.

    // constructor   (yes, I"m pretending I have never ever done this before.)
    public Square()
    {
        colnum = 0;
        rownum = 0;
        sideSize = 40;  // there's a default.
        inGroup = false;
        color = Color.blue;
    }

    public Square (int colnum, int rownum)
    {
        this.colnum = colnum;
        this.rownum = rownum;
        sideSize = 40;
        inGroup=false;
        color = Color.blue;

    }
    // LET US DRAW EACH INDIVIDUAL SQUARE
    public void draw (Graphics g)
    {
        if ((rownum + colnum) %2 == 0)
        {
            g.setColor(Color.black);
        }
        else	if ((rownum + colnum) % 2 == 1)
        {
            g.setColor(Color.gray);
        }
        g.fillRect(colnum*sideSize, rownum*sideSize, 40, 40);

        // ** this is the part where certain ones o fthem are turned pink.
        if (inGroup)
        {g.setColor(Color.pink);// this is where the transparency happens.   Borrow it tomorrow.
            g.fillOval(colnum*sideSize + sideSize/4 ,rownum*sideSize + sideSize/4, sideSize/2, sideSize/2);
            // this is where we will do the transparency if we remember how. STD. What trumps design?  Syntax, dear.  If
            // there's no clue how to do it right, you have to just do what will work.
        }



        // this makes circles on the grid that aren't from the above selection of "In Group" in other colors, in sequence.
        else  if ((rownum+colnum)%3 == 0)
        {

            g.setColor(Color.green);
            g.fillOval(colnum*sideSize + sideSize/4 ,rownum*sideSize + sideSize/4, sideSize/2, sideSize/2);	// yea, that's hard coded.  Let's see if this works and then ...
        }
        else if ((rownum+colnum)%3==1)
        {

            g.setColor(Color.blue);
            g.fillOval(colnum*sideSize + sideSize/4 ,rownum*sideSize + sideSize/4, sideSize/2, sideSize/2);	// yea, that's hard coded.  Let's see if this works and then ...
        }
        else if ((rownum+colnum)%3==2)
        {
            g.setColor(Color.yellow);
            g.fillOval(colnum*sideSize + sideSize/4 ,rownum*sideSize + sideSize/4, sideSize/2, sideSize/2);	// yea, that's hard coded.  Let's see if this works and then ...
        }
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public int getColnum() {
        return colnum;
    }
    public void setColnum(int colnum) {
        this.colnum = colnum;
    }
    public int getRownum() {
        return rownum;
    }
    public void setRownum(int rownum) {
        this.rownum = rownum;
    }
    public int getSideSize() {
        return sideSize;
    }
    public void setSideSize(int sideSize) {
        this.sideSize = sideSize;
    }
    public boolean isInGroup() {
        return inGroup;
    }
    public void setInGroup(boolean inGroup) {
        this.inGroup = inGroup;
    }

}

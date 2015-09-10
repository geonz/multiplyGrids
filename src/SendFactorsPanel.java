import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
// accessors and mutators have been included.

public class SendFactorsPanel extends JPanel {


    private SquaresGrid board;
    private JLabel pickFactor1, pickFactor2;
    private JButton drawMovesButton;
    // HERE IS A NEW BUTTON THAT WE HOPE WILL CHANGE THE VALUES SO WE CAN MAKE DIFF KINDS OF ARRAYS.
    private JButton factor1isTwo, factor1is3, factor1is4, factor1is5;
    private JButton factor1isZERO, factor1isONE;

    private JButton factor2isTwo, factor2is3, factor2is4, factor2is5;
    private JButton factor2isZERO, factor2isONE;
    //private JButton pickFactor2_1;
    private DrawDirections drawGroups;


    public SendFactorsPanel()
    {

        //   okay, dear one, honestly it should take you about an hour to add "input" for integers between 1 and 9
        // where in the buttonlistener assigns the boardSize based thereupon, as well as first and second factor.
        // ((aug??  I don't think we did this -- I think I meant this wold eb where user entered a times table,
        // (aug) ... mebbe from buttons, not typine, or both.
        // and yes, you can even put in for the exceptions.
        // (aug, I reckon that would be the advantage to clicking buttons instead of typing input. Since it's a skill I
        // need to review, I'd best review that... but when I've got access to more than the Rapidan River, eh?)

        // but... right... maybe spend an hour on "javascripting" it.   ??  aug methnks *get a fully working thingy* first.
        // b/c lesson from integer app:  starting in the middle isn't a user ready thingy.
        //so  the plan this a.m. is to find the 'input' ones.

        pickFactor1 = new JLabel("Choose the first factor");
        add(pickFactor1);

        factor1isTwo = new JButton("2");
        add(factor1isTwo);
        factor1isTwo.addActionListener(new Factor1isTwoListener());

        factor1is3 = new JButton("3");
        add(factor1is3);
        factor1is3.addActionListener(new Factor1is3Listener());

        factor1is4 = new JButton("4");
        add(factor1is4);
        factor1is4.addActionListener(new Factor1is4Listener());

        factor1is5 = new JButton("5");
        add(factor1is5);
        factor1is5.addActionListener(new Factor1is5Listener());
        // Oy Vey, girls, we do forget things. Don't we!!!


        factor2is3 = new JButton("3");




        drawMovesButton = new JButton ("Make Array");
        // okay, *now* changing this changes the buttons.
        add(drawMovesButton);
        drawMovesButton.addActionListener(new MovesButtonListener());


        //AUG 7:  WE ARE MAKING A NEW BOARD.   we sbould be able to ... okay
        // WHAT YOU NEED TO DO IS GRAPH OUT HOWT HESE CLASSES TALK TO EACH OTHER NOW THAT THEY'RE DONE.
        board = new SquaresGrid();  // this, dear heart, ***CREATES*** THE ARRAY.
        //  **** HERE IS WHERE TO LOOK!!!!
        //*** SGIYKD VE ABLE TO CHANGE THE SIZES AND STUFF HERE...
        //INSTEAD OF () CONSTRUCTOR RING IN X AND Y WHERE DO WE GET 'EM FROM.



        add(board);  // aug 15 I THINK bu tI'm not sure this is means "draw the board panel inside this panel."   Or not???   FIGURE OUT
        drawGroups = new DrawDirections(board.getSquareGrid());
        // SIGH.   too bad not understanding that means I don't know how to change teh thingies.
        // Okay, dear, here's what the deal is.   "draw directions" *owns* the board.   Your "Drawing Direction"
        // and yes, you could figure out a name that doesn't imply plurality ;)
        // is the "big idea" and it ... yes, it is the part of the interface that *could be* drawing anything!
        // it might not be a board; it might be a number line.   This particular DrawDirections happens to own a grid of squares
        //GridSquares named board.
        // So we're going to go to "draw directions" and that's what we will tell to change the factor!!!!!
    }

    public class MovesButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {

            drawGroups.drawMoves(getGraphics());
            repaint();
            // recognizing that "drawGroups" is the name of the "DrawDirections" class.
        }
    }







    public class Factor1isTwoListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            drawGroups.setFirstFactor(2);
            System.out.println("First Factor thinks it's been set to " + drawGroups.getFirstFactor());
        }
    }
    public class Factor1is3Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            drawGroups.setFirstFactor(3);
            System.out.println("First Factor thinks it's been set to " + drawGroups.getFirstFactor());
        }
    }
    public class Factor1is4Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            drawGroups.setFirstFactor(4);
            System.out.println("First Factor thinks it's been set to " + drawGroups.getFirstFactor());
        }
    }
    public class Factor1is5Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            drawGroups.setFirstFactor(5);
            System.out.println("First Factor thinks it's been set to " + drawGroups.getFirstFactor());
        }
    }

    // okay here's where we get crazy :)
    



    //GETTERS AND SETTERS  from henceforth
    public SquaresGrid getBoard() {
        return board;
    }

    public void setBoard(SquaresGrid board) {
        this.board = board;
    }

    public JButton getDrawMovesButton() {
        return drawMovesButton;
    }

    public void setDrawMovesButton(JButton drawMovesButton) {
        this.drawMovesButton = drawMovesButton;
    }

    public DrawDirections getDrawGroups() {
        return drawGroups;
    }

    public void setDrawGroups(DrawDirections drawGroups) {
        this.drawGroups = drawGroups;
    }
}

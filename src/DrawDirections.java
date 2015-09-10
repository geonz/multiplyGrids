import java.awt.Graphics;
import java.util.Random;
// Project->Properties->Java Build Path->Libraries for the cause.   Of the red exclamation poitn, which came from ... I added the library that was default
// and removed the other one .

// SO THIS IS NOT A PANEL. THAT IS WHY WHEN YOU CHANGE THINGS PERHAPS IT CONFUSES THE PANELS?
//  WHEN I CHANGED FACTORS IN THE SECOND CONSTRUCTORS IT NULL POINTER EXCEPTIONED.
public class DrawDirections {

    /*//THis determines which squares will have things on them and which ones won't.
    // DESIGN  BIG goal:   This will be called by the game and told which times table to do.

    // User will see a "times table" displayed.   (** separate panel??? :)  Easier in Android, eh?)

    // a demo button will demonstrate and show:
        // cursor moving over and clicking where there are a sequence of X circles together.
         // Those circles will disappear and then reappear in the "array" panel and x times 1 = x
            // will also show up in #grid (reckon we can have the 4 x 1 = 4 on a sep. panel)
        // x +=  .. next circle clicked will illuminate x times 2...
        // when you get to the end then you will be permitted to click the answer in the "answer grid"
        // which is a number grid.

        // duly note this is totally visually overwhelming and there's no way *you * would see the patterns
        // in all of those things at the same time.

        // SO!  no #grid panel -- *just* the "answer" number grid panel.   Maybe level one will *just* have the arrays.
        // LEvel two can move from the arrays to the grid -- or perchance leave out the random clumpings.
        // THink about having user click 4, 8, 12 and 16 for 4 x 4 (Prompt for 4 x 1, 4 x2, etc.)



    //(I'm still thinking of lots of possibilities. The **main goal** is to have student be able to do things
    // like factor polynomials b/c s/he knows 4 x 5 is 20 and so is 2 x 10.   But that divisibility
    // stuff can come *after* this.  Also, you can have the powerpoints COME FIRST.
    // PPTS can help w/ the language connection and provide extra instruction.
    //
*/
    private Square oneSquare;
    private Square[][] squareGrid2;

    int firstFactor;
    int secondFactor;
    Random rand1 = new Random();
    //   SEPARATE the 'check to see if it's taken' loop from the 'go ahead and draw it if it isn't taken' loop.
    //   This is because Break doesn't work. Sorry. Syntax Trumps Design.

    int randCol;
    int randRow;
    boolean isTaken;

    private int boardSize; // so we don't explode out of the array adn get those nasty null pointers
    // aug 2015 note:  Erm, yes, this is the stuff we may have forgotten. Ponder :)
    //*** okay***  this is the same variable in two classes which is a stupid thing.
    //    but I think that was just so you make the loop stop at the end of the row.
    // lets send it there, okay?   We made a copy of this in "copy of draw directions" for when this blows up in our faces.

    public DrawDirections()
    {
        oneSquare = new Square();   // Still don't know if this is necessary

        boardSize = 7;
        // OKAY, changing this ... *doesn't change things.*  Once again, ... will it show up if I totally close down???
        firstFactor = 2;   // this will be totally modified later so that it can either be assigned by the app which by the way I hope hope hope I can translate or randomly generated.
        secondFactor = 4;
        squareGrid2 = new Square [firstFactor] [secondFactor];// i changed this but it didn't change anything.

        isTaken = false;
        // THese constructors don't seem to matter one whit.   It makes a 3 x 4 game on a 10 x 10 board NO MATTER WHAT.
    }
    public DrawDirections(Square[][] squareGrid)
    {
//  I'm not sure what this was about.  WOuld I send the whole array?  We'll see... **I think we did.**
        squareGrid2 = squareGrid;
        oneSquare = new Square();   // Still don't know if this is necessary

        boardSize = 8;

        firstFactor = 3;   // this will be totally modified later so that it can either be assigned by the app which by the way I hope hope hope I can translate or randomly generated.
        secondFactor = 4;
        isTaken = false;

    }
    // constructor for when this is called by other things or picked by person.
    public DrawDirections(Square[][] squareGrid, int firstNum, int secondNum)
    {
        squareGrid2 = squareGrid;
        oneSquare = new Square();   // Still don't know if this is necessary

        boardSize = 8;

        firstFactor = firstNum;   // this will be totally modified later so that it can either be assigned by the app which by the way I hope hope hope I can translate or randomly generated.
        secondFactor = secondNum;
        isTaken = false;

    }

    public void drawMoves (Graphics g)
    {// this board panel should take that name after the  thing is pressed (we will be "repainting")
        // and repaint with  the icon in the centerpiece panel. //
        // RESET
        for (int i = 0; i < boardSize; i++)
            for (int j = 0; j < boardSize; j++)
            //
            {
                //squareGrid2[i][j] = oneSquare;  No, dear.   This grid should already be created
                squareGrid2[i][j].setInGroup(false);

            }

        int factorCount = 0;

        while (factorCount < secondFactor)

        {
            // first, generate a random number for the row we're going to try to color a group in.
            randCol = rand1.nextInt(boardSize);
            randRow= rand1.nextInt(boardSize);
            //		System.out.println("randCol is " + randCol + "and RandRow is " + randRow);

            // next, test to see if the group would fit.
            if ((randCol + firstFactor) < boardSize )
            {   isTaken = false;   // always reset, dear.
                // next, go through the possible pieces and test for already being landable
                for (int k = randCol; k <(randCol + firstFactor+1); k++ )
                {// check the squares we'd do, and the one bfore andafter it.
                    if ((k < boardSize) && squareGrid2[k][randRow].isInGroup() || (k >0 && squareGrid2[k-1][randRow].isInGroup()))
                    {
                        isTaken = true;
                        System.out.println("seems it's landable, already");
                    }
                }

                if (isTaken == false) // I know we could do the ! thing but ... something's
                {
//					System.out.println("we're allowed to enter the loop!!");
                    for (int l = randCol; l < (randCol+firstFactor); l++)
                    {
                        squareGrid2[l][randRow].setInGroup(true);
                    }
                    factorCount++;
                }

            }
        }

    }
    //GETTERS AND SETTERS
    public Square getOneSquare() {
        return oneSquare;
    }

    public void setOneSquare(Square oneSquare) {
        this.oneSquare = oneSquare;
    }

    public Square[][] getSquareGrid2() {
        return squareGrid2;
    }

    public void setSquareGrid2(Square[][] squareGrid2) {
        this.squareGrid2 = squareGrid2;
    }

    public int getFirstFactor() {
        return firstFactor;
    }

    public void setFirstFactor(int firstFactor) {
        this.firstFactor = firstFactor;
    }

    public int getSecondFactor() {
        return secondFactor;
    }

    public void setSecondFactor(int secondFactor) {
        this.secondFactor = secondFactor;
    }

    public Random getRand1() {
        return rand1;
    }

    public void setRand1(Random rand1) {
        this.rand1 = rand1;
    }



    public int getRandCol() {
        return randCol;
    }

    public void setRandCol(int randCol) {
        this.randCol = randCol;
    }

    public int getRandRow() {
        return randRow;
    }

    public void setRandRow(int randRow) {
        this.randRow = randRow;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        this.isTaken = taken;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }}

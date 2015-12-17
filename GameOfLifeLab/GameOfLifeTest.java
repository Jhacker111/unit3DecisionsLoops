
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import info.gridworld.actor.Actor;

/**
 * The test class GameOfLifeTest.
 *
 * @author  @gcschmit
 * @version 19 July 2014
 */
public class GameOfLifeTest
{
    /**
     * Default constructor for test class GameOfLifeTest
     */
    public GameOfLifeTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testInitialState()
    {
        /* expected pattern for initial state
         *  (X: alive; -: dead)
         * 
         *    12 13 14 15 16
         *  12 X  -  -  -  -
         *  13 X  -  -  -  -
         *  14 X  -  -  -  -
         *  15 X  -  -  -  -
         *  16 X  X  X  X  X
         *  
         */

        GameOfLife game = new GameOfLife();
        final int ROWS = game.getNumRows();
        final int COLS = game.getNumCols();

        for(int row = 0; row < ROWS; row++)
        {
            for(int col = 0; col < COLS; col++)
            {
                // in this example, an alive cell has a non-null actor and a dead cell has a null actor
                Actor cell = game.getActor(row, col);

                // if the cell at the current row and col should be alive, assert that the actor is not null
                if(     (row == 12 && col == 12) ||
                (row == 13 && col == 12) ||
                (row == 14 && col == 12) ||
                (row == 15 && col == 12) ||
                (row == 16 && col == 12) ||
                (row == 16 && col == 13) ||
                (row == 16 && col == 14) ||
                (row == 16 && col == 15) ||
                (row == 16 && col == 16))
                {
                    assertNotNull("expected alive cell at (" + row + ", " + col + ")", cell);
                }
                else // else, the cell should be dead; assert that the actor is null
                {
                    assertNull("expected dead cell at (" + row + ", " + col + ")", cell);
                }
            }
        }
    }

    @Test
    public void testFinalState()
    {
        /* verify that the actual pattern matches the expected pattern after 3 generations         *  
         */

        // ...
        /* expected pattern for initial state
         *  (X: alive; o: dead)
         *   
         *   11 12 13 14 15 16 17 18
         * 10 o  o  o  o  o  o  o  o
         * 11 o  X  X  o  o  o  o  o
         * 12 o  X  X  o  o  o  o  o
         * 13 o  o  o  o  o  o  o  o
         * 14 o  o  o  o  o  o  o  o
         * 15 o  o  o  o  o  X  X  o
         * 16 o  o  o  o  o  X  X  o
         * 
         */

        GameOfLife game = new GameOfLife();
        final int ROWS = game.getNumRows();
        final int COLS = game.getNumCols();

        for(int row = 0; row < ROWS; row++)
        {
            for(int col = 0; col < COLS; col++)
            {
                // in this example, an alive cell has a non-null actor and a dead cell has a null actor
                Actor cell = game.getActor(row, col);

                // if the cell at the current row and col should be alive, assert that the actor is not null
                if(     (row == 11 && col == 12) ||
                (row == 11 && col == 13) ||
                (row == 12 && col == 12) ||
                (row == 12 && col == 13) ||
                (row == 15 && col == 16) ||
                (row == 15 && col == 17) ||
                (row == 16 && col == 16) ||
                (row == 16 && col == 17))
                {
                    assertNotNull("expected alive cell at (" + row + ", " + col + ")", cell);
                }
                else // else, the cell should be dead; assert that the actor is null
                {
                    assertNull("expected dead cell at (" + row + ", " + col + ")", cell);
                }
            }
        }
    }
}


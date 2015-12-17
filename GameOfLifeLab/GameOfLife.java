import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import java.util.ArrayList;

/**
 * Game of Life starter code. Demonstrates how to create and populate the game using the GridWorld framework.
 * Also demonstrates how to provide accessor methods to make the class testable by unit tests.
 * 
 * @author @HS\Jhhacker
 * @version 17 November 2015
 */
public class GameOfLife
{
    // the world comprised of the grid that displays the graphics for the game
    private ActorWorld world;

    // the game board will have 30 rows and 30 columns
    private final int ROWS = 30;
    private final int COLS = 30;

    /**
     * Default constructor for objects of class GameOfLife
     * 
     * @post    the game will be initialized and populated with the initial state of cells
     * 
     */
    public GameOfLife()
    {
        // create the grid, of the specified size, that contains Actors
        BoundedGrid<Actor> grid = new BoundedGrid<Actor>(ROWS, COLS);

        // create a world based on the grid
        world = new ActorWorld(grid);

        // populate the game
        populateGame();

        // display the newly constructed and populated world
        world.show();
        // creates 4 generations and pauses for 1 second in between each one
        for (int i=4; i < 10; i++)
        {
            createNextGeneration();
            try
            {
                Thread.sleep(1000);
            } 
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * Creates the actors and inserts them into their initial starting positions in the grid
     *
     * @pre     the grid has been created
     * @post    all actors that comprise the initial state of the game have been added to the grid
     * 
     */
    private void populateGame()
    {
        // constants for the location of the three cells initially alive
        final int X1 = 12, Y1 = 12;
        final int X2 = 12, Y2 = 13;
        final int X3 = 12, Y3 = 14;
        final int X4 = 12, Y4 = 15;
        final int X5 = 12, Y5 = 16;
        final int X6 = 13, Y6 = 16;
        final int X7 = 14, Y7 = 16;
        final int X8 = 15, Y8 = 16;
        final int X9 = 16, Y9 = 16;

        // the grid of Actors that maintains the state of the game
        //  (alive cells contains actors; dead cells do not)
        Grid<Actor> grid = world.getGrid();

        // create and add rocks (a type of Actor) to the 9 intial locations
        Rock rock1 = new Rock();
        Location loc1 = new Location(Y1, X1);
        grid.put(loc1, rock1);

        Rock rock2 = new Rock();
        Location loc2 = new Location(Y2, X2);
        grid.put(loc2, rock2);

        Rock rock3 = new Rock();
        Location loc3 = new Location(Y3, X3);
        grid.put(loc3, rock3);

        Rock rock4 = new Rock();
        Location loc4 = new Location(Y4, X4);
        grid.put(loc4, rock4);

        Rock rock5 = new Rock();
        Location loc5 = new Location(Y5, X5);
        grid.put(loc5, rock5);

        Rock rock6 = new Rock();
        Location loc6 = new Location(Y6, X6);
        grid.put(loc6, rock6);

        Rock rock7 = new Rock();
        Location loc7 = new Location(Y7, X7);
        grid.put(loc7, rock7);

        Rock rock8 = new Rock();
        Location loc8 = new Location(Y8, X8);
        grid.put(loc8, rock8);

        Rock rock9 = new Rock();
        Location loc9 = new Location(Y9, X9);
        grid.put(loc9, rock9);
    }

    /**
     * Generates the next generation based on the rules of the Game of Life and updates the grid
     * associated with the world
     *
     * @pre     the game has been initialized
     * @post    the world has been populated with a new grid containing the next generation
     * 
     */
    private void createNextGeneration()
    {
        /** You will need to read the documentation for the World, Grid, and Location classes
         *      in order to implement the Game of Life algorithm and leverage the GridWorld framework.
         */

        // create the grid, of the specified size, that contains Actors
        Grid<Actor> grid = world.getGrid();
        // initializes the list of adjacent actors
        ArrayList<Actor> adjacents = new ArrayList<Actor>();
        // initializes the list of coordinates to add
        ArrayList<Location> toAdd = new ArrayList<Location>();
        // initializes the list of coordinates to remove
        ArrayList<Location> toRemove = new ArrayList<Location>();
        // iterates through each square on the board
        for(int i = 0; i < ROWS; i++)
        {
            for (int j = 0; j < COLS; j++)
            {
                // initializes the location variable for the current square
                Location location = new Location(i,j);
                // grabs the actor location if there is one
                Actor currentUnit = grid.get(location);
                // grabs the coordinates of the neighbor actors; we don't care about each coordinate, only the value around the current square
                adjacents = grid.getNeighbors(location);
                // checks to see if we grabbed anything when we got the currentUnit
                if (currentUnit == null)
                {
                    // checks to see if it needs to create an actor for the next generation, then adds the coordinate to the list if it does
                    switch (adjacents.size())
                    {
                        case 0: break;
                        case 1: break;
                        case 2: break;
                        case 3: toAdd.add(location);
                        case 4: break;
                        case 5: break;
                        case 6: break;
                        case 7: break;
                        case 8: break;
                        default: break;
                    }
                }
                else
                {
                    switch (adjacents.size())
                    {
                        // checks to see if it needs to remove the actor from the selected square for the next generation
                        case 0: toRemove.add(location);
                        case 1: toRemove.add(location);
                        case 2: break;
                        case 3: break;
                        case 4: toRemove.add(location);
                        case 5: toRemove.add(location);
                        case 6: toRemove.add(location);
                        case 7: toRemove.add(location);
                        case 8: toRemove.add(location);
                        default: toRemove.add(location);
                    }
                }
            }
        }
        for (Location activeCell: toAdd)
        {
            // checks to make sure the square it's about to add is in bounds
            if(activeCell.getCol() <= COLS && activeCell.getCol() >= 0 && activeCell.getRow() <= ROWS && activeCell.getRow() >= 0)
            {
                // creates a rock and places it on the grid
                Rock nextGenRock = new Rock();
                grid.put(activeCell, nextGenRock);
            }
        }

        for (Location activeCell: toRemove)
        {
            // checks to make sure the square it's about to remove is in bounds
            if(activeCell.getCol() <= COLS && activeCell.getCol() >= 0 && activeCell.getRow() <= ROWS && activeCell.getRow() >= 0)
            {
                //removes the actor from the selected spot
                grid.remove(activeCell);
            }
        }
        //updates the grid
        world.show();
    }

    /**
     * Returns the actor at the specified row and column. Intended to be used for unit testing.
     *
     * @param   row the row (zero-based index) of the actor to return
     * @param   col the column (zero-based index) of the actor to return
     * @pre     the grid has been created
     * @return  the actor at the specified row and column
     */
    public Actor getActor(int row, int col)
    {
        Location loc = new Location(row, col);
        Actor actor = world.getGrid().get(loc);
        return actor;
    }

    /**
     * Returns the number of rows in the game board
     *
     * @return    the number of rows in the game board
     */
    public int getNumRows()
    {
        return ROWS;
    }

    /**
     * Returns the number of columns in the game board
     *
     * @return    the number of columns in the game board
     */
    public int getNumCols()
    {
        return COLS;
    }

    /**
     * Creates an instance of this class. Provides convenient execution.
     *
     */
    public static void main(String[] args)
    {
        GameOfLife game = new GameOfLife();
    }

}

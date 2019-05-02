//==============================================================================
// File: LocationTest.java
// Description: White box unit tests for the Location software unit.
// Revision: 1.0.0
//
//   DEPENDENCIES, LIMITATIONS, & DESIGN NOTES:
//       Dependencies : Run with JUnit5.
//       Limitations  : No known limitations.
//       Design Notes :
//           1. 100% code coverage was achieved for this software unit.
//           2. Many of the functions are getters and setters with boolean 
//              values which leads to simple test cases.
//           3. Equivalence class partitioning was performed for functions
//              that take non-boolean input parameters.
//           4. Function header comments were omitted for readability and due 
//              to the simplicity of the test cases and their self-documenting
//              names.
//==============================================================================

//==============================================================================
// Imports
//==============================================================================
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

//==============================================================================
// Class declarations
//==============================================================================
class LocationTest
{
    // Local constants for this test class 
    static final int UNSET = 0;
    
    @Test
    void testLocation()
    {
    	Location testLoc = new Location();
    	assertEquals(testLoc.getStatus(), 0);
    	assertEquals(testLoc.hasShip(), false);
    	assertEquals(testLoc.getLengthOfShip(), -1);
    	assertEquals(testLoc.getDirectionOfShip(), -1);
    }

    @Test
    void testCheckHit()
    {
    	Location testLoc = new Location();
    	assertEquals(testLoc.checkHit(), false);
    	testLoc.markHit();
    	assertEquals(testLoc.checkHit(), true);
    }

    @Test
    void testCheckMiss()
    {
    	Location testLoc = new Location();
    	assertEquals(testLoc.checkMiss(), false);
    	testLoc.markMiss();
    	assertEquals(testLoc.checkMiss(), true);
    }

    @Test
    void testIsUnguessed()
    {
        Location location = new Location();
        
        // -1 - Invalid boundary limit
        //  0 - Valid boundary limit
        //  1 - Valid boundary limit
        //  2 - Valid boundary limit
        //  3 - Invalid boundary limit
        int [] partitions = {-1, Location.UNGUESSED, Location.HIT, Location.MISSED, 3};
        boolean [] expected = {false, true, false, false, false};
        
        // Internal check for test case validity
        assertEquals(partitions.length, expected.length);

        // Loop through partitions and verify the get() matches the set()
        for (int i = 0; i < partitions.length; i++)
        {
            location.setStatus(partitions[i]);
            assertEquals(expected[i], location.isUnguessed());
        }
    }

    @Test
    void testMarkHit()
    {
        Location testLoc = new Location();
        assertEquals(Location.UNGUESSED,testLoc.getStatus());
        testLoc.markHit();
        assertEquals(Location.HIT, testLoc.getStatus());
        testLoc.markMiss();
        testLoc.markHit();
        assertEquals(Location.HIT,testLoc.getStatus());
    }

    @Test
    void testMarkMiss()
    {
        Location testLoc = new Location();
        assertEquals(Location.UNGUESSED,testLoc.getStatus());
        testLoc.markMiss();
        assertEquals(Location.MISSED, testLoc.getStatus());
        testLoc.markHit();
        testLoc.markMiss();
        assertEquals(Location.MISSED, testLoc.getStatus());
    }

    @Test
    void testSetHasShip()
    {
        Location testLoc = new Location();
        assertEquals(false, testLoc.hasShip());
        testLoc.setShip(true);
        assertEquals(true, testLoc.hasShip());
        testLoc.setShip(false);
        assertEquals(false, testLoc.hasShip());
    }

    @Test
    void testGetSetStatus()
    {
        Location location = new Location();
        
        // -1 - Invalid boundary limit
        //  0 - Valid boundary limit
        //  1 - Valid boundary limit
        //  2 - Valid boundary limit
        //  3 - Invalid boundary limit
        int [] partitions = {-1, Location.UNGUESSED, Location.HIT, Location.MISSED, 3};
        
        // Loop through partitions and verify the get() matches the set()
        for (int i = 0; i < partitions.length; i++)
        {
            location.setStatus(partitions[i]);
            assertEquals(partitions[i], location.getStatus());
        }
    }

    @Test
    void testGetSetLengthOfShip()
    {
        Location location = new Location();

        // -1 - Invalid boundary limit, Interesting value
        //  0 - Invalid boundary limit, Interesting value
        //  1 - Invalid boundary limit
        //  2 - Valid boundary limit
        //  3 - Middle value 1
        //  4 - Middle value 2 (might as well test)
        //  5 - Valid boundary limit
        //  6 - Invalid boundary limit
        int [] partitions = {-1, 0, 1, 2, 3, 4, 5, 6};

        // Loop through partitions and verify the get() matches the set()
        for (int i = 0; i < partitions.length; i++)
        {
            location.setLengthOfShip(partitions[i]);
            assertEquals(partitions[i], location.getLengthOfShip());
        }
    }

    @Test
    void testGetSetDirectionOfShip()
    {
        Location location = new Location();

        // -1 - Invalid boundary limit
        //  0 - Valid boundary limit
        //  1 - Valid boundary limit
        //  2 - Invalid boundary limit
        int [] partitions = {-1, 0, 1, 2};
        
        // Loop through partitions and verify the get() matches the set()
        for (int i = 0; i < partitions.length; i++)
        {
            location.setDirectionOfShip(partitions[i]);
            assertEquals(partitions[i], location.getDirectionOfShip());
        }
    }
}

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LocationTest
{
    static final int UNSET = 0;
    
    @BeforeAll
    static void setUpBeforeClass() throws Exception
    {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception
    {
    }

    @BeforeEach
    void setUp() throws Exception
    {
    }

    @AfterEach
    void tearDown() throws Exception
    {
    }

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
<<<<<<< HEAD
        Location location = new Location();
        
        // Loop through partitions and verify the get() matches the set()
        int [] partitions = {-1, Location.UNGUESSED, Location.HIT, Location.MISSED, 2};
        boolean [] expected = {false, true, false, false, false};
        
        // Internal check for test case validity
        assertEquals(partitions.length, expected.length);
        
        for (int i = 0; i < partitions.length; i++)
        {
            location.setStatus(partitions[i]);
            assertEquals(expected[i], location.isUnguessed());
        }
=======
    	Location testLoc = new Location();
    	assertEquals(testLoc.isUnguessed(), true);
    	testLoc.markMiss();
    	assertEquals(testLoc.isUnguessed(), false);
    	testLoc.markHit();
    	assertEquals(testLoc.isUnguessed(), false);
>>>>>>> 497c26f8322ff54446681a1c1683e05eba94d624
    }

    @Test
    void testMarkHit()
    {
        Location testLoc = new Location();
        assertEquals(0,testLoc.getStatus());
        testLoc.markHit();
        assertEquals(1, testLoc.getStatus());
        testLoc.markMiss();
        testLoc.markHit();
        assertEquals(1,testLoc.getStatus());
    }

    @Test
    void testMarkMiss()
    {
        Location testLoc = new Location();
        assertEquals(0,testLoc.getStatus());
        testLoc.markMiss();
        assertEquals(2, testLoc.getStatus());
        testLoc.markHit();
        testLoc.markMiss();
        assertEquals(2, testLoc.getStatus());
    }

    @Test
    void testHasShip()
    {
        Location testLoc = new Location();
        assertEquals(false, testLoc.hasShip());
        testLoc.setShip(true);
        assertEquals(true, testLoc.hasShip());
        testLoc.setShip(false);
        assertEquals(false, testLoc.hasShip());
    }

    @Test
    void testSetShip()
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
        
        // Loop through partitions and verify the get() matches the set()
        int [] partitions = {-1, Location.UNGUESSED, Location.HIT, Location.MISSED, 2};
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
        int result = 0;
        
        // Verify initial value is <= 0 (unset)
        result = location.getLengthOfShip();
        assertTrue((result <= UNSET) ? true : false);

        // Loop through partitions and verify the get() matches the set()
        int [] partitions = {-1, 0, 1, 2, 3, 4, 5, 6};
        for (int i = 0; i < partitions.length; i++)
        {
            location.setLengthOfShip(partitions[i]);
            assertEquals(partitions[i], location.getLengthOfShip());
        }
    }

    @Test
    void testGetDirectionOfShip()
    {
        fail("Not yet implemented");
    }

    @Test
    void testSetDirectionOfShip()
    {
        fail("Not yet implemented");
    }
}

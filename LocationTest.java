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
        fail("Not yet implemented");
    }

    @Test
    void testCheckHit()
    {
        fail("Not yet implemented");
    }

    @Test
    void testCheckMiss()
    {
        fail("Not yet implemented");
    }

    @Test
    void testIsUnguessed()
    {
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
    }

    @Test
    void testMarkHit()
    {
        fail("Not yet implemented");
    }

    @Test
    void testMarkMiss()
    {
        fail("Not yet implemented");
    }

    @Test
    void testHasShip()
    {
        fail("Not yet implemented");
    }

    @Test
    void testSetShip()
    {
        fail("Not yet implemented");
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

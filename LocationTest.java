import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LocationTest
{

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
    	Location testLoc = new Location();
    	assertEquals(testLoc.isUnguessed(), true);
    	testLoc.markMiss();
    	assertEquals(testLoc.isUnguessed(), false);
    	testLoc.markHit();
    	assertEquals(testLoc.isUnguessed(), false);
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
    void testSetStatus()
    {
        fail("Not yet implemented");
    }

    @Test
    void testGetStatus()
    {
        fail("Not yet implemented");
    }

    @Test
    void testGetLengthOfShip()
    {
        fail("Not yet implemented");
    }

    @Test
    void testSetLengthOfShip()
    {
        fail("Not yet implemented");
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

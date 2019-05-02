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
        fail("Not yet implemented");
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
        Location testLoc = new Location();
        assertEquals(false, testLoc.hasShip());
        testLoc.setShip(true);
        assertEquals(true, testLoc.hasShip());
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

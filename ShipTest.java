import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShipTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testShip() {
		Ship testShip = new Ship(2);
		assertEquals(testShip.getDirection(), -1);
		assertEquals(testShip.getLength(), 2);
		assertEquals(testShip.getRow(), -1);
		assertEquals(testShip.getCol(), -1);
	}

	@Test
	void testIsLocationSet() {
		Ship testShip = new Ship(2);
		assertEquals(testShip.isLocationSet(), false);
		testShip.setLocation(0, 0);
		assertEquals(testShip.isLocationSet(), true);
	}

	@Test
	void testIsDirectionSet() {
		Ship testShip = new Ship(2);
		assertEquals(testShip.isDirectionSet(), false);
		testShip.setDirection(1);
		assertEquals(testShip.isDirectionSet(), true);
		assertThrows(IllegalArgumentException.class, () -> {
	        testShip.setDirection(2);
	    });
		assertThrows(IllegalArgumentException.class, () -> {
	        testShip.setDirection(-2);
	    });
	}

	@Test
	void testSetLocation() {
		Ship testShip = new Ship(2);
		testShip.setLocation(0, 0);
		assertEquals(testShip.getRow(), 0);
		assertEquals(testShip.getCol(), 0);
	}

	@Test
	void testSetDirection() {
		Ship testShip = new Ship(2);
		testShip.setDirection(0);
		assertEquals(testShip.getDirection(), 0);
	}

	// TODO: Implement test case
	//@Test
	//void testGetRow() {
	//	fail("Not yet implemented");
	//}

	// TODO: Implement test case
	//@Test
	//void testGetCol() {
	//	fail("Not yet implemented");
	//}

	// TODO: Implement test case
	//@Test
	//void testGetLength() {
	//	fail("Not yet implemented");
	//}

	// TODO: Implement test case
	//@Test
	//void testGetDirection() {
	//	fail("Not yet implemented");
	//}

	// TODO: Implement test case
	//@Test
	//void testToString() {
	//	fail("Not yet implemented");
	//}

}

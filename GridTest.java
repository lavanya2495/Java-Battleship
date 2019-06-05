import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GridTest {

	@Test
	void testGrid() {
		Grid tstGrid = new Grid();
		for (int i = 0; i < tstGrid.numRows(); i++) {
			for(int j = 0; j < tstGrid.numCols(); j++) {
				assertEquals(tstGrid.hasShip(i,j), false);
			}
		}
	}
	
	@Test 
	void testMarkHit(){
    	Grid testGrid = new Grid();
    	for(int i = 0; i < 10; i++) {
    		for(int j = 0; j < 10; j++) {
    			assertEquals(testGrid.getStatus(i, j), 0);
    			testGrid.markHit(i, j);
    			assertEquals(testGrid.getStatus(i, j), 1);
    		}
    	}
    }
	
	@Test
	void testMarkMiss() {
		Grid testGrid = new Grid();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				assertEquals(testGrid.getStatus(i, j), 0);
				testGrid.markMiss(i, j);
				assertEquals(testGrid.getStatus(i, j), 2);
			}
		}
	}
	
	@Test 
	void testSetStatus() {
		Grid testGrid = new Grid();
		assertEquals(testGrid.getStatus(0, 0), 0);
		testGrid.setStatus(0, 0, 2);
		assertEquals(testGrid.getStatus(0, 0), 2);
		testGrid.setStatus(0, 0, 1);
		assertEquals(testGrid.getStatus(0, 0), 1);
	}
	
	@Test
	void testGetStatus() {
		Grid testGrid = new Grid();
		assertEquals(testGrid.getStatus(0, 0), 0);
	}
	
	@Test
	void testAlreadyGuessed() {
		Grid testGrid = new Grid();
		assertEquals(testGrid.alreadyGuessed(0, 0), false);
		testGrid.setStatus(0,  0,  1);
		assertEquals(testGrid.alreadyGuessed(0, 0), true);
		testGrid.setStatus(0, 0, 2);
		assertEquals(testGrid.alreadyGuessed(0, 0), true);
	}
	
	@Test
	void testSetShip() {
		Grid testGrid = new Grid();
		assertEquals(testGrid.hasShip(0, 0), false);
		testGrid.setShip(0, 0, true);
		assertEquals(testGrid.hasShip(0, 0), true);
		testGrid.setShip(0, 0, false);
		assertEquals(testGrid.hasShip(0, 0), false);
	}
	
	@Test
	void testHasShip() {
		Grid testGrid = new Grid();
		assertEquals(testGrid.hasShip(0, 0), false);
	}
	
	@Test
	void testGet() {
		Grid testGrid = new Grid();
		Location testLoc = testGrid.get(0, 0);
		assertEquals(testLoc.getStatus(), 0);
		assertEquals(testLoc.hasShip(), false);
		assertEquals(testLoc.getLengthOfShip(), -1);
		assertEquals(testLoc.getDirectionOfShip(), -1);
	}

	@Test
	void testNumRows() {
		Grid testGrid = new Grid();
		assertEquals(testGrid.numRows(), 10);
	}
	
	@Test
	void testNumCol() {
		Grid testGrid = new Grid();
		assertEquals(testGrid.numCols(), 10);
	}
	
	@Test
	void testHasLost() {
		Grid testGrid = new Grid();
		assertEquals(testGrid.hasLost(), false);
		for (int i = 0; i < 10; i++) {
			for(int j = 0; j < 2; j++) {
				testGrid.markHit(i, j);
			}
		}
		assertEquals(testGrid.hasLost(), true);
	}
	
	@Test
	void testAddShip() {
		//-1 = unset, 0 = horizontal, 1 = vertical
		Grid testGrid = new Grid();
		Ship testShip = new Ship(4);
		assertEquals(testShip.isLocationSet(), false);
		testShip.setLocation(5, 5);
		assertEquals(testShip.isLocationSet(), true);
		assertEquals(testShip.isDirectionSet(), false);
		testShip.setDirection(0);
		assertEquals(testShip.isDirectionSet(), true);
		assertEquals(testShip.getDirection(), 0);
		
		assertEquals(testGrid.hasShip(5, 5), false);
		testGrid.addShip(testShip);
		assertEquals(testGrid.hasShip(5, 5), true);
		
		for (int i = 0; i < testShip.getLength(); i++) {
			assertEquals(testGrid.hasShip(5, 5+i), true);
		}
		testShip.setDirection(1);
		testGrid.addShip(testShip);
		for (int i = 0; i < testShip.getLength(); i++) {
			assertEquals(testGrid.hasShip(5+i, 5), true);
		}
	}
	
	@Test
	void testswitchCounterToIntegerForArray() {
		Grid testGrid = new Grid();
		int x = 65;
		for (int y = 0; y < 26; y++){
			assertEquals(testGrid.switchCounterToIntegerForArray(x), y);
			x++;
		}		
	}
}

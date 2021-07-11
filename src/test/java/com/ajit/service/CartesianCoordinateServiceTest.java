package com.ajit.service;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ajit.service.CartesianCoordinateService;
import com.ajit.util.Constants;



@SpringBootTest()
public class CartesianCoordinateServiceTest {
	
	@Autowired(required = true)
	CartesianCoordinateService CartesianCoordinateService;
	
	/*
	 * Tests start for GET line equation using 2 points
	 */
	@Test
	public void getLineEquationNotPossibleCondition() {
		assertEquals(CartesianCoordinateService.getDefinitionOfLineByTwoPoints(2, 4, 2, 4), Constants.LINE_NOT_POSSIBLE_BECAUSE_OF_SAME_POINTS);
		assertEquals(CartesianCoordinateService.getDefinitionOfLineByTwoPoints(6, 6, 6, 6), Constants.LINE_NOT_POSSIBLE_BECAUSE_OF_SAME_POINTS);
		assertEquals(CartesianCoordinateService.getDefinitionOfLineByTwoPoints(-20, -20, -20, -20), Constants.LINE_NOT_POSSIBLE_BECAUSE_OF_SAME_POINTS);
	}
	
	@Test
	public void getLineEquationWhereParallelToY() {
		assertEquals(CartesianCoordinateService.getDefinitionOfLineByTwoPoints(3, 4, 3, 5), "x=3.0");
		assertEquals(CartesianCoordinateService.getDefinitionOfLineByTwoPoints(6, 16, 6, 6), "x=6.0");
		assertEquals(CartesianCoordinateService.getDefinitionOfLineByTwoPoints(-16, 6, -16, -6), "x=-16.0");
	}
	
	
	@Test
	public void getLineEquationWhereParallelToX() {
		assertEquals(CartesianCoordinateService.getDefinitionOfLineByTwoPoints(13, 5, 3, 5), "y=5.0");
		assertEquals(CartesianCoordinateService.getDefinitionOfLineByTwoPoints(6, 16, -6, 16), "y=16.0");
		assertEquals(CartesianCoordinateService.getDefinitionOfLineByTwoPoints(-16, -26, 1, -26), "y=-26.0");
	}
	
	@Test
	public void getLineEquationXandY() {
		assertEquals(CartesianCoordinateService.getDefinitionOfLineByTwoPoints(13, 5, 23, 55), "-50.0x+10.0y+600.0=0");
		assertEquals(CartesianCoordinateService.getDefinitionOfLineByTwoPoints(-60, 16, -6, 6), "10.0x+54.0y-264.0=0");
		assertEquals(CartesianCoordinateService.getDefinitionOfLineByTwoPoints(-16, -6, -12, -26), "20.0x+4.0y+344.0=0");
	}
	
	
	
	/*
	 * Tests start for GET line equation using slope and interception
	 */
	@Test
	public void getLineEquationWithZeros() {
		assertEquals(CartesianCoordinateService.getDefinitionOfBygradientAndIntercept(0, 0), "y=0.0");
		assertEquals(CartesianCoordinateService.getDefinitionOfBygradientAndIntercept(20, 0), "y=20.0x");
		assertEquals(CartesianCoordinateService.getDefinitionOfBygradientAndIntercept(-20, 0), "y=-20.0x");
		assertEquals(CartesianCoordinateService.getDefinitionOfBygradientAndIntercept(0, 10), "y=10.0");
		assertEquals(CartesianCoordinateService.getDefinitionOfBygradientAndIntercept(0, -10), "y=-10.0");
	}
	
	
	@Test
	public void getLineEquationWithOutZeros() {
		//both positive
		assertEquals(CartesianCoordinateService.getDefinitionOfBygradientAndIntercept(10, 6), "y=10.0x+6.0");
		//m positive and c negative
		assertEquals(CartesianCoordinateService.getDefinitionOfBygradientAndIntercept(20, -10), "y=20.0x-10.0");
		//m negative and c positive
		assertEquals(CartesianCoordinateService.getDefinitionOfBygradientAndIntercept(-20, 10), "y=-20.0x+10.0");
		//both negative
		assertEquals(CartesianCoordinateService.getDefinitionOfBygradientAndIntercept(-5, -5), "y=-5.0x-5.0");
	}
	
	
	/*
	 * Tests start for parallel condition
	 */
	@Test
	public void isParallelForLinesParallelToY() {
		//lines parallel to x(x=2 and x=3)
		assertTrue(CartesianCoordinateService.isParallel(2, 4, 2, 6, 3, 7, 3, 8));
		assertTrue(CartesianCoordinateService.isParallel(-2, -4, -2, -6, -3, -7, -3, -8));
	}
	
	
	@Test
	public void isParallelForLinesParallelToX() {
		//lines parallel to y (y=4 and y=7)
		assertTrue(CartesianCoordinateService.isParallel(2, 4, 12, 4, 13, 7, 3, 7));
		assertTrue(CartesianCoordinateService.isParallel(-2, -4, -12, -4, -13, -7, -3, -7));
	}
	
	
	@Test
	public void isParallelForOtherLines() {
		//lines parallel
		assertTrue(CartesianCoordinateService.isParallel(2, 4, 12, 14, 3, 5, 13, 15));
		assertTrue(CartesianCoordinateService.isParallel(-2, -4, -12, -14, -3, -5, -13, -15));
		//lines not parallel
		assertFalse(CartesianCoordinateService.isParallel(2, 4, 112, 14, 3, 5, 13, 15));
		assertFalse(CartesianCoordinateService.isParallel(-2, -4, -112, -14, -3, -5, -13, -15));
	}

	
	
	/*
	 * Tests start for perpendicular condition
	 */
	@Test
	public void isPerpendicularForLinesParallelToY() {
		//lines parallel to x(x=2 and x=3)
		assertFalse(CartesianCoordinateService.isPerpendicular(2, 4, 2, 6, 3, 7, 3, 8));
		assertFalse(CartesianCoordinateService.isPerpendicular(-2, -4, -2, -6, -3, -7, -3, -8));
	}
	
	
	@Test
	public void isPerpendicularForLinesParallelToX() {
		//lines parallel to y (y=4 and y=7)
		assertFalse(CartesianCoordinateService.isPerpendicular(2, 4, 12, 4, 13, 7, 3, 7));
		assertFalse(CartesianCoordinateService.isPerpendicular(-2, -4, -12, -4, -13, -7, -3, -7));
	}
	
	
	
	@Test
	public void isPerpendicularForLinesParallelToXandY() {
		//one line parallel to x and one line parallel to y
		assertTrue(CartesianCoordinateService.isPerpendicular(2, 4, 12, 4, 13, 7, 13, 17));
		assertTrue(CartesianCoordinateService.isPerpendicular(-2, -4, -12, -4, -13, -7, -13, -17));
	}
	
	
	@Test
	public void isPerpendicularForOtherLines() {
		//lines perpendicular
		assertTrue(CartesianCoordinateService.isPerpendicular(0, 0, 12, 12, 0, 0, -12, 12));
		assertTrue(CartesianCoordinateService.isPerpendicular(0, 0, -1, -1, 0, 0, 1, -1));
		//lines not perpendicular
		assertFalse(CartesianCoordinateService.isParallel(2, 4, 112, 14, 3, 5, 13, 15));
		assertFalse(CartesianCoordinateService.isParallel(-2, -4, -112, -14, -3, -5, -13, -15));
	}
	
	
	
	/*
	 * Tests start for line intersection point 
	 */
	@Test
	public void getIntersectionPointForParallelLines() {
		//lines parallel to y
		assertEquals(CartesianCoordinateService.getIntersectionPoint(2, 4, 2, 6, 3, 7, 3, 8), Constants.LINES_WILL_NEVER_INTERSECT);
		assertEquals(CartesianCoordinateService.getIntersectionPoint(-2, -4, -2, -6, -3, -7, -3, -8), Constants.LINES_WILL_NEVER_INTERSECT);
		//lines parallel to x
		assertEquals(CartesianCoordinateService.getIntersectionPoint(2, 4, 12, 4, 13, 7, 3, 7), Constants.LINES_WILL_NEVER_INTERSECT);
		assertEquals(CartesianCoordinateService.getIntersectionPoint(-2, -4, -12, -4, -13, -7, -3, -7), Constants.LINES_WILL_NEVER_INTERSECT);
		//other parallel lines
		assertEquals(CartesianCoordinateService.getIntersectionPoint(2, 4, 12, 14, 3, 5, 13, 15), Constants.LINES_WILL_NEVER_INTERSECT);
		assertEquals(CartesianCoordinateService.getIntersectionPoint(-2, -4, -12, -14, -3, -5, -13, -15), Constants.LINES_WILL_NEVER_INTERSECT);
	}
	
	
	
	@Test
	public void getIntersectionPointForNonParallelLines() {
		assertEquals(CartesianCoordinateService.getIntersectionPoint(2, 4, 12, 6, 3, 7, 3, 8), "3.0,4.2");
		assertEquals(CartesianCoordinateService.getIntersectionPoint(-2, -4, -12, -6, -3, -7, -3, -8), "-3.0,-4.2");
		assertEquals(CartesianCoordinateService.getIntersectionPoint(2, 4, 12, 15, 13, 17, 3, 7), "22.0,26.0");
		assertEquals(CartesianCoordinateService.getIntersectionPoint(-2, -4, -12, -15, -13, -17, -3, -7), "-22.0,-26.0");
	}


}

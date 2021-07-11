package com.ajit.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ajit.service.CartesianCoordinateService;

/**
 * @author Ajit Pandey
 */

@RestController
public class CartesianCoordinateController {
	
	@Autowired
	CartesianCoordinateService service;
	
	/**
	 * Definition of a line by means of two points
	 * 
	 * @param x1 is the x1
	 * @param x2 is the x2
	 * @param y1 is the y1
	 * @param y2 is the y2
	 * @return {@linkgetDefinitionOfLineByTwoPoints }
	 * @author Ajit Pandey
	 * 
	 */
	 
	@GetMapping("/v1/definition-of-line-by-two-points/{x1}/{y1}/{x2}/{y2}")
	public String getDefinitionOfLineByTwoPoints(@PathVariable double x1, @PathVariable double y1, @PathVariable double x2, @PathVariable double y2) {
		return service.getDefinitionOfLineByTwoPoints(x1, y1, x2, y2);
	}
	
	/**
	 * Definition of a line by means of gradient and y-intercept
	 * 
	 * @param m is the m
	 * @param c is the c
	 * @return {@linkgetDefinitionOfLineByTwoPoints }
	 * @author Ajit Pandey
	 * 
	 */
	@GetMapping("/v1/definition-of-line-by-gradient-intercept/{m}/{c}")
	public String getDefinitionOfBygradientAndIntercept(@PathVariable double m, @PathVariable double c) {
		return service.getDefinitionOfBygradientAndIntercept(m, c);
	}
	
	
	/**
	 * Condition of parallelism of two lines
	 * 
	 * @param x1 is the x1
	 * @param x2 is the x2
	 * @param y1 is the y1
	 * @param y2 is the y2
	 * @param y3 is the y3
	 * @param y4 is the y4
	 * @param x3 is the x3
	 * @param x4 is the x4
	 * @return {@isParallel }
	 * @author Ajit Pandey
	 * 
	 */
	@GetMapping("/v1/lines-are-parallel/{x1}/{y1}/{x2}/{y2}/{x3}/{y3}/{x4}/{y4}")
	public boolean isParallel(@PathVariable double x1, @PathVariable double y1, @PathVariable double x2, @PathVariable double y2, @PathVariable double x3, @PathVariable double y3, @PathVariable double x4, @PathVariable double y4) {
		return service.isParallel(x1, y1, x2, y2, x3, y3, x4, y4);
	}
	
	

	/**
	 * Condition of perpendicularity of two lines
	 * 
	 * @param x1 is the x1
	 * @param x2 is the x2
	 * @param y1 is the y1
	 * @param y2 is the y2
	 * @param y3 is the y3
	 * @param y4 is the y4
	 * @param x3 is the x3
	 * @param x4 is the x4
	 * @return {@isPerpendicular }
	 * @author Ajit Pandey
	 * 
	 */
	@GetMapping("/v1/lines-are-perpendicular/{x1}/{y1}/{x2}/{y2}/{x3}/{y3}/{x4}/{y4}")
	public boolean isPerpendicular(@PathVariable double x1, @PathVariable double y1, @PathVariable double x2, @PathVariable double y2, @PathVariable double x3, @PathVariable double y3, @PathVariable double x4, @PathVariable double y4) {
		return service.isPerpendicular(x1, y1, x2, y2, x3, y3, x4, y4);
	}
	
	/**
	 * Condition of incidence of two lines and definition of the incidence point
	 * 
	 * @param x1 is the x1
	 * @param x2 is the x2
	 * @param y1 is the y1
	 * @param y2 is the y2
	 * @param y3 is the y3
	 * @param y4 is the y4
	 * @param x3 is the x3
	 * @param x4 is the x4
	 * @return {@getIntersectionPoint }
	 * @author Ajit Pandey
	 * 
	 */
	@GetMapping("v1/intersection-point-of-two-lines/{x1}/{y1}/{x2}/{y2}/{x3}/{y3}/{x4}/{y4}")
	public String getIntersectionPoint(@PathVariable double x1, @PathVariable double y1, @PathVariable double x2, @PathVariable double y2, @PathVariable double x3, @PathVariable double y3, @PathVariable double x4, @PathVariable double y4) {
		return service.getIntersectionPoint(x1, y1, x2, y2, x3, y3, x4, y4);
	}
	
	

}

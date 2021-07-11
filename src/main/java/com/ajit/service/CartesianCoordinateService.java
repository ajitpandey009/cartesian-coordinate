package com.ajit.service;

import org.springframework.stereotype.Service;

@Service
public interface CartesianCoordinateService {
	
	

	
	public String getDefinitionOfLineByTwoPoints(double x1, double y1, double x2, double y2);

	public String getDefinitionOfBygradientAndIntercept(double m, double c);

	public boolean isParallel(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4);

	public boolean isPerpendicular(double x1, double y1, double x2, double y2, double x3, double y3, double x4,
			double y4);

	public String getIntersectionPoint(double x1, double y1, double x2, double y2, double x3, double y3, double x4,
			double y4);
}

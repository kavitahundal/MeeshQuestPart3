package JUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cmsc420.city.City;
import cmsc420.city.Road;
import cmsc420.pmquadtree.InvalidPartitionThrowable;
import cmsc420.pmquadtree.OutOfBoundsThrowable;
import cmsc420.pmquadtree.PM1Quadtree;
import cmsc420.pmquadtree.PMQuadtree;
import cmsc420.pmquadtree.RoadAlreadyExistsThrowable;
import cmsc420.pmquadtree.RoadIntersectsAnotherRoadThrowable;
import junit.framework.TestCase;

public class Test0 extends TestCase{
	PMQuadtree quadtree;
	final int spatialWidth = 16;
	final int spatialHeight = 16;
	City a, b, c, d;
	Road ab, ac, ad, bc, bd, cd;
	
    @Before
    public void setUp() {
    	quadtree = new PM1Quadtree(spatialWidth, spatialHeight);
		a = new City("A", 0,15,10,"Black");
		b = new City("B", 15,15,10,"Black");
		c = new City("C", 0,0,10,"Black");
		d = new City("D", 15,0,10,"Black");
		
		bc = new Road(b,c);
		ad = new Road(a,d);
    }
 
    @Test
    public void testPM1() {
    	try {
			quadtree.addRoad(bc);
			quadtree.addRoad(ad);
		} catch (RoadAlreadyExistsThrowable | OutOfBoundsThrowable | InvalidPartitionThrowable | RoadIntersectsAnotherRoadThrowable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

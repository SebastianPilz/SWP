package test;

import static org.junit.Assert.*;

import matrizen.*;


public class Test {
	
	@org.junit.Test
	public void correct() {
		Matrix m1 = new Matrix(2,3);
		
		m1.set(0, 0, 1);
		m1.set(0, 1, 2);
		m1.set(0, 2, 3);
		m1.set(1, 0, 4);
		m1.set(1, 1, 5);
		m1.set(1, 2, 6);
		
		Matrix m2 = new Matrix(3,2);
		
		m2.set(0, 0, 1);
		m2.set(0, 1, 2);
		m2.set(1, 0, 3);
		m2.set(1, 1, 4);
		m2.set(2, 0, 5);
		m2.set(2, 1, 6);
		
		Matrix m3 = new Matrix(2,2);
		
		m3.set(0, 0, 22);
		m3.set(0, 1, 28);
		m3.set(1, 0, 49);
		m3.set(1, 1, 64);
		
		assertEquals(true, m3.equals(matrizen.mult(m1, m2)));
	}
	
	@org.junit.Test
	public void add() {
		Matrix m1 = new Matrix(2,2);
		
		m1.set(0, 0, 1);
		m1.set(0, 1, 2);
		m1.set(1, 0, 3);
		m1.set(1, 1, 4);
		
		Matrix m2 = new Matrix(2,2);
		
		m2.set(0, 0, 1);
		m2.set(0, 1, 2);
		m2.set(1, 0, 3);
		m2.set(1, 1, 4);
		
		Matrix m3 = new Matrix(2,2);
		
		m3.set(0, 0, 2);
		m3.set(0, 1, 4);
		m3.set(1, 0, 6);
		m3.set(1, 1, 8);
		
		assertEquals(true, m3.equals(matrizen.add(m1, m2)));
	}
	
	
	
}

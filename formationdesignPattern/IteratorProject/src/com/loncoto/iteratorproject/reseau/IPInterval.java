package com.loncoto.iteratorproject.reseau;

import java.util.Iterator;

public class IPInterval implements Iterable<Integer[]>
{

	private int[] ipStart;
	private int[] ipEnd;
	
	public IPInterval() {this(0, 0, 0,0, 255, 255, 255, 255);}
	public IPInterval(int a1, int b1, int c1, int d1, int a2, int b2, int c2, int d2) {
		setIpStart(a1, b1, c1, d1);
		setIpEnd(a2, b2, c2, d2);
	}
	
	
	public void setIpStart(int a, int b, int c, int d) {
		if (a < 0 || a > 255 || b < 0 || b > 255 || c <0 || c > 255 || d < 0 || d > 255)
			throw new IllegalArgumentException("ip invalide");
		ipStart = new int[] {a, b, c, d};
	}
	public int[] getIpStart() {
		return ipStart.clone();
	}
	
	public void setIpEnd(int a, int b, int c, int d) {
		if (a < 0 || a > 255 || b < 0 || b > 255 || c <0 || c > 255 || d < 0 || d > 255)
			throw new IllegalArgumentException("ip invalide");
		ipEnd = new int[] {a, b, c, d};
	}
	public int[] getIpEnd() {
		return ipEnd.clone();
	}
	
	public boolean isInInterval(int a, int b, int c, int d) {
		long current = ((long)a << 24) + (b << 16) + (c << 8) + d;
		long start =  ((long)ipStart[0] << 24) + (ipStart[1] << 16) + (ipStart[2] << 8) + ipStart[3];
		long end =  ((long)ipEnd[0] << 24) + (ipEnd[1] << 16) + (ipEnd[2] << 8) + ipEnd[3];
		
		if (current < start || current > end)
			return false;
		return true;
		
	}
	// fabrique d'iterateur sur ipInterval
	@Override
	public Iterator<Integer[]> iterator() {
		// je renvoie un iterateur sur moi-même
		return new IPIntervalIterator(this);
	}
	
}

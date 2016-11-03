package net.itsky.devoxx.wycocawr;

public class IntOverflow {
	public static void main(String[] args) {
		int x = 2_000_000_000;
		int y = x + x;
		int z = x * x;
		System.out.println("x=" + x + " y=" + y + " z=" + z);
	}

}

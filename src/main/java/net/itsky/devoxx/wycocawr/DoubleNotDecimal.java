package net.itsky.devoxx.wycocawr;

public class DoubleNotDecimal {
	public static void main(String[] args) {
		double t = 0.2;
		String s = String.format("%a", t);
		System.out.println("t=" + t + " s=" + s);
	}

}

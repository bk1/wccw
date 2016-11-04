package net.itsky.devoxx.wycocawr;

public class DoubleInaccuracy {

	public static void main(String[] args) {
		double u = 1.0;
		double v = u / 1e20;
		double w = v + 1;
		double x = w - 1;
		double y = x * 1e20;
		System.out.println("u=" + u + " v=" + v + " w=" + w + " x=" + x + " y=" + y + "\n");
	}

}

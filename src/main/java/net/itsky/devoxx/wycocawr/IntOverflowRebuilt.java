package net.itsky.devoxx.wycocawr;

import static net.itsky.devoxx.wycocawr.NormalizationUtils.iadd;
import static net.itsky.devoxx.wycocawr.NormalizationUtils.imultiply;

public class IntOverflowRebuilt {

	public static void main(String[] args) {
		long x = 2_000_000_000;
		long y = iadd(x, x);
		long z = imultiply(x, x);
		System.out.println("x=" + x + " y=" + y + " z=" + z);
	}
}

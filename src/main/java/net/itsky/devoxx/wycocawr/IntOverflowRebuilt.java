package net.itsky.devoxx.wycocawr;

import static net.itsky.devoxx.wycocawr.NormalizedLong.iadd;
import static net.itsky.devoxx.wycocawr.NormalizedLong.imultiply;

import net.itsky.devoxx.wycocawr.NormalizationUtils.iadd;
import net.itsky.devoxx.wycocawr.NormalizationUtils.imultiply;

public class IntOverflowRebuilt {

	public static void main(String[] args) {
		long x = 2_000_000_000;
		long y = NormalizationUtils.iadd(x, x);
		long z = NormalizationUtils.imultiply(x, x);
		System.out.println("x=" + x + " y=" + y + " z=" + z);
	}
}

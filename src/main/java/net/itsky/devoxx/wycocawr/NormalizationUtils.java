package net.itsky.devoxx.wycocawr;

public class NormalizationUtils {

	/** reduce modulo 2^32 */
	public static long normalize(long x) {
		long r = x%NormalizedLong.MODULUS;
		if (r<NormalizedLong.NLIMIT) {
			r+=NormalizedLong.MODULUS;
		} else if (r>=NormalizedLong.PLIMIT) {
			r-=NormalizedLong.MODULUS;
		}
		return r;
	}

	public static long iadd(long x, long y) {
		return normalize(x+y);
	}

	public static long isubtract(long x, long y) {
		return normalize(x-y);
	}

	public static long imultiply(long x, long y) {
		return normalize(x*y);
	}

}

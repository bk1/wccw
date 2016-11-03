package net.itsky.devoxx.wycocawr;

import java.math.BigInteger;

public class NormalizedBigInt extends Number implements Comparable<NormalizedBigInt> {

	public static final BigInteger MODULUS = BigInteger.valueOf(0x100000000L);
	private static final BigInteger PLIMIT = BigInteger.valueOf(0x80000000L);
	private static final BigInteger NLIMIT = BigInteger.valueOf(-0x80000000L);
	
	private BigInteger value;

	public static BigInteger normalize(BigInteger x) {
		BigInteger r = x.remainder(MODULUS);
		if (r.compareTo(NLIMIT) < 0) {
			return r.add(MODULUS);
		} else if (r.compareTo(PLIMIT) >= 0) {
			return r.subtract(MODULUS);
		} else {
			return r;
		}
	}

	public static void main(String[] args) {
		NormalizedBigInt n = new NormalizedBigInt();
		for (long i = -100; i <= 100; i++) {

			BigInteger bi = n.normalize(BigInteger.valueOf((1 << i) + i));
			System.out.println("i=" + i + " bi=" + bi);
		}
	}
	
	public NormalizedBigInt() {
		value = BigInteger.ZERO;
	}
	
	public NormalizedBigInt(long l) {
		value = normalize(BigInteger.valueOf(l));
	}
	
	public NormalizedBigInt(BigInteger b) {
		value = normalize(b);
	}
	
	public NormalizedBigInt add(NormalizedBigInt other) {
		return new NormalizedBigInt(this.value.add(other.value));
	}
	
	public NormalizedBigInt subtract(NormalizedBigInt other) {
		return new NormalizedBigInt(this.value.subtract(other.value));
	}
	
	public NormalizedBigInt multiply(NormalizedBigInt other) {
		return new NormalizedBigInt(this.value.multiply(other.value));
	}

	@Override
	public int intValue() {
		return value.intValue();
	}

	@Override
	public long longValue() {
		return value.longValue();
	}

	@Override
	public float floatValue() {
		return value.floatValue();
	}

	@Override
	public double doubleValue() {
		return value.doubleValue();
	}
	
	public BigInteger bigIntValue() {
		return value;
	}
	
	@Override
	public int hashCode() {
		return intValue();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof NormalizedBigInt) {
			NormalizedBigInt other = (NormalizedBigInt)obj;
			return this.value.equals(other.value);
		} else {
			return false;
		}
	}
	
	@Override
	public int compareTo(NormalizedBigInt other) {
			return this.value.compareTo(other.value);
	}
	
	@Override
	public String toString() {
		return value.toString();
	}
	
	public String toString(int radix) {
		return value.toString(radix);
	}
}

package net.itsky.devoxx.wycocawr;

import java.math.BigInteger;

public class NormalizedLong extends Number implements Comparable<NormalizedLong> {

	static final long MODULUS = 0x100000000L;
	static final long PLIMIT = 0x80000000L;
	static final long NLIMIT = -0x80000000L;
	
	private long value;

	public NormalizedLong() {
		value = 0L;
	}
	
	public NormalizedLong(long l) {
		value = NormalizationUtils.normalize(l);
	}
	
	public NormalizedLong(BigInteger b) {
		this(b.remainder(BigInteger.valueOf(MODULUS)).longValue());
	}
	
	public NormalizedLong add(NormalizedLong other) {
		return new NormalizedLong(this.value+other.value);
	}
	
	public NormalizedLong subtract(NormalizedLong other) {
		return new NormalizedLong(this.value-other.value);
	}
	
	public NormalizedLong multiply(NormalizedLong other) {
		return new NormalizedLong(this.value*other.value);
	}

	@Override
	public int intValue() {
		return (int) value;
	}

	@Override
	public long longValue() {
		return value;
	}

	@Override
	public float floatValue() {
		return (float)value;
	}

	@Override
	public double doubleValue() {
		return (double) value;
	}
	
	public BigInteger bigIntValue() {
		return BigInteger.valueOf(value);
	}
	@Override
	public int hashCode() {
		return intValue();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof NormalizedLong) {
			NormalizedLong other = (NormalizedLong)obj;
			return this.value == other.value;
		} else {
			return false;
		}
	}
	
	@Override
	public int compareTo(NormalizedLong other) {
			return Long.compare(this.value, other.value);
	}
	
	@Override
	public String toString() {
		return "" + value;
	}
	
	public String toString(int radix) {
		return Long.toString(value, radix);
	}
}

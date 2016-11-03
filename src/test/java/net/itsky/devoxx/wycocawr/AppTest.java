package net.itsky.devoxx.wycocawr;


import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	private static final BigInteger F = new BigInteger("314159265358979323846264338327950288419716939937510582097494459230781640628620899862803482534211706798214808651328230664709384460955058223172535940812848111745028410270193852110555964462294895493038196");

	private BigInteger createBigInteger(long x, long y) {
		return F.multiply(BigInteger.valueOf(x)).add(BigInteger.valueOf(y));
	}
    /**
     * Rigourous Test :-)
     */
	@Test
    public void testApp()     {
		for (int i = -20; i <= 20; i++) {
			for (int j = -20; j <= 20; j++) {
				BigInteger x = createBigInteger(i,  j);
				NormalizedBigInt bx = new NormalizedBigInt(x);
				NormalizedLong lx = new NormalizedLong(x);
				for (int k = -20; k <= 20; k++) {
					for (int l = -20; l <= 20; l++) {
						BigInteger y = createBigInteger(k,  l);
						NormalizedBigInt by = new NormalizedBigInt(y);
						NormalizedLong ly = new NormalizedLong(y);
						
						BigInteger s = x.add(y);
						BigInteger bs = bx.add(by).bigIntValue();
						BigInteger ls = lx.add(ly).bigIntValue();
						Assert.assertEquals(bs, ls);
						Assert.assertEquals(0, s.subtract(bs).remainder(NormalizedBigInt.MODULUS).signum());

						BigInteger d = x.subtract(y);
						BigInteger bd = bx.subtract(by).bigIntValue();
						BigInteger ld = lx.subtract(ly).bigIntValue();
						Assert.assertEquals(bd, ld);
						Assert.assertEquals(0, d.subtract(bd).remainder(NormalizedBigInt.MODULUS).signum());

						BigInteger p = x.multiply(y);
						BigInteger bp = bx.multiply(by).bigIntValue();
						BigInteger lp = lx.multiply(ly).bigIntValue();
						Assert.assertEquals(bp, lp);
						Assert.assertEquals(0, p.subtract(bp).remainder(NormalizedBigInt.MODULUS).signum());

					}
				}
			}
		}			
    }
}

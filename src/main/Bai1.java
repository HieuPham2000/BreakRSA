package main;

import java.math.BigInteger;
import java.math.RoundingMode;
import com.google.common.math.BigIntegerMath;

public class Bai1 {
	public static final BigInteger ZERO = BigInteger.ZERO;
	
	public static void printResult(BigInteger p, BigInteger q, BigInteger N) {
		// Kết quả
		System.out.println("Result:");
		System.out.println("p: " + p);
		System.out.println("q: " + q);

		// Kiểm tra
		System.out.println("Test:");
		System.out.println("p la so nguyen to: " + p.isProbablePrime(1));
		System.out.println("q la so nguyen to: " + q.isProbablePrime(1));
		System.out.println("N == p*q: " + p.multiply(q).subtract(N).equals(ZERO));

	}
	
	public static void main(String[] args) {
		
		BigInteger N = new BigInteger("179769313486231590772930519078902473361797697894230657273430081157732675805505620686985379449212982959585501387537164015710139858647833778606925583497541085196591615128057575940752635007475935288710823649949940771895617054361149474865046711015101563940680527540071584560878577663743040086340742855278549092581");
		
		BigInteger A = BigIntegerMath.sqrt(N, RoundingMode.CEILING);
		BigInteger x = A.multiply(A).subtract(N).sqrt();
		
		BigInteger p = A.subtract(x);
		BigInteger q = A.add(x);
		
		
		printResult(p, q, N);
	}
}

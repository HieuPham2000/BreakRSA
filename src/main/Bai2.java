package main;

import java.math.BigInteger;
import java.math.RoundingMode;

import com.google.common.math.BigIntegerMath;

public class Bai2 {
	
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

	public static void find(BigInteger N) {
		BigInteger start = BigIntegerMath.sqrt(N, RoundingMode.CEILING);
		BigInteger A, x, p, q;

		// 2^20 = 1048576
		int num = 1050000;
		while (num != 0) {
			A = start;
			x = A.multiply(A).subtract(N).sqrt();
			p = A.subtract(x);
			q = A.add(x);

			if (p.multiply(q).subtract(N).equals(BigInteger.ZERO)) {
				printResult(p, q, N);
				break;
			}
			start = start.add(BigInteger.ONE);
			num--;
		}

		System.out.println("Done!");

	}

	public static void main(String[] args) {
		BigInteger N = new BigInteger("6484558428080716696628242653467722787263437207069762630604390703787"
				+ "9730861808111646271401527606141756919558732184025452065542490671989"
				+ "2428844841839353281972988531310511738648965962582821502504990264452"
				+ "1008852816733037111422964210278402893076574586452336833570778346897"
				+ "15838646088239640236866252211790085787877");

		find(N);

	}
}

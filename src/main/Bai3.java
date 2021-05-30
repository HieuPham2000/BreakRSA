package main;

import java.math.BigInteger;
import java.math.RoundingMode;

import com.google.common.math.BigIntegerMath;


public class Bai3 {
	public static final BigInteger ZERO = BigInteger.ZERO;
	public static final BigInteger ONE = BigInteger.ONE;
	public static final BigInteger TWO = BigInteger.TWO;
	public static final BigInteger THREE = BigInteger.valueOf(3);
	public static final BigInteger FOUR = BigInteger.valueOf(4);
	public static final BigInteger SIX = BigInteger.valueOf(6);
	
	
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
		
		N = N.multiply(SIX);
		
		BigInteger A = BigIntegerMath.sqrt(N, RoundingMode.CEILING).multiply(TWO).subtract(ONE);
		
		BigInteger p, q, tmp1, tmp2;
		BigInteger x = BigIntegerMath.sqrt(A.multiply(A).subtract(N.multiply(FOUR)), RoundingMode.CEILING);
		tmp1 = A.subtract(x).divide(TWO);
		tmp2 = A.add(x).divide(TWO);
		
		if(tmp1.mod(TWO).equals(ZERO)) {
			p = tmp2.divide(THREE);
			q = tmp1.divide(TWO);
		} else {
			p = tmp1.divide(THREE);
			q = tmp2.divide(TWO);
		}
		
		N = N.divide(SIX);
		
		printResult(p, q, N);
		
	}
	
	public static void main(String[] args) {
		BigInteger N = new BigInteger("72006226374735042527956443552558373833808445147399984182665305798191"
				+ "63556901883377904234086641876639384851752649940178970835240791356868"
				+ "77441155132015188279331812309091996246361896836573643119174094961348"
				+ "52463970788523879939683923036467667022162701835329944324119217381272"
				+ "9276147530748597302192751375739387929");;
		
		find(N);
		
	}
}

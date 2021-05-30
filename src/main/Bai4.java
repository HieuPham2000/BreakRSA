package main;

import java.math.BigInteger;
import java.math.RoundingMode;

import com.google.common.math.BigIntegerMath;

public class Bai4 {
	public static final BigInteger ZERO = BigInteger.ZERO;
	public static final BigInteger ONE = BigInteger.ONE;

	
	public static BigInteger findModulo(BigInteger N) {
		BigInteger A = BigIntegerMath.sqrt(N, RoundingMode.CEILING);
		BigInteger x = A.multiply(A).subtract(N).sqrt();
		
		BigInteger p = A.subtract(x);
		BigInteger q = A.add(x);
		
		return p.subtract(ONE).multiply(q.subtract(ONE));
	}
	
	public static void hexStringToASCII(String hex) {
	      if(hex.length()%2!=0){
		         System.err.println("Invlid hex string.");
		         return;
		      }
		      
		      StringBuilder builder = new StringBuilder();

		      for (int i = 0; i < hex.length(); i = i + 2) {
		    	 // Tách theo cụm 2 ký tự
		         String s = hex.substring(i, i + 2);
		         // Chuyển sang hệ 10
		         int n = Integer.valueOf(s, 16);
		         // Chuyển sang kiểu char và lưu lại
		         builder.append((char)n);
		      }

		      System.out.println("Plaintext (hexa) = " + hex);
		      System.out.println("ASCII = " + builder.toString());
	}
	
	public static void findPlainText(BigInteger m) {
		String s = m.toString(16);
	    System.out.println("Plaintext with padding (hexa) = " + s);
	      
	    // Tách xâu dựa trên ký tự phân tách 0x00
	    int i;
	    for(i = 1; i < s.length(); ++i) {
	    	if(s.charAt(i - 1)=='0' && s.charAt(i)=='0') {
	    		i = i + 1;
	    		break;
	    	}
	    }
	    
	    String hex = s.substring(i);
	    hexStringToASCII(hex);
	}
	

	public static void main(String[] args) {
		
		BigInteger N = new BigInteger("179769313486231590772930519078902473361797697894230657273430081157732675805"
				+ "50562068698537944921298295958550138753716401571013985864783377860692558349754108519659161512805"
				+ "75759407526350074759352887108236499499407718956170543611494748650467110151015639406805275400715"
				+ "84560878577663743040086340742855278549092581");
		
		BigInteger c = new BigInteger("22096451867410381776306561134883418017410069787892831071731839143676135600120"
				+ "53800428232965047350942434394621975151225646583996794288946076454204058156474"
				+ "89880137348641204523252293201764879166664029975091887299716905260832220677716"
				+ "00019329260870009579993724077458967773697817571267229951148662959627934791540");
		
		BigInteger modulo = findModulo(N);
		BigInteger e = BigInteger.valueOf(65537);
		BigInteger d = e.modInverse(modulo);

		BigInteger m = c.modPow(d, N);
		
		findPlainText(m);
	      
		
	}
}

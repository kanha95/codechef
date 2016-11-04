import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
public class acm {

  static int find(int[] ar,int v){
      for(int i=1;i<=ar.length;i++){
          if(ar[i]==v) return i;
      }
      return -1;
  }
            
    public static void main(String[] args)
    {
        
      FasterScanner sc=new FasterScanner(System.in);
   int t=sc.nextInt();
      while(t>0){
         String s=sc.nextString();
         int x=0;
         char[] ar=new char[s.length()];
         for(int i=0;i<s.length();i++){
             
             if(Pattern.matches("[a-z]", ""+s.charAt(i))){
                 System.out.print(s.charAt(i));
             }
             else if(s.charAt(i)!='(' && s.charAt(i)!=')'){
                 ar[x]=s.charAt(i);
                 x++;
             }else if(s.charAt(i)==')'){
                 System.out.print(ar[x-1]);
                 x--;
             }
             
         }
          System.out.println("");
          t--;
   }
}
 
}  

class FasterScanner {
	private InputStream mIs;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;
 
	public FasterScanner() {
		this(System.in);
	}
 
	public FasterScanner(InputStream is) {
		mIs = is;
	}
 
	public int read() {
		if (numChars == -1)
			throw new InputMismatchException();
		if (curChar >= numChars) {
			curChar = 0;
			try {
				numChars = mIs.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (numChars <= 0)
				return -1;
		}
		return buf[curChar++];
	}
 
	public String nextLine() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while (!isEndOfLine(c));
		return res.toString();
	}
 
	public String nextString() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while (!isSpaceChar(c));
		return res.toString();
	}
 
	public long nextLong() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		long res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}
 
	public int nextInt() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		int res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}
 
	public boolean isSpaceChar(int c) {
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}
 
	public boolean isEndOfLine(int c) {
		return c == '\n' || c == '\r' || c == -1;
	}
 
} 

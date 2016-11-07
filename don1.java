import java.io.*;
import java.util.*;

public class acm {
   static char[] c={'I','E','M'};
   static int ans=0;
   
    public static void main(String[] args)
    {
        
      FasterScanner sc=new FasterScanner(System.in);
     
    String s=sc.nextString();
    
    int i=0,e=0,m=0;
    int i1=0,e1=0,m1=0;
    
    for(int k=s.length()-1;k>=0;k--){
        switch(s.charAt(k)){
            case 'M':
                m=1+m;
                break;
            case 'E':
                e1=Math.max(e>0?e:0, m>0?m:0);
                e=e1>0?e1+1:0;
                break;
            case 'I':
                i1=Math.max(i>0?i:0, e>0?e:0);
                i=i1>0?i1+1:0;
                break;
                
            
        }
        
        
        
    }System.out.println(i);
    
  
     
       
    
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

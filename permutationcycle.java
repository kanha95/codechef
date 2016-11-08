import java.io.*;
import java.util.*;

public class acm {
    static boolean[] visited;
   static ArrayList<Integer> al=new ArrayList<>();
  static int check(int m,int[] ar){
       while(!visited[m]){
          visited[m]=true;
          al.add(m);
          m=ar[m];
      }
      al.add(-1);
      return 1;
      
  }  
  
    
    public static void main(String[] args)
    {
        
      FasterScanner sc=new FasterScanner(System.in);
     

        int n=sc.nextInt();
      int[] ar=new int[n+1];
        for (int i = 1; i <=n; i++) {
            ar[i]=sc.nextInt();
        }
        int count=0;
       visited=new boolean[n+1];
     for(int i=1;i<=n;i++){
         if(!visited[i]){
             visited[i]=true;
             al.add(i);
             count+=check(ar[i],ar);
         
         }
     }
     int hh=0;
     boolean b=true;
        System.out.println(count);
      for(Integer i:al){
          if(b){
          hh=i;
          b=false;
          }
          if(i!=-1)
          System.out.print(i+" ");
          else{
              System.out.print(hh);
              System.out.println("");
              b=true;
          }
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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
 
 
class TrieNode {
    public TrieNode(char ch)  {
        value = ch;
        children = new HashMap<>();
        bIsEnd = false;
    }
    public HashMap<Character,TrieNode> getChildren() {   return children;  }
    public char getValue()                           {   return value;     }
    public void setIsEnd(boolean val)                {   bIsEnd = val;     }
    public boolean isEnd()                           {   return bIsEnd;    }
 
    private char value;
    private HashMap<Character,TrieNode> children;
    private boolean bIsEnd;
}
 
// Implements the actual Trie
class Trie {
    // Constructor
    public Trie()   {     root = new TrieNode((char)0);       }    
 
    // Method to insert a new word to Trie
    public void insert(String word)  {
 
        // Find length of the given word
        int length = word.length();
        TrieNode crawl = root;
 
        // Traverse through all characters of given word
        for( int level = 0; level < length; level++)
        {
            HashMap<Character,TrieNode> child = crawl.getChildren();
            char ch = word.charAt(level);
 
            // If there is already a child for current character of given word
            if( child.containsKey(ch))
                crawl = child.get(ch);
            else   // Else create a child
            {
                TrieNode temp = new TrieNode(ch);
                child.put( ch, temp );
                crawl = temp;
            }
        }
 
        // Set bIsEnd true for last character
        crawl.setIsEnd(true);
    }
 
    // The main method that finds out the longest string 'input'
    public String getMatchingPrefix(String input)  {
        String result = ""; // Initialize resultant string
        int length = input.length();  // Find length of the input string       
 
        // Initialize reference to traverse through Trie
        TrieNode crawl = root;   
 
        // Iterate through all characters of input string 'str' and traverse
        // down the Trie
        int level, prevMatch = 0;
        for( level = 0 ; level < length; level++ )
        {
            // Find current character of str
            char ch = input.charAt(level);    
 
            // HashMap of current Trie node to traverse down
            HashMap<Character,TrieNode> child = crawl.getChildren();                        
 
            // See if there is a Trie edge for the current character
            if( child.containsKey(ch) )
            {
               result += ch;          //Update result
               crawl = child.get(ch); //Update crawl to move down in Trie
 
               // If this is end of a word, then update prevMatch
               if( crawl.isEnd() )
                    prevMatch = level + 1;
            }
            else  break;
        }
 
        // If the last processed character did not match end of a word,
        // return the previously matching prefix
        if( !crawl.isEnd() )
                return result.substring(0, prevMatch);        
 
        else return result;
    }
 
    private TrieNode root;
}
 
class Main{
    
 
 	
    public static void main(String[] args) throws IOException{
        
             InputReader sc=new InputReader(System.in);
           //  PrintWriter pw=new PrintWriter(new FileWriter("E:\\a.txt"));
             
          
           int n=sc.nextInt();
           ArrayList<String> al=new ArrayList<>();
           ArrayList<String> aP=new ArrayList<>();
           ArrayList<String> aM=new ArrayList<>();
           Trie dict = new Trie();
           
           for (int i = 0; i < n; i++) {
            String s=sc.next();
            if(s.charAt(0)=='+'){
                aP.add(sc.next());
            }
            else{
                aM.add(sc.next());
            }
               
        }
          TreeSet<String> ts=new TreeSet<>();
           boolean val=true;
         
           Collections.sort(aP);
           Collections.sort(aM);
           int idx=0;char prev='.';
           int tidx=idx;
          int maxL=Integer.MIN_VALUE;
           for (int i = 0; i < aM.size(); i++) {
            char c=aM.get(i).charAt(0);
     
            
            if(c==prev){
                String ss=aM.get(i);
               String ans=dict.getMatchingPrefix(ss);
              if(ans.length()==0)
              ts.add(""+ss.charAt(0));
              else
              if(ss.equals(ans)){
                  val=false;
                  break;
              }
              else
              ts.add(ans+ss.charAt(ans.length())); 
              
              continue;
            }
            
            int ti=i;
            while(ti<aM.size() && aM.get(ti).charAt(0)==c){
                maxL=Math.max(maxL, aM.get(ti).length());
                ti++;
            }
            
            
            prev=c;
            tidx=idx;
            
            
              while(idx<aP.size() && aP.get(idx).charAt(0)!=c){
                  idx++;
              } 
              if(idx>=aP.size()){
                  ts.add(""+c);
                  idx=tidx;
                  continue;
              }
              char temp=aP.get(idx).charAt(0);
              while(idx<aP.size() && aP.get(idx).charAt(0)==temp){
                  String tz=aP.get(idx);
                  String z=tz.substring(0, Math.min(tz.length(), maxL));
                  
                  for(int q=0;q<z.length();q++)
                  dict.insert(z.substring(0, q+1));
                  idx++;
              }
              String ss=aM.get(i);
               String ans=dict.getMatchingPrefix(ss);
              if(ans.length()==0)
              ts.add(""+ss.charAt(0));
              else
              if(ss.equals(ans)){
                  val=false;
                  break;
              }
              else
              ts.add(ans+ss.charAt(ans.length())); 
              
              maxL=Integer.MIN_VALUE;
        }
           
           
         if(!val){
             System.out.println("-1");
         }else{
           System.out.println(ts.size());
          for(String ss:ts){
              System.out.println(ss);
          }
         }
           
            
           }
             
           
             
        }
        
        
 
        
        
    
    
    
 
 
 
 class InputReader
	{
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;
		
		public InputReader(InputStream stream)
		{
			this.stream = stream;
		}
		
		public int read()
		{
			if (numChars==-1) 
				throw new InputMismatchException();
			
			if (curChar >= numChars)
			{
				curChar = 0;
				try 
				{
					numChars = stream.read(buf);
				}
				catch (IOException e)
				{
					throw new InputMismatchException();
				}
				
				if(numChars <= 0)				
					return -1;
			}
			return buf[curChar++];
		}
	 
		public String nextLine()
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
		}
		public int nextInt()
		{
			int c = read();
			
			while(isSpaceChar(c)) 
				c = read();
			
			int sgn = 1;
			
			if (c == '-') 
			{
				sgn = -1;
				c = read();
			}
			
			int res = 0;
			do 
			{
				if(c<'0'||c>'9') 
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			while (!isSpaceChar(c)); 
			
			return res * sgn;
		}
		
		public long nextLong() 
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') 
			{
				sgn = -1;
				c = read();
			}
			long res = 0;
			
			do 
			{
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			while (!isSpaceChar(c));
				return res * sgn;
		}
		
		public double nextDouble() 
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') 
			{
				sgn = -1;
				c = read();
			}
			double res = 0;
			while (!isSpaceChar(c) && c != '.') 
			{
				if (c == 'e' || c == 'E')
					return res * Math.pow(10, nextInt());
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			if (c == '.') 
			{
				c = read();
				double m = 1;
				while (!isSpaceChar(c)) 
				{
					if (c == 'e' || c == 'E')
						return res * Math.pow(10, nextInt());
					if (c < '0' || c > '9')
						throw new InputMismatchException();
					m /= 10;
					res += (c - '0') * m;
					c = read();
				}
			}
			return res * sgn;
		}
		
		public String readString() 
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do 
			{
				res.appendCodePoint(c);
				c = read();
			} 
			while (!isSpaceChar(c));
			
			return res.toString();
		}
	 
		public boolean isSpaceChar(int c) 
		{
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
	 
		public String next() 
		{
			return readString();
		}
		
		public interface SpaceCharFilter 
		{
			public boolean isSpaceChar(int ch);
		}
	}   

import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{  
     static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main (String[] args) throws java.lang.Exception
	{
		int n = Integer.parseInt(br.readLine());
		int ans =0;
		while(n-->0)
		{
	       int k = Integer.parseInt(br.readLine());
	       String str = "zyxwvutsrqponmlkjihgfedcba";
	       int x = k%25;
	       if(x>0)
	       System.out.print(str.substring(25-x));
	       int y = k/25;
	       for(int i=1;i<=y;++i)
	       System.out.print(str);
	       
	        System.out.println();
		}
		
}
} 

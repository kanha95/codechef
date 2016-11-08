import java.io.* ;
import java.util.* ;
 
public class Main
{
	public static void main(String[] args) throws Exception
	{	
		int p , n , cps , i , j , sq ;
		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in)) ;
		n = Integer.parseInt(br.readLine()) ;
		while(n-- != 0)
		{
			p = Integer.parseInt(br.readLine()) ;
			sq = (int)Math.sqrt(p) ;
			for(i = sq ; i >= 1 ; i--)
			{
				if(p % i == 0)
				{
					System.out.println(p / i - i);
					break ;
				}
			}
		}
	}
} 

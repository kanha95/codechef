import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
 
 
public class Main {
 
	public static void main(String args[]) throws NumberFormatException, IOException
	{
 
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		HashMap<Character,Integer> maxCount=new HashMap<Character,Integer>();
		maxCount.put('E',0);
		maxCount.put('M',0);
		maxCount.put('I',0);
		//int t=Integer.parseInt(br.readLine());
		int t=1;
		while(t>0)
		{
			String line=br.readLine();
			int i;
			for( i=0;i<line.length();i++)
			{
				if(line.charAt(i)=='I')
				{
					maxCount.put('I',1);
					break;
				}
				
				
				
			}
			int pos=i;
				
			for(i=pos+1;i<line.length();i++)
			{
				int max=0;
				char current=line.charAt(i);
				if(current=='I')
					maxCount.put('I', maxCount.get('I')+1);
				if(current=='E')
				{
					if(Math.max(maxCount.get('E'),maxCount.get('I'))==0)
						maxCount.put('E', 0);
					else
						maxCount.put('E', Math.max(maxCount.get('I'),maxCount.get('E'))+1);
					
					
				}
				if(current=='M')
				{
					if(Math.max(maxCount.get('M'),maxCount.get('E'))==0)
						maxCount.put('M', 0);
					else
						maxCount.put('M', Math.max(maxCount.get('M'),maxCount.get('E'))+1);
				}	
				
				
			}
			
			System.out.println(maxCount.get('M'));
			t--;
		}
 
	}
 
 
 
} 

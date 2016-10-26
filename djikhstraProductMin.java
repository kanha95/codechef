import java.util.*;
import java.math.BigInteger;

class pair implements Comparable<pair>{
    double log;
    int index;
    pair(double log,int index){
        this.log=log;
        this.index=index;
    }
    public int compareTo(pair that){
        return Double.compare(this.log, that.log);
    }
    
}

public class acm {
static int ans=0;
  static final int mod=(int)(1e9+7);

    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    
    int n=sc.nextInt();
   int k=sc.nextInt();
   
   int[] ar=new int[n];
   for(int i=0;i<n;i++){
       ar[i]=sc.nextInt();
   }
   PriorityQueue<pair> pq=new PriorityQueue<>();
   
   long[] min=new long[n];
   min[0]=ar[0]%1000000007;
   pq.add(new pair(Math.log(ar[0]),0));
   
   for(int i=1;i<n;i++){
     
       while(i-pq.peek().index>k) pq.poll();
        // System.out.println(pq.peek().index);
       int j=pq.peek().index;
       min[i]=(min[j]*ar[i])%1000000007;
      pq.add(new pair(Math.log(ar[i])+pq.peek().log,i));
      
     
   }
   System.out.println((int)min[n-1]);
    }
    
}

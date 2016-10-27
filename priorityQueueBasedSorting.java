import java.util.*;
import java.math.BigInteger;


class pair implements Comparable<pair>{
    int f,p;
    String s;
    pair(int f,int p,String s)
    {
        this.f=f;
        this.p=p;
        this.s=s;
    }    
    public int compareTo(pair that){
     //   System.out.println(this.p+" "+that.p+"-------");
        return -1*Integer.compare(this.p, that.p);
    }
    
}
public class acm{
  
    
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    
    int n=sc.nextInt();
    int m=sc.nextInt();
    ArrayList spf=new ArrayList();
    for(int i=0;i<n;i++){
        spf.add(sc.nextInt());
    }
   PriorityQueue<pair> pq=new PriorityQueue<>();
   //Stack<pair> st=new Stack<pair>();
    for(int i=0;i<m;i++){
   pq.add(new pair(sc.nextInt(),sc.nextInt(),sc.next()));
    
    }
     ArrayList<String> ad=new ArrayList<>();
    while(!pq.isEmpty()){
        if(spf.contains(pq.peek().f)){
            System.out.println(pq.poll().s);
        }else
        ad.add(pq.poll().s);
    }
    for(String s:ad){
        System.out.println(s);
     }
    }
}

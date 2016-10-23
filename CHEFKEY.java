import java.util.*;

public class acm {
static int ans=0;
  

    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    
    int t=sc.nextInt();
    while(t>0){
       int n=sc.nextInt();
       int m=sc.nextInt();
       int c=sc.nextInt();
       int ans=0;
       for(int i=1;i*i<=c;i++){
           
           if(c%i==0){
               if(i<=n && (c/i)<=m && i!=(c/i)) ans++;
               if(i<=m && (c/i)<=n) ans++;
           }
       }
       System.out.println(ans);
        t--;
    }
        
    }
    
}

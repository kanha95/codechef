import java.util.*;

public class acm {
static int ans=0;
  static final int mod=(int)(1e9+7);

    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    
    int t=sc.nextInt();
    while(t>0){
       int n=sc.nextInt();
         n++;
       int[] ar=new int[n+1];
       for(int i=1;i<=n;i++){
           ar[i]=sc.nextInt();
       }
       
       int[] suffix=new int[100010];
       int power=1;
       for(int i=n;i>=1;i--){
           suffix[i]=(int)((1L*power*ar[i])%mod);
           if(i<n){
               suffix[i]=(suffix[i]+suffix[i+1])%mod;
           }
       power=(power*2)%mod;    
       }
       long count;
       power=1;
       for(int i=1;i<n;i++){
           count=(1L*ar[i]*power)%mod;
           count=(1L*count*suffix[i+1])%mod;
           ans=(int)(ans+count)%mod;
          if(i>=2)
               power=(power*2)%mod;
           
       }
       System.out.println((2*ans)%mod);
      ans=0;
        t--;
    }
        
    }
    
}

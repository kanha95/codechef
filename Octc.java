import java.util.*;

public class Octc {

   
    public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
     
     int t=sc.nextInt();
     while(t>0){
       int n=sc.nextInt();
       long[] ar=new long[n];
       for(int i=0;i<n;i++){
           ar[i]=sc.nextLong();
       }
       int[] b=new int[n];
       int sum=1;
       b[0]=1;
     //  Arrays.fill(b, 1);
       for(int i=1;i<n;i++){
             
           if(ar[i-1]<=ar[i]){
             b[i]=b[i-1]+1;
             sum+=b[i];
           }else{
              b[i]=1; 
              sum+=b[i];
           }
       }
       
       System.out.println(sum);
       t--;
     }
        
        
    }
    
}

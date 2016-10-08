import java.util.*;

public class Octc {
     static int[] ar;
     static int n;
     static int k;
     static boolean[] d;
static boolean check(long sum,long target,int count,int elem){
    
    if(elem<n){
        if(!d[elem]){
            if(sum+ar[elem]==target){
                if(count==k-1){
                  return true;             
                }
                d[elem]=true;
                return check(0,target,count+1,0);
            }else if(sum+ar[elem]<target){
                d[elem]=true;              
                boolean x =check(sum+ar[elem],target,count,elem+1);
                d[elem]=false;
                boolean y=check(sum,target,count,elem+1);
                return x||y;
            }else{
                return check(sum,target,count,elem+1);
            }
        }
            else{
                    return check(sum,target,count,elem+1);
                    }
            
        }
        
        return false;
    }
    

    public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
     
     int t=sc.nextInt();
     while(t>0){
        n=sc.nextInt();
       k=sc.nextInt();
      ar=new int[n];
       long sum=0;
       for(int i=0;i<n;i++){
           ar[i]=sc.nextInt();
           sum+=ar[i];
       }
       if(sum%k==0){
       long x=sum/k;
       
       d=new boolean[n];
       if(check(0,x,0,0)){
           System.out.println("yes");
       }else{
           System.out.println("no");
       }
  
       }else{
           System.out.println("no");
       }
       t--;
     }
        
        
    }
    
}

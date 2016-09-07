
package chef2;

import java.util.*;
public class Chef2 {
    int count;
    int  n;
    int[] ax;
    int temp;
    void input(Scanner sc){
           n=sc.nextInt();
            ax=new int[7];
           ax[0]=-1;
           
           int[] x=new int[n];
            for(int i=0;i<n;i++){
                x[i]=sc.nextInt();
           }
            for(int k=0;k<n;k++){
                ax[x[k]]++;
                
            }
                       
            
            int po=check();
     
            count=po;
            while(temp>=4){
                po=check();
                count =count + po;
                
            }
    }

    int check(){
       temp=0;
       for(int i=1;i<ax.length;i++){
          
           if(ax[i]!=0){
               temp++;
               ax[i]--;
           }
       }
      
       if(temp==4 || temp==5){
           return temp%3;
       }else if(temp==6){
           return 4;
       }else{
           return 0;
       }
    }
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       int t=sc.nextInt();
       Chef2 obj;
       while(t>0){
           
           int p=sc.nextInt();
           int sum=0;int temp=0;
           boolean b=false;
          int hx=0;
           while(p>0){
               obj=new Chef2();
          obj.input(sc);
         hx++;
       
          if((obj.n+obj.count)>sum){
              sum=obj.n+obj.count;
              temp=hx;
              b=true;
          }
          
          else if((obj.n+obj.count)==sum){
            
              b=false;
              
                      
          }
          
          
          p--;
        
           }
           
           
          if(temp==1 && b){
              System.out.println("chef");
          }
          else if(!b){
              System.out.println("tie");
          }
          else {
              System.out.println(temp);
          }
          
          
           t--;
       }
    }
    
}

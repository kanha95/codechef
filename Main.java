 import java.util.*;
import java.util.regex.Pattern;
 
public class Main {

   
    
    public static void main(String[] args) {
       
         Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
   sc.nextLine();
    while(t>0){
     String s=sc.nextLine();
       char[] ax=s.toCharArray();
       
             int low=0;
             boolean b=true;
             int high=ax.length-1;
             int mid=(low+high)/2;
             for(int i=0;i<=mid;i++){
                 if(ax[i]==ax[high-i]){
                     if(ax[i]=='.' && ax[high-i]=='.'){
                         ax[i]='a';
                         ax[high-i]='a';
                     }
                 }
                 if(ax[i]!=ax[high-i]){
                     
                      if(ax[i]=='.'){
                         ax[i]=ax[high-i];
                     }else if(ax[high-i]=='.'){
                         ax[high-i]=ax[i];
                     }else{
                         b=false;
                     }
                 }
             }
             
             
              if(b){
                 if(((high+1)%2) != 0 && ax[mid]=='.'){
                  ax[mid]='a';
              }
                 for(int k=0;k<ax.length;k++)
                 System.out.print(ax[k]);
              }
              else{
                  System.out.print("-1");
              }
              System.out.println();
      
        
        t--;
    }
    }
    
    
}

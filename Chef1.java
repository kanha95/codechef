
package chef1;

import java.util.*;
public class Chef1 {

    
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
    sc.nextLine();
    while(t>0){
        int count0=0,count1=0;
        String s=sc.nextLine();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                count0++;
            }else{
                count1++;
            }
        }
     
        if(count0==1 || count1==1){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
        t--;
    }
        
    }
    
}

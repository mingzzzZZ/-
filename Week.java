package test;
import java.util.Scanner;

public class Week {
       
     public static void main (String args[]) {
    	 Scanner scan = new Scanner(System.in);
         question q = new question();                                                
         int r = Integer.parseInt(args[0]);                                                
         int n = Integer.parseInt(args[1]);                                            
         int l = Integer.parseInt(args[2]);                                               
         int count = 0;                                                             
      for (int i = 0; i < n; i ++ ) {
    	   q.initialize(r,l);                                                
           q.print(l);                                                                     
           if (scan.nextLine().equals (q.res))   { 
        	   System.out.println("        !\n");
               count ++;
               }
                 else{
                	 System.out.println("        !           : " + q.res + "\n");
                }
                 
            }
      System.out.println("        " + count + "            :" + 100 * count / n + "!\n");
      scan.close();
      }

}
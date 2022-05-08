package com.greatlearning.DSAssignment2Graded50Problem1;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
/*Project to analyze skyscraper Construction process to be constructed in N days
*with distinct floor sizes being constructed in other factories & then assembled. 
*Given conditions are:
*a) Every day a floor is constructed in a separate factory of distinct size.
*b) larger size floor must be placed at the bottom of the building.
*A floor cannot be assembled in the building until all
*floors larger in size are placed.
*/

public class AnalyseConstruction
  {
	  int[] floorsize;
	  static int i;
	  
	  public static void main(String args[])
	  {
	   Deque<Integer> queue = new LinkedList<Integer>();
	   Deque<Integer> temp = new LinkedList<Integer>();
	   Scanner sc = new Scanner(System.in); 
	    System.out.println("Welcome to the Program...");
	    String ans ="yes";
	    while(ans.equalsIgnoreCase("yes"))
	    {
	    System.out.println("Enter the total no of floors in the building");
	    int N = sc.nextInt();
	    int Size = N+1;
	    int[] floorsize = new int[Size];
	 
	    for(i=1;i<=N;i++)
	    { 
		 System.out.println("Enter the floorsize given on day :" +i);
	     int flr_size = sc. nextInt();
		 floorsize[i]= flr_size;
		 queue.addFirst(i);
		 }   
	   
	    System.out.println("The order of construction is as follows\n");
	  
	    for(i=1;i<=N;i++)
	    {
		 int flr_siz = floorsize[i];
		 temp.addFirst(flr_siz);
	 	 System.out.println("Day "+i +" :");
	 	 dequeue(queue,temp);
		 System.out.println();
	    }
	   
	    System.out.println("End of this case of program\n");
	    System.out.println("Do you wish to continue to test"+ 
		   		" other cases");
	    System.out.println("Type <yes/YES> to continue or anyother character to quit");
	     ans = sc.next();
	    }//end while
	    System.out.println("Bye. End of the program\n");	   
	  }//end main method
		
	  public static void dequeue(Deque queue, Deque temp)
	  {  
	    if(queue.isEmpty()||temp.isEmpty())
		 {
			return;
		 }
		else if(queue.peek()==temp.peek())
		 {   
			System.out.print(queue.poll()+" ");
			temp.poll();
			dequeue(queue,temp);
		 }
	   }//end dequeue method
 }//end AnalyseConstruction
		

package com.greatlearning.DSAssignment2Graded50Problem2;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
//Program to modify the existing BST storing data of Transactions
//in an MNC s.t the tree is always a complete Binary Tree.
// The modified BST should not contain any left node 
//and display the node values present in BST in ascending order
//To do so we have Converted the BST into a Skewed Tree

 class Node
	{
		int val;
		Node left, right;
		
		Node(int item)
		{//allocating a new node with the given data
		// and NULL left & right pointers
			val = item;
			left = right = null;
		}
	}
	
	
  public class ModifiedSkewedBST
   {
	public static Node node;
	static Node prevNode = null;
	static Node headNode = null;
		
	//Method to modify the BST into a skewed tree in ascending order
	static void modifyBSTtoSkewed(Node root)	
	 {
		// Base Case
		if(root == null)
		{
			return;
		}
			
		modifyBSTtoSkewed(root.left);
		Node rightNode = root.right;
		Node leftNode = root.left;
		// check if the root Node of the skewed tree is not defined
		if(headNode == null)
		{
		   headNode = root;
		   root.left = null;
		   prevNode = root;
		}
		else
		{
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}
		 modifyBSTtoSkewed(rightNode);
	}

	// traverse the right skewed tree using recursion
	static void traverseRightSkewed(Node root)
	{
		if(root == null)
		{
			return;
		}
		System.out.print(root.val + " ");
		traverseRightSkewed(root.right);	
	}
      
	public void levelOrder(Node root) 
	{
	  Queue<Node> queue1 = new LinkedList<Node>();
	  queue1.add(root);
	   while (!queue1.isEmpty()) 
		 {
		   Node tempNode = queue1.poll();
		   System.out.print(tempNode.val + " ");
		    // enqueue left node
		    if (tempNode.left != null) {
		      queue1.add(tempNode.left);
		     }

		    // enqueue right node
		    if (tempNode.right != null) {
		      queue1.add(tempNode.right);
		     }//end if
		   }//end while
	 }//end levelorder
		
	// Main Driver Code
	public static void main (String[] args)
	{
		ModifiedSkewedBST tree = new ModifiedSkewedBST();
			
		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.left.left = new Node(10);
		tree.node.right =  new Node(60);
		tree.node.right.left = new Node(55);
			
	    System.out.println("Welcome to this program\n"+"To modify BST storing Company Transaction data\n");
	    System.out.println("The Existing BST storing Company transaction data is : \n"+ 
		    	"<Printed using levelorder Traversal>"+"\n");
			
		tree.levelOrder(node);
		System.out.println();
		System.out.println("\nNow after the company Modified the BST\n"
				+"Transaction data in ascending order is given below\n"
		+"< Now Data is Stored in a Skewed tree >\n\n");
		
		System.out.println("So The modified ascending order skewed tree is");
		modifyBSTtoSkewed(node);
		traverseRightSkewed(headNode);
	 }
  }
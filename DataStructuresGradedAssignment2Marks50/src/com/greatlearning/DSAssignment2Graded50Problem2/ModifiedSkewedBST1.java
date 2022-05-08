package com.greatlearning.DSAssignment2Graded50Problem2;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//Program to modify the existing BST storing Transaction Data
//in an MNC s.t the tree is always a complete Binary Tree.
// The modified BST should not contain any left node 
//and display the node values present in BST in ascending order
// To do so we have Converted the BST into a Skewed Tree

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

   public class ModifiedSkewedBST1 {

	public static Node node;
	static Node prevNode = null;
	static Node headNode = null;
	
	//Recursive method to insert a key into a BST
	public static Node insert(Node root, int key)
	{
	    // if the root is null, create a new node and return it
	    if (root == null) 
	    {
	        return new Node(key);
	     }

	    // if the given key is less than the root node, insert in the left subtree
	    if (key < root.val)
	    {
	        root.left = insert(root.left, key);
	    }

	    // if the given key is more than the root node, insert in the right subtree
	    else 
	    {
	        root.right = insert(root.right, key);
	    }

	    return root;
	}

	public void levelOrder(Node root) {
	    Queue<Node> queue1 = new LinkedList<Node>();
	    queue1.add(root);
	    while (!queue1.isEmpty()) {
	      Node tempNode = queue1.poll();
	      System.out.print(tempNode.val + " ");
	       
	      // enqueue left node
	      if (tempNode.left != null) {
	       queue1.add(tempNode.left);
	      }

	      // enqueue right node
	      if (tempNode.right != null) {
	        queue1.add(tempNode.right);
	     }
	    }//end while
	}//end levelorder

	
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
		
		modifyBSTtoSkewed(rightNode);//recursive call
	}//end method

	// method to traverse the right skewed tree using recursion
	static void traverseRightSkewed(Node root)
	{
		if(root == null)
		{
			return;
		}
		System.out.print(root.val + " ");
		traverseRightSkewed(root.right);	
	}

	// Main Driver Code
	public static void main (String[] args)
	{
		ModifiedSkewedBST1 tree = new ModifiedSkewedBST1();
		Scanner sc = new Scanner(System.in);
	    Node root = null;
		
	    root = tree.insert(root, 50);
	    root = tree.insert(root, 30);
	    root = tree.insert(root, 10);
	    root = tree.insert(root, 60);
	    root = tree.insert(root, 55);
	    
	    System.out.println("Hello. This is a program to modify BST storing Company Transaction data\n\n");
	    System.out.println("The BST for storing Company transaction data is : \n"+ 
		    	"<Printed using levelorder Traversal>"+"\n");
			
		tree.levelOrder(root);
		 System.out.println();
		System.out.println("\nNow after the company has Modified the existingBST\n"
				+"Transaction data in ascending order is given below\n"
		+"< Now data Stored in a Skewed tree >\n\n");
		
		modifyBSTtoSkewed(root);
		traverseRightSkewed(headNode);
		System.out.println("\nThanks. End of the Program");
	}

  }//end class modifiedskewed



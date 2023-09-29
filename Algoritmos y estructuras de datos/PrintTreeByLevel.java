import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class PrintTreeByLevel {

	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static void levelOrder(Node root) {
      Queue<Node> queue = new LinkedList<Node>();//Queue to use as an aux structure to put in the current node of the tree,begining by the root.
      queue.add(root);

      while(!queue.isEmpty())//If the queue is not empty, then print the current data node from node,left,right
      {
        Node tempNode= queue.poll();/*Unqueue the current head node and reference by the tempNode variable*/
        System.out.print(tempNode.data+" ");

        if(tempNode.left!=null)//If exist, queue the left node.
        {
            queue.add(tempNode.left);
        }
        if(tempNode.right!=null)//If exist, queue the right node.
        {
            queue.add(tempNode.right);
        }
      }
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        levelOrder(root);
    }	
}
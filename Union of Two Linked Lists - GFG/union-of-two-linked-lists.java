//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node 
{
    int data;
    Node next;
    
    Node(int a)
        {
            data = a;
            next = null;
        }
}

class GfG
{
    static Scanner sc = new Scanner(System.in);
    
    public static Node inputList(int size)
    {
        Node head, tail;
        int val;
        
        val = sc.nextInt();
        
        head = tail = new Node(val);
        
        size--;
        
        while(size-->0)
        {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }
        
        return head;
    }
    
    public static void printList(Node n)
    {
        while(n!=null)
        {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
    
    public static void main(String args[])
    {
        int t = sc.nextInt();
        while(t-->0)
        {
            int n , m;
            
            n = sc.nextInt();
            Node head1 = inputList(n);
            
            m = sc.nextInt();
            Node head2 = inputList(m);
            
            Sol obj = new Sol();
            
            printList(obj.findUnion(head1, head2));
            System.out.println();
        }
    }
}
// } Driver Code Ends


/*
    class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

// approach : build union and then follow the merge sort

class Sol
{
	public static Node findUnion(Node head1,Node head2)
	{
	    // find last element of head1 list
	    Node temp=head1;
	    while(temp.next!=null)
	    {
	        temp=temp.next;
	    }
	    temp.next=head2;
	    Node mergeList=mergeSort(head1);
	    duplicates(mergeList);
	    // now remove duplicates
	    return mergeList;
	}
	public static void duplicates(Node head)
	{
	    Node prev=head,curr=head.next;
	    while(curr!=null)
	    {
	        if(prev.data!=curr.data)
	        {
	            prev.next=curr;
	            prev=curr;
	        }
	        curr=curr.next;
	    }
	    prev.next=null; //
	}
	public static Node mergeSort(Node head1)
	{
	    if(head1==null||head1.next==null)
	    {
	        return head1;
	    }
	    Node mid=findMid(head1);
	    Node rightListHead=mid.next;
	    mid.next=null;
	    Node leftList=mergeSort(head1);
	    Node rightList=mergeSort(rightListHead);
	    return merge(leftList,rightList);
	}
	public static Node findMid(Node head1)
	{
	    if(head1==null)
	    {
	        return null;
	    }
	    Node slow=head1,fast=head1;
	    while(fast.next!=null&&fast.next.next!=null)
	    {
	        fast=fast.next.next;
	        slow=slow.next;
	    }
	    return slow;
	}
	public static Node merge(Node leftList,Node rightList)
	{
	    if(leftList==null)
	    {
	        return rightList;
	    }
	    if(rightList==null)
	    {
	        return leftList;
	    }
	    Node temp=null;
	    if(leftList.data<rightList.data)
	    {
	        temp=leftList;
	        temp.next=merge(leftList.next,rightList);
	    }
	    else
	    {
	        temp=rightList;
	        temp.next=merge(leftList,rightList.next);
	    }
	    return temp;
	}
}
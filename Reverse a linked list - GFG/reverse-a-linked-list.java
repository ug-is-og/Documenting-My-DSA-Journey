//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
    
}
class GFG{
	static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
    public static void main(String args[]) throws IOException { 
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t > 0){
        
        	int n = sc.nextInt();
        
            Node head = new Node(sc.nextInt());
            Node tail = head;
        
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
        
            Solution ob = new Solution();
            head = ob.reverseList(head);
            printList(head); 
            t--;
        }
    } 
} 
   
// } Driver Code Ends




//function Template for Java

/* linked list node class:

class Node {
    int data;
    Node next;
    Node(int value) {
        this.value = value;
    }
}

*/

// class Solution
// {
//     // using array approach
    
//     Node reverseList(Node head)
//     {
//         // find the size of linked list
//         Node tempNode=head;
//         int count=0;
//         while(tempNode!=null)
//         {
//             tempNode=tempNode.next;
//             count++;
//         }
//         int arr[]=new int[count];
//         tempNode=head;
//         for(int i=0;i<arr.length;i++)
//         {
//             arr[i]=tempNode.data;
//             tempNode=tempNode.next;
//         }
//         for(int i=0;i<arr.length/2;i++)
//         {
//             int temp=arr[i];
//             arr[i]=arr[arr.length-1-i];
//             arr[arr.length-1-i]=temp;
//         }
//         tempNode=head;
//         for(int i=0;i<count;i++)
//         {
//             tempNode.data=arr[i];
//             tempNode=tempNode.next;
//         }
//         return head;
//     }
// }


// tum second approach lagate samay soch re the ki second half linked list ke pointers ko reverse kar denge
// and fir swap kar te jayyenge values ko, toh basically tum values swap karne ka soch re the jaise array wali
// approach mein kiya hai but there's a better way of doing stuff here
// tum values na sochke yeh socho ki harr ek link ko kaise swap kar sakte ho, tab zaada chamkega

class Solution
{
    Node reverseList(Node head)
    {
        Node prev=null;
        Node slow=null;
        prev=head;
        slow=head.next;
        Node temp=null;
        prev.next=null;
        while(slow!=null)
        {
            temp=slow.next;
            slow.next=prev;
            prev=slow;
            slow=temp;
        }
        return prev;
    }
}

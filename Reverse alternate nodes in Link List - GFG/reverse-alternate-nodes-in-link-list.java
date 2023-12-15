//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Rearr
{
    static Node head;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  =sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                temp.next = new Node(a);
                temp = temp.next;
            }
            
            Solution ob = new Solution();
            ob.rearrange(head);
            printLast(head);
            System.out.println();
        }
    }
    
    public static void printLast(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/

//It is mandatory to not use recursion and do it in O(1) extra space

// class Solution
// {
//     public static void rearrange(Node odd)
//     {
//         // build list1 and list2 as separate lists initially
//         if(odd==null||odd.next==null||odd.next.next==null)
//         {
//             return;
//         }
//         Node list1=odd,list2=odd.next;
//         Node tail1=odd,tail2=odd.next;
//         Node temp1=odd,temp2=odd.next;
//         while(temp1.next!=null&&temp2.next!=null) // yahan pe issi order mein likhna padega, very veyr important,
//         // analyze 2 cases, where there are odd no. of nodes, and when there are even no. of nodes, you'll get it
//         {
//             temp1=temp1.next.next;
//             temp2=temp2.next.next;
//             tail1.next=temp1;
//             tail1=temp1;
//             tail2.next=temp2;
//             tail2=temp2;
//         }
//         tail1.next=null;
//         if(tail2!=null)
//         tail2.next=null;
//         // Now you have to reverse the list2
//         list2=reverseLL(list2);
//         tail1.next=list2;
//         odd=list1;
//     }
//     public static Node reverseLL(Node list2)
//     {
//         if(list2==null||list2.next==null)
//         {
//             return list2;
//         }
//         Node prev=list2;
//         Node curr=list2.next;
//         Node temp=list2;
//         prev.next=null;
//         while(temp!=null)
//         {
//             temp=curr.next;
//             curr.next=prev;
//             prev=curr;
//             curr=temp;
//         }
//         return prev;
//     }
// }




class Solution
{
    public static void rearrange(Node odd)
    {
        if(odd.next==null)
        {
            return;
        }
        Node head1=odd,head2=odd.next;
        Node tail1=head1,tail2=head2;
        while(tail2.next!=null&&tail2.next.next!=null)
        {
            Node temp1=tail1.next.next;
            Node temp2=tail2.next.next;
            tail1.next=temp1;
            tail1=temp1;
            tail2.next=temp2;
            tail2=temp2;
        }
        tail1.next=null; // for even no of nodes case
        //reverse list head2;
        Node prev=head2,curr=prev.next;
        prev.next=null;
        while(curr!=null)
        {
            Node temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        tail1.next=prev;
    }
}


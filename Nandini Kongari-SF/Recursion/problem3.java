import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next=null;
    }
}

public class problem3 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode middle = findMiddle(head);
        ListNode secondHalf = middle.next;
        middle.next = null;
        ListNode reversedSecondHalf = reverseList(secondHalf);
        mergeLists(head, reversedSecondHalf);
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private void mergeLists(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            ListNode l1Next = l1.next;
            ListNode l2Next = l2.next;

            l1.next = l2;
            l2.next = l1Next;

            l1 = l1Next;
            l2 = l2Next;
        }
    }

    public ListNode insert(ListNode head,int n){
        ListNode newNode=new ListNode(n);
        if(head==null){
            head=newNode;
            return head;
        }
        ListNode temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
        return head;
    }
    public void display(ListNode head){
        ListNode temp=head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
        return;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        problem3 solution = new problem3();
        System.out.print("Enter the length of the linked list:");
        int n=sc.nextInt();
        ListNode head =null;
        for(int i=0;i<n;i++){
            int temp=sc.nextInt();
            head=solution.insert(head,temp);
        }
        solution.reorderList(head);
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}

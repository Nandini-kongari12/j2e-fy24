
import java.util.*;

class ListNode {
    int n;
    ListNode next;

    ListNode(int n) {
        this.n = n;
    }

    ListNode(int n, ListNode next) {
        this.n = n;
        this.next = next;
    }

    @Override
    public String toString() {
        return n + " ";
    }
}

class LinkedList {

    ListNode head;

    LinkedList() {
        head = null;
    }

    public void insertAtEnd(int n) {
        ListNode newNode = new ListNode(n);
        if (this.head == null) {
            head = newNode;
            return;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return;
    }

    public void insertAtBegining(int n) {
        ListNode newNode = new ListNode(n, head);
        this.head = newNode;
        return;
    }

    public void displayList() {
        if (this.head == null) {
            System.out.println("The list is empty.");
            return;
        }
        ListNode temp = this.head;
        System.out.print("The linked list looks like: ");
        while (temp != null) {
            System.out.print(temp);
            temp = temp.next;
        }
        System.out.println();
        return;
    }

    public void deleteFirstNode() {
        if (this.head == null) {
            return;
        }
        this.head = this.head.next;
        return;
    }

    public void deleteLastNode() {
        if (this.head == null) {
            return;
        }
        ListNode temp = this.head;
        if (temp.next == null) {
            this.head = null;
        }
        while (temp.next != null && temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return;
    }

    public void deleteNode(ListNode node) {
        ListNode temp = this.head;
        while (temp.next != null && temp.next != node) {
            temp = temp.next;
        }
        if (temp.next == node) {
            temp.next = temp.next.next;
        }
        return;
    }

}

public class ll8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList llc1 = new LinkedList();
        LinkedList llc2 = new LinkedList();
        input(sc, llc1);
        input(sc, llc2);
        System.out.print("Enter the starting index: ");
        int a=sc.nextInt();
        System.out.print("Enter the ending index: ");
        int b=sc.nextInt();
        llc1.displayList();
        llc2.displayList();
        solve(llc1,llc2,a,b);
        System.out.println("List after modifications :");
        llc1.displayList();
    }
    public static void input(Scanner sc, LinkedList llc) {
        System.out.print("Enter the number of nodes that linked list consists of: ");
        int nodes = sc.nextInt();
        System.out.print("Enter the list elements: ");
        for (int i = 0; i < nodes; i++) {
            llc.insertAtEnd(sc.nextInt());
        }
    }

    public static void solve(LinkedList llc1,LinkedList llc2,int a,int b){
        ListNode starting=llc1.head;
        ListNode ending=llc1.head;
        ListNode temp=llc2.head;
        int t=1;
        while(t<a && starting!=null){
            starting=starting.next;
            a++;
        }
        System.out.println("starting: "+starting.n);
        ending=starting;
        while(t<b && ending!=null){
            ending=ending.next;
            t++;
        }
        System.out.println("ending: "+ending.n);
        starting.next=llc2.head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=ending;
        return;
    }

}

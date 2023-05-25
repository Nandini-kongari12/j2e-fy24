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

public class ll5 {

    public static void input(Scanner sc, LinkedList llc) {
        System.out.print("Enter the number of nodes that linked list consists of: ");
        int nodes = sc.nextInt();
        System.out.print("Enter the list elements: ");
        for (int i = 0; i < nodes; i++) {
            llc.insertAtEnd(sc.nextInt());
        }
    }

    public static void removeAllDuplicateNodes(LinkedList llc) {
        if (llc.head == null) {
            return;
        }
        ListNode t = llc.head;
        ListNode prev = llc.head;
        int val;
        while (t != null) {
            val = t.n;
            if (t.next != null && t.n == t.next.n) {
                while (t != null && t.n == val) {
                    if (llc.head.n==val) {
                        llc.head = t.next;
                        t = llc.head;
                        continue;
                    }
                    t = t.next;
                }
                prev.next = t;
            }
            prev = t;
            if(t!=null)
                t = t.next;
        }
        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList llc = new LinkedList();
        input(sc, llc);
        // function call
        removeAllDuplicateNodes(llc);
        llc.displayList();
    }
}
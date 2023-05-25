import java.util.*;
class MyCircularDeque {
    int size = 0;
    int currSize = 0;
    class ListNode {
        int val;
        ListNode next = null;
        ListNode prev = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    ListNode head;
    ListNode tail;
    public MyCircularDeque(int k) {
        size = k;
        head = null;
        tail = null;
    }
    public boolean insertFront(int value) {
        if (currSize == size)
            return false;

        ListNode newNode = new ListNode(value);
        currSize++;
      if (head == null) {
            head = tail = newNode;
            return true;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        return true;
    }
    public boolean insertLast(int value) {
        if (currSize == size)
            return false;
        ListNode newNode = new ListNode(value);
        currSize++;
        if (head == null) {
            head = tail = newNode;
            return true;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        return true;
    }
    public boolean deleteFront() {
        if (head == null)
            return false;
        currSize--;
        if (head == tail) {
            head = tail = null;
            return true;
        }
        head = head.next;
        head.prev = null;
        return true;
    }
    public boolean deleteLast() {
        if (tail == null)
            return false;
        currSize--;
        if (head == tail) {
            head = tail = null;
            return true;
        }
        tail = tail.prev;
        return true;
    }

    public int getFront() {
        if (head == null)
            return -1;
        return head.val;
    }

    public int getRear() {
        if (tail == null)
            return -1;
        return tail.val;
    }

    public boolean isEmpty() {
        if (head == null)
            return true;
        return false;
    }

    public boolean isFull() {
        if (currSize == size)
            return true;
        return false;
    }
}
public class ll7{
    public static void main(String[] Args){
        Scanner sc=new Scanner(System.in);
        MyCircularDeque cd=new MyCircularDeque(5);
        System.out.println(cd.insertLast(1));
        System.out.println(cd.insertLast(2));
        System.out.println(cd.insertFront(3));
        System.out.println(cd.insertFront(4));
        System.out.println(cd.getRear());
        System.out.println(cd.isFull());
        System.out.println(cd.deleteLast());
        System.out.println(cd.insertFront(4));
        System.out.println(cd.getFront());

    }
}

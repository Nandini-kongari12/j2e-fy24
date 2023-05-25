import java.util.*;

class QueueDS {
    Stack<Integer> st1, st2;
    int size;

    QueueDS() {
        st1 = new Stack<>();
        st2 = new Stack<>();
        size=0;
    }

    public void add(int val) {
        st1.push(val);
        this.size++;
        return;
    }

    public int pop(){
        if(st1.isEmpty()){
            System.out.println("The queue is empty!!!");
            return Integer.MIN_VALUE;
        }
        while(!st1.isEmpty()){
            st2.push(st1.pop());
        }
        int temp=st2.pop();
        while(!st2.isEmpty()){
            st1.push(st2.pop());
        }
        this.size--;
        return temp;
    }

    public int size(){
        return this.size;
    }

}

public class problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueDS q=new QueueDS();
        int temp=0;
        System.out.println("Choice : \n 1. push\n 2. pop\n 3. size\n 4. exit");
        while(true){
            System.out.print("Enter the choice : ");
            temp=sc.nextInt();
            switch (temp) {
                case 1:
                    System.out.print("Enter the value to be pushed into queue: ");
                    q.add(sc.nextInt());
                    break;
                case 2:
                    System.out.println("Poped value from queue : "+q.pop());
                    break;
                case 3:
                    System.out.println("Size of Stack is : "+q.size());
                    break;
                case 4:
                    return;
            }
        }
    }
}

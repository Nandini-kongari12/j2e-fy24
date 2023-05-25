
import java.util.*;

class StackDS{
    Queue<Integer> q1,q2;
    int size;
    boolean bq1; // booelan variable to know into which queue addition should take place

    StackDS(){
        q1=new LinkedList<>();
        q2=new LinkedList<>();
        size=0;
        bq1=true;
        System.out.println("Stack created");
    }

    public int size(){
        return this.size;
    }

    public void push(int n){
        this.size++;
        if(bq1){
            q1.add(n);
            return;
        }
        q2.add(n);
        return;
    }

    public int pop(){
        if(size==0){
            System.out.println("Stack is empty!!");
            return Integer.MIN_VALUE;
        }
        System.out.println("Q1 : "+q1);
        System.out.println("Q2 : "+q2);
        System.out.println("BQ1 : "+bq1);
        if(bq1){
            int temp=this.size;
            while(temp!=1){
                q2.add(q1.poll());
                temp--;
            }
            bq1=false;
            size--;
            System.out.println("Q1 : "+q1);
            System.out.println("Q2 : "+q2);
            System.out.println("BQ1 : "+bq1);
            return q1.poll();
        }
        int temp=this.size;
        while(temp!=1){
            q1.add(q2.poll());
            temp--;
        }
        bq1=true;
        size--;
        System.out.println("Q1 : "+q1);
        System.out.println("Q2 : "+q2);
        System.out.println("BQ1 : "+bq1);
        return q2.poll();
    }

}

public class problem1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int temp;
        StackDS st=new StackDS();
        System.out.println("Choice : \n 1. push\n 2. pop\n 3. size\n 4. exit");
        while(true){
            System.out.print("Enter the choice : ");
            temp=sc.nextInt();
            switch (temp) {
                case 1:
                    System.out.print("Enter the value to be pushed: ");
                    st.push(sc.nextInt());
                    break;

                case 2:
                    System.out.println("Poped value from stack : "+st.pop());
                    break;
                case 3:
                    System.out.println("Size of Stack is : "+st.size());
                    break;
                case 4:
                    return;
            }
        }
    }
}

import java.util.Scanner;
import java.util.Stack;

public class problem10 {
    public static int evaluteExpression(int n,String[] arr){
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            switch (arr[i]) {
                case "+":
                    st.push(st.pop()+st.pop());
                    break;
                case "-":
                    st.push(st.pop()-st.pop());
                    break;
                case "*":
                    st.push(st.pop()*st.pop());
                    break;
                case "/":
                    int temp=st.pop();
                    st.push(st.pop()/temp);
                    break;
                default:
                    st.push(Integer.parseInt(arr[i]));
                    break;
            }
        }
        return st.pop();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String[] arr=new String[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.next();
        }
        System.out.println(evaluteExpression(n, arr));
    }
}

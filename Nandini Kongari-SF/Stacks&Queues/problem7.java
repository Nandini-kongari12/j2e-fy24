import java.util.*;

public class problem7 {
    public static int[] getResArr(int n,int[] arr){
        int[] res=new int[n];
        if(n==0){return res;}
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            if(st.isEmpty()){
                res[i]=-1;
                st.push(arr[i]);
                continue;
            }
            if(st.peek()>arr[i]){
                res[i]=st.peek();
                st.push(arr[i]);
                continue;
            }
            while(!st.isEmpty() && st.peek()<=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i]=-1;
                continue;
            }
            res[i]=st.peek();
            st.push(arr[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int[] res=getResArr(n, arr);
        for(int i=0;i<n;i++){
            System.out.print(res[i]+" ");
        }
    }
}

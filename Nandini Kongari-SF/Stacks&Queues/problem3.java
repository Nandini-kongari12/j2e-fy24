import java.util.*;

public class problem3 {
    static class Pair{
        int e,i;
        Pair(int e,int i){
            this.e=e;
            this.i=i;
        }
    }
    public static List<Integer> getMaxForEachKEelements(int n,int[] arr,int k){
        List<Integer> ls=new LinkedList<>();
        Stack<Pair> st=new Stack<>();
        if(n==0){
            return ls;
        }
        int i=0;
        while(i<n){
            if(i>=k){
                ls.add(st.peek().e);
            }
            if(st.isEmpty()){
                st.push(new Pair(arr[i], i));
                i++;
                continue;
            }
            if(st.peek().e<arr[i]){
                st.pop();
                st.push(new Pair(arr[i], i));
            }
            i++;
        }
        if(!st.isEmpty()){
            ls.add(st.pop().e);
        }
        return ls;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        System.out.println(getMaxForEachKEelements(n, arr, k));
    }
}

import java.util.*;

public class Array8 {
    static class Pair{
        int start,end;
        Pair(int s,int e){
            start=s;
            end=e;
        }
        Pair(Pair p){
            start=p.start;
            end=p.end;
        }
        @Override
        public String toString(){
            return "["+start+","+end+"]";
        }
    }
    public static List<Pair> solve(int n,Pair[] arr){
        List<Pair> ls=new LinkedList<Pair>();
        Stack<Pair> st=new Stack<>();
        for(int i=0;i<n;i++){
            if(st.isEmpty()){
                st.push(new Pair(arr[i]));
                continue;
            }
            if(st.peek().end<arr[i].start){
                ls.add(st.pop());
                st.push(new Pair(arr[i]));
                continue;
            }
            st.peek().end=arr[i].end;
        }
        if(!st.isEmpty())
            ls.add(st.pop());
        return ls;
    }
    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            Pair[] arr=new Pair[n];
            for(int i=0;i<n;i++){
                arr[i]=new Pair(sc.nextInt(), sc.nextInt());
            }
            sc.close();
            System.out.println(solve(n, arr));
            return;
    }
}

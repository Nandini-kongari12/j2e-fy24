import java.util.*;

public class problem4 {
    int n,v;
    int[] arr;
    public int helper(int index,int health,int intake){
        if(health==0){
            return Integer.MAX_VALUE;
        }
        if(index==this.n){
            return intake;
        }
        int pick=helper(index+1,health+this.arr[index],intake+1);
        int not_pick=helper(index+1,health-1,intake);
        return Math.min(pick,not_pick);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        problem4 p=new problem4();
        p.n = sc.nextInt();
        p.v = sc.nextInt();
        p.arr = new int[p.n];
        for (int i = 0; i < p.n; i++) {
            p.arr[i] = sc.nextInt();
        }
        System.out.println(p.helper(0,p.v,0));
        return;
    }
}

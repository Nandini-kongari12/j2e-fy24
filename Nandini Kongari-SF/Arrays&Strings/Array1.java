// Done
import java.util.*;

public class Array1 {
    public static boolean[] getResArr(int n,int[] candies,int extraCandies,int max){
        boolean[] res=new boolean[n];
        for(int i=0;i<n;i++){
            res[i]=(candies[i]+extraCandies>=max)?true:false;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] candies=new int[n];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            candies[i]=sc.nextInt();
            if(max<candies[i]){
                max=candies[i];
            }
        }
        int extraCandies=sc.nextInt();
        boolean[] res=getResArr(n, candies, extraCandies, max);
        for(int i=0;i<n;i++){
            System.out.print(res[i]+" ");
        }
    }
}

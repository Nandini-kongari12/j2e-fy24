import java.util.*;
public class problem7 {
    static void getXor(int[] arr,int n){
        int min= Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                min = Math.min(min , arr[i] ^ arr[j]);
 
        System.out.println( min );
    }
    public static void main(String[] Agrs){
        try (Scanner sc = new Scanner(System.in)) {
            int n=sc.nextInt();
            int[] ar=new int[n];
            for(int i=0;i<n;i++) ar[i]=sc.nextInt();
            getXor(ar,n);
        }
    }
}

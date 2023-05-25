import java.util.*;

public class problem1 {
    public static int minimumDemonination(int n,int[] arr,int target){
        Arrays.sort(arr);
        int count=0;
        int required=target;
        for(int i=n-1;i>=0 && required!=0;i--){
            if(required<arr[i]){
                continue;
            }
            count=count+(required)/arr[i];
            required=(required)%arr[i];
        }
        if(required==0){
            return count;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int target=sc.nextInt();
        System.out.println(minimumDemonination(n, arr, target
        ));
    }
}

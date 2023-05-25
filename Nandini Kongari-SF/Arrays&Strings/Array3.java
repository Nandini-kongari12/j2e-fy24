import java.util.*;
public class Array3 {
        public static void main(String []args){
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            int x=sc.nextInt();
            System.out.println(solve(arr,x));
        }
        static int solve(int arr[],int x){
            Arrays.sort(arr);
            int sum=Integer.MAX_VALUE;
            for(int i=0;i<arr.length-2;i++){
                int p1=i+1,p2=arr.length-1;
                while(p1<p2){
                    int csum=arr[i]+arr[p1]+arr[p2];
                    if(Math.abs(x-csum)<Math.abs(x-sum)){
                        sum=csum;
                    }
                    if(csum>x){
                        p2--;
                    }
                    else    p1++;
                }
            }
            return sum;
        } 
}

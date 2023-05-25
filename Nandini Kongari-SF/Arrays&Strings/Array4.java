import java.util.*;
class Array4{
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        permutation(arr,n);
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
    static void permutation(int nums[],int n){
            int i1=0;
            int i2=0;
            for(int i=nums.length-2;i>=0;i--){
                if(nums[i]<nums[i+1]){
                    i1=i;
                    break;
                }
            }
            
            if(i1==0){
                reverse(nums,0);
            }
            
            else{
                
                for(int i=nums.length-1;i>=0;i--){
                    if(nums[i]>nums[i1]){
                        i2=i;
                        break;
                    }
                }

                swap(nums,i1,i2);
                
                reverse(nums,i1+1);
            }
        }
    static void swap(int[] nums,int i,int j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
    }
    static void reverse(int[] nums,int start){
            int i=start;
            int j=nums.length-1;
            while(i<j){
                swap(nums,i,j);
                i++;
                j--;
           }
    }
}
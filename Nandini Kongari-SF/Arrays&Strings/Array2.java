
/*
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints ofthe ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.Return the maximum amount of water a container can store
*/
import java.util.*;
public class Array2 {
    public static int getMaxVolume(int n,int[] heights){
        int i=0;
        int j=n-1;
        int maxV=0;
        int temp=0;
        while(i<j){
            if(heights[i]<heights[j]){
                maxV=Math.max(heights[i]*(j-i),maxV);
                i++;
            }else{
                maxV=Math.max(heights[j]*(j-i),maxV);
                j--;
            }
        }
        return maxV;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] heights=new int[n];
        for(int i=0;i<n;i++){
            heights[i]=sc.nextInt();
        }
        System.out.println(getMaxVolume(n, heights));
    }
}

import java.util.*;
public class problem2 {
    public static int coinChange(int[] coins, int amount) {
        return helper(coins, amount, new int[amount + 1]);
       
    }
     static int helper(int[] coins, int amount, int[] memo){
        if(amount == 0){
            memo[amount] = 0;
            return 0;
        }
        if(amount < 0){
            return -1;
        }
        if(memo[amount] != 0){
            return memo[amount];
        }
        int result = Integer.MAX_VALUE;       
        for(int coin : coins){
            int count = helper(coins, amount - coin, memo);   
            if(count >= 0){
                result = Math.min(result, 1 + count);
            }
        }
        memo[amount] = result == Integer.MAX_VALUE ? -1 : result;
        return memo[amount]; 
    }
    public static void main(String[] Args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] ar=new int[n];
        for(int i=0;i<n;i++) ar[i]=sc.nextInt();
        int amt=sc.nextInt();
        System.out.println(coinChange(ar,amt));
    }
}

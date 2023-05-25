
import java.util.*;
public class problem7 {
    public static int knapsack(int N, int W, int[] profit, int[] weight) {
        int[][] memo = new int[N + 1][W + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= W; j++) {
                memo[i][j] = -1;
            }
        }
        return knapsackHelper(N, W, profit, weight, memo);
    }

    private static int knapsackHelper(int N, int W, int[] profit, int[] weight, int[][] memo) {
        if (N == 0 || W == 0) {
            return 0;
        }
        if (memo[N][W] != -1) {
            return memo[N][W];
        }
        if (weight[N - 1] > W) {
            memo[N][W] = knapsackHelper(N - 1, W, profit, weight, memo);
        } else {
            int included = profit[N - 1] + knapsackHelper(N - 1, W - weight[N - 1], profit, weight, memo);
            int excluded = knapsackHelper(N - 1, W, profit, weight, memo);
            memo[N][W] = Math.max(included, excluded);
        }
        return memo[N][W];
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N = sc.nextInt();
        int W = sc.nextInt();
        int[] profit = new int[N];
        int[] weight = new int[N];
        for(int i=0;i<N;i++){
            profit[i]=sc.nextInt();
        }
        for(int i=0;i<N;i++){
            weight[i]=sc.nextInt();
        }
        int maxProfit = knapsack(N, W, profit, weight);
        System.out.println(maxProfit);
    }
}


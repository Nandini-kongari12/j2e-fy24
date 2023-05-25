import java.util.*;
class graph14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int minSwaps = minSwaps(nums);
        System.out.println(minSwaps);
        sc.close();
    }
    public static int minSwaps(int[] nums) {
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            valueToIndex.put(nums[i], i);
        }
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        boolean[] visited = new boolean[nums.length];
        int minSwaps = 0;
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || nums[i] == sortedNums[i]) {
                continue;
            }
            int cycleSize = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = valueToIndex.get(sortedNums[j]);
                cycleSize++;
            }
            minSwaps += cycleSize - 1;
        }
        return minSwaps;
    }
}


class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        boolean [][] dp = new boolean[n+1][sum/2+1];
        return solve(nums,n, sum/2,dp);
    }
    static boolean solve(int[] nums,int n, int target,boolean [][] dp) {
       for (int i = 0; i < target; i++) {
            dp[0][i] = false;
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                } else
                    dp[i][j] = dp[i - 1][j];
            }

        }
        return dp[n][target];
    }
}
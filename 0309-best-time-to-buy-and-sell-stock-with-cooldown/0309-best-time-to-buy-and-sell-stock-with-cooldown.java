class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][n+1];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row,-1));
        return solve(prices,n,0,0,dp);

    }

    static int solve(int[] prices, int n, int index,int decision, int[][] dp){
        if(index >= n){
            return 0;
        }
        if(dp[index][decision] != -1) return dp[index][decision];

        int cooldown = solve(prices,n,index+1,decision,dp);
        if(decision == 0){
            int buy = solve(prices,n,index+1,1,dp)-prices[index];
            dp[index][decision] = Math.max(buy,cooldown);
        }
        else{
            int sell = solve(prices,n,index+2,0,dp)+prices[index];
            dp[index][decision] = Math.max(sell,cooldown);    
        }
        return dp[index][decision];
    }
}
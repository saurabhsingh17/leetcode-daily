class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        
        int m = t1.length;
        int n = t2.length;
        
        int[][] dp = new int[m+1][n+1];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        return solve(t1,m,t2,n,dp);
    }

    static int solve(char[] t1, int m, char[] t2, int n,int[][] dp){
        if (n == 0 || m == 0) return 0;
        if (dp[m][n] != -1) return dp[m][n];
        if(t1[m-1] == t2[n-1]) {
            return dp[m][n] = 1 + solve(t1,m-1,t2,n-1,dp);
        }
        else {
            return dp[m][n] = Math.max(solve(t1,m-1,t2,n,dp),solve(t1,m,t2,n-1,dp));
        }
    }
}
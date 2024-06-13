class Solution {
    public int countGoodSubstrings(String s) {
        char[] ss = s.toCharArray();
        int L = 0;
        int count = 0;
        for (int R = 0; R < ss.length; R++) {
            if(R-L+1 > 3){
                L += 1;
            }
            if(R-L+1 == 3 && ss[L] != ss[L+1] && ss[L] != ss[L+2] && ss[L+2]!=ss[L+1]){
                count++;
            }
        }
        return count;
    }
}
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int n = ss.length;
        int m = tt.length;
        int[] b = new int[26];
        int[] b2 = new int[26];

        if(n != m) return false;
        for(int i = 0; i < n; i++){
            b[(int)(ss[i]-'a')] += 1; 
            b2[(int)(tt[i]-'a')] += 1;
        }
        for(int i = 0; i < 26; i++){
            //System.out.println(b[i]+" "+b2[i]);
            if(b[i] == b2[i])
            continue;
            else {
                return false;
            }
        }
        return true;
    }
}
// class Solution {
//     public String longestPalindrome(String str) {
//         char[] s = str.toCharArray();
//         String res = "";
//         int n = s.length;
//         int resLen = 0;
//         //odd cases
//         for (int i = 0; i < n; i++) {
//             int l = i, r = i; 
//             while( l >= 0 && r <n && s[l] == s[r]){
//                 if(r-l+1 > resLen) {
//                     res = str.substring(l,r+1);
//                     resLen = r-l+1;
//                 }
//                 l -= 1;
//                 r += 1;
//             }

//             l = i;
//             r = i+1;
//             while( l >= 0 && r <n && s[l] == s[r]){
//                 if(r-l+1 > resLen) {
//                     res = str.substring(l,r+1);
//                     resLen = r-l+1;
//                 }
//                 l -= 1;
//                 r += 1;
//             }

//         }
//     return res;
//     }
    
// }
class Solution {
    public String longestPalindrome(String str) {
        int n = str.length();
        String res = "";
        
        for (int i = 0; i < n; i++) {
            res = getLongerPalindrome(str, i, i, res);     // Odd-length palindromes
            res = getLongerPalindrome(str, i, i + 1, res); // Even-length palindromes
        }
        return res;
    }

    private String getLongerPalindrome(String str, int left, int right, String currentLongest) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        String palindrome = str.substring(left + 1, right);
        return palindrome.length() > currentLongest.length() ? palindrome : currentLongest;
    }
}

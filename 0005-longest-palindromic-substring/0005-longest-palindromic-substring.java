class Solution {
    public String longestPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }

        String processedStr = preprocess(str);
        int n = processedStr.length();
        int[] p = new int[n];
        int center = 0, right = 0;
        
        for (int i = 0; i < n; i++) {
            int mirror = 2 * center - i;
            if (right > i) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            int a = i + p[i] + 1;
            int b = i - p[i] - 1;
            while (a < n && b >= 0 && processedStr.charAt(a) == processedStr.charAt(b)) {
                p[i]++;
                a++;
                b--;
            }

            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }

        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 0; i < n; i++) {
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }

        int start = (centerIndex - maxLen) / 2;
        return str.substring(start, start + maxLen);
    }

    private String preprocess(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        for (char c : str.toCharArray()) {
            sb.append(c);
            sb.append('#');
        }
        return sb.toString();
    }
}


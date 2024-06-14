class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int L = 0;
        int count = 0;
        int sum = 0;
        for (int R = 0; R < arr.length; ++R) {
            sum += arr[R];
            if(R-L+1 > k){
                sum = sum-arr[L];
                L += 1;
            }
            if(R-L+1 == k && sum/k >= threshold){
                count++;
            }
        }
        return count;
    }
}
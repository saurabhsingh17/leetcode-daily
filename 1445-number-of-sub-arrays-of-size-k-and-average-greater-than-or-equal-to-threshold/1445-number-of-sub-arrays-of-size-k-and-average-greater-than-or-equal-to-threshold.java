class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int L = 0;
        int count = 0;
        int sum = 0;
        int div = 1;
        for (int R = 0; R < arr.length; ++R) {
            
            sum += arr[R];
            //System.out.println(L+" "+R+" "+sum);
            if(R-L+1 > k){
                sum = sum-arr[L];
                L += 1;
            }
            if(R-L+1 == k && sum/k >= threshold){
                //System.out.println(sum);
                count++;
            }
        }
        return count;
    }
}
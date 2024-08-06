class NumArray {
    int[] prefixSum;
    int n;
    public NumArray(int[] nums) {
        n = nums.length;
        prefixSum = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            prefixSum[i] = sum;
        }
    }
    
    public int sumRange(int left, int right) {
        if(left > 0 && right < n)
        return prefixSum[right] - prefixSum[left-1];
        return prefixSum[right];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
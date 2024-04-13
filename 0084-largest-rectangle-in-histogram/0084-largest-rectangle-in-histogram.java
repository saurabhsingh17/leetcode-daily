class Solution {
    public int largestRectangleArea(int[] heights) {
        return areaHistogram(heights,nextSmallerElementToLeft(heights),nextSmallerRight(heights));
    }
    static int areaHistogram(int[] nums, int[] nsl, int[] nsr) {
        int n = nums.length;
        int width[] = new int[n];
        int area[] = new int[n];
        int maxArea = 0;
        for(int i = 0; i < n; i++) {
            
            width[i] = nsr[i] - nsl[i] - 1;
            area[i] = width[i] * nums[i];
            if(area[i] > maxArea) maxArea = area[i];
        }

        System.out.println(Arrays.toString(width));
        System.out.println(Arrays.toString(area));
        return maxArea;

    }
    static int[] nextSmallerElementToLeft(int[] nums) {
        int[] nsl = new int[nums.length];
        int n = nums.length;
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            while (!stack.empty() && stack.peek()[0] >= nums[i]) stack.pop();
            nsl[i] = stack.isEmpty() ? -1 : stack.peek()[1];
            stack.push(new int[]{num, i});
        }
        return nsl;
    }
    static int[] nextSmallerRight(int[] nums) {
        int[] nsr = new int[nums.length];
        int n = nums.length;
        Stack<int[]> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];
            while (!stack.empty() && stack.peek()[0] >= nums[i]) stack.pop();
            nsr[i] = stack.isEmpty() ? n : stack.peek()[1];
            stack.push(new int[]{num, i});
        }
        return nsr;
    }
}
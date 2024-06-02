class Solution {
    public List<List<Integer>> combine(int n, int k) {
       int[] nums = new int[n];
       for(int i = 1; i <= n; i++){
            nums[i-1] = i;
       }        
       List<List<Integer>> ans = new ArrayList<>();
        return solve(nums, 0, ans,new ArrayList<>(),k);
    }
    List<List<Integer>> solve(int[] nums, int index, List<List<Integer>> ans, List<Integer> out,int k){
        if(index == nums.length ){
             if(out.size() == k)
             ans.add(out);
             return ans;
        }
        List<Integer> curr = new ArrayList<>(out);
        curr.add(nums[index]);
        List<Integer> currWithout = new ArrayList<>(out);

        solve(nums, index+1, ans, curr, k);
        solve(nums, index+1, ans, currWithout, k);
        return ans;
    }
}
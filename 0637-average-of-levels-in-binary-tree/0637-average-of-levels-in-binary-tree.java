/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        return avgLevelWise(root);
    }
    static List<Double> avgLevelWise(TreeNode root){
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return ans;

        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            double avg = 0;
            for(int i = 0; i < size; i++){
                if(q.peek().left != null) q.offer(q.peek().left);
                if(q.peek().right != null) q.offer(q.peek().right);
                avg += (q.poll().val);
            }
            ans.add(avg/size);

        }
        return ans;
    }
}
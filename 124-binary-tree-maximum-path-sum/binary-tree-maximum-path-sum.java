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
// class Solution {
//     int res = Integer.MIN_VALUE;
//     public int maxPathSum(TreeNode root) {
//         maxTreePathSum(root);
//         return res;
//     }
//     int maxTreePathSum(TreeNode node){
//         if(node == null) return 0;

//         int left = Math.max(0, maxTreePathSum(node.left));
//         int right = Math.max(0, maxTreePathSum(node.right));
        
//         int pathSum = left + right + node.val;
//         res = Math.max(res, pathSum);

//         return Math.max(left, right) + node.val;
//     }
// }
class Solution {
     int res=Integer.MIN_VALUE; 
    public int solve(TreeNode root){
        if(root==null) return 0;
        
        int lh=solve(root.left);
        int rh=solve(root.right);

        int op1=Math.max(lh,rh)+root.val;
        int op2=lh+rh+root.val;
        int op3=root.val;

         res=Math.max(res,Math.max(op1,Math.max(op2,op3)));
        return Math.max(op1,op3);
    }
    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        solve(root);
        return res;
    }
}
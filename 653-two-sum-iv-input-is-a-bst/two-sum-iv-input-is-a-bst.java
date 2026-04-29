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
//     public boolean findTarget(TreeNode root, int k) {
//         return check(root,k);
        
//     }
//     boolean check(TreeNode root, int target){
//         if(target==0) return true;
//         if(root==null ) return false;
//         // if(root==target) return true;
// if(target>root.val){
//         return check(root.left, target - root.val) && check(root.right,target-root.val);
// }else{
//     return check(root.left, target) && check(root.right,target);
// }
     

//     }
// }
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return check(root, root, k);
    }

    boolean check(TreeNode root, TreeNode curr, int target){
        if(curr == null) return false;

        // find complement in BST
        if(search(root, curr, target - curr.val)) return true;

        // check left or right
        return check(root, curr.left, target) || check(root, curr.right, target);
    }

    // BST search for value (avoid same node)
    boolean search(TreeNode root, TreeNode curr, int val){
        if(root == null) return false;

        if(root.val == val && root != curr) return true;

        if(val < root.val) return search(root.left, curr, val);
        else return search(root.right, curr, val);
    }
}


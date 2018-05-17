/**
Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

Note: The length of path between two nodes is represented by the number of edges between them.

Example 1:

Input:

              5
             / \
            4   5
           / \   \
          1   1   5
Output:

2
Example 2:

Input:

              1
             / \
            4   5
           / \   \
          4   4   5
Output:

2
Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int ans;
    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        helper(root);
        return ans;
    }
    
    private int helper(TreeNode curr) {
        if (curr == null) {
            return 0;
        }
        int left = helper(curr.left);
        int right = helper(curr.right);
        int left_path = 0, right_path = 0;
        if (curr.left != null && curr.left.val == curr.val) {
            left_path += left;
            ++left_path;
        }
        if (curr.right != null && curr.right.val == curr.val) {
            right_path += right;
            ++right_path;
        }
        ans = Math.max(ans, left_path + right_path);
        return Math.max(left_path, right_path);
    }

}

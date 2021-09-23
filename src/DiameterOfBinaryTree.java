// Find Diameter of a Binary Tree

import java.util.*;



// Definition of TreeNode
public class TreeNode {
    public long val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode (long x) {
        val = x;
        left = null;
        right = null;
    }
}



public class DiameterOfBinaryTree {
    static int ans=0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper_recursive(root);
        return ans;
    }
    public int helper_recursive(TreeNode root){
        if(root == null)
            return 0;
        int lh = helper_recursive(root.left);
        int rh = helper_recursive(root.right);
        ans = Math.max(ans,(lh+rh));
        return 1+Math.max(lh,rh);
    }

}
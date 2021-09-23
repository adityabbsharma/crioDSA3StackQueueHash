// Mirror a Binary Tree

class TreeNode {
    public long val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode (long x) {
        val = x;
        left = null;
        right = null;
    }
}


public class MirrorBinaryTree {
    public TreeNode mirrorBinaryTree(TreeNode root) {
        helperRecursive(root);
        return root;
    }
    public void helperRecursive(TreeNode root){
        if(root==null)
            return ;
        helperRecursive(root.left);
        helperRecursive(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}

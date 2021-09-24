// Boundary Traversal of a Binary Tree

import java.util.ArrayList;
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

public class BoundaryTraversalOfBinaryTree {

    public ArrayList<Long> binaryTreeBoundaryTraversal(TreeNode root) {
        ArrayList<Long> res = new ArrayList<>();
        if(root==null)
            return res;
        res.add(root.val);
        leftBoundary(root.left,res);
        leafNodeBoundary(root.left,res);
        leafNodeBoundary(root.right,res);
        rightBoundary(root.right,res);
        return res;
    }
    public void leftBoundary(TreeNode root,ArrayList<Long> res){
        if(root==null)
            return;
        if(root.left!=null){
            res.add(root.val);
            leftBoundary(root.left,res);
        }
        else if(root.right!=null){
            res.add(root.val);
            leftBoundary(root.right,res);
        }
    }
    public void leafNodeBoundary(TreeNode root,ArrayList<Long> res){
        if(root==null)
            return;
        leafNodeBoundary(root.left,res);
        if(root.left==null && root.right==null){
            res.add(root.val);
        }
        leafNodeBoundary(root.right,res);
    }
    public void rightBoundary(TreeNode root,ArrayList<Long> res){
        if(root==null)
            return;
        if(root.right!=null){
            leftBoundary(root.right,res);
            res.add(root.val);
        }
        else if(root.left!=null){
            leftBoundary(root.left,res);
            res.add(root.val);
        }
    }
}

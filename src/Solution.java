/*
* ZIGZAG LEVEL ORDER TRAVERSAL OF BINARY TREE USING STACK
* */


import java.util.*;
//import crio.ds.Tree.TreeNode;


// Definition of TreeNode

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
public class Solution {

//    TreeNode node;
//    int height;
//    public Solution(){}
//    public Solution(TreeNode node,int height){
//        this.node = node;
//        this.height = height;
//    }
//    public List<List<Long>>  zigzagLevelOrder(TreeNode root) {
//        Queue<Solution> q = new LinkedList<>();
//        Queue<Solution> qFinal = new LinkedList<>();
//        int flag=1;
//        q.add(new Solution(root,0));
//        List<List<Long>> list = new LinkedList<>();
//        int maxHeight=0;
//        while(!q.isEmpty()){
//            if(flag== 1){
//                flag = 2;
//                TreeNode  temp = q.peek().node;
//                System.out.println("temp.val="+temp.val);
//                qFinal.add(q.peek());
//                int height = q.remove().height;
//                System.out.println("height is="+height);
//                maxHeight = Math.max(maxHeight,height);
//                if(temp.left != null){
//                    q.add(new Solution(temp.left,height+1));
//                }
//                if(temp.right != null){
//                    q.add(new Solution(temp.right,height+1));
//                }
//            }
//            else{
//                flag = 1;
//                TreeNode  temp = q.peek().node;
//                qFinal.add(q.peek());
//                int height = q.remove().height;
//                System.out.println("height is="+height);
//                maxHeight = Math.max(maxHeight,height);
//                if(temp.right != null){
//                    q.add(new Solution(temp.right,height+1));
//                }
//                if(temp.left != null){
//                    q.add(new Solution(temp.left,height+1));
//                }
//            }
//        }
//        System.out.println("max height is"+maxHeight);
//        for(int i=0;i<maxHeight;i++){
//            List<Long> newList = new LinkedList<>();
//            list.add(newList);
//        }
//        while(!qFinal.isEmpty()){
//            Solution newSolution = qFinal.remove();
//            System.out.println("newSolution.node.val="+newSolution.node.val);
////            List<Long> subList = list.get(newSolution.height);
////            subList.add(newSolution.node.val);
//            list.get(newSolution.height).add(newSolution.node.val);
//        }
//        return list;
    public List<List<Long>>  zigzagLevelOrder(TreeNode root){
        Stack<TreeNode> currentLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        currentLevel.push(root);
        boolean leftToRight = true;
        List<List<Long>> list = new LinkedList<>();
        List<Long> subListLong = new LinkedList<>();

        while (!currentLevel.isEmpty()) {
            TreeNode node = currentLevel.pop();
            subListLong.add(node.val);
            if (leftToRight) {
                if (node.left != null) {
                    nextLevel.push(node.left);
                }
                if (node.right != null) {
                    nextLevel.push(node.right);
                }
            }
            else {
                if (node.right != null) {
                    nextLevel.push(node.right);
                }

                if (node.left != null) {
                    nextLevel.push(node.left);
                }
            }

            if (currentLevel.isEmpty()) {
                list.add(subListLong);
                subListLong = new LinkedList<>();
                leftToRight = !leftToRight;
                Stack<TreeNode> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
        return list;
    }

    public static void main(String[] args)
    {
        Solution mainSolution = new Solution();
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(7);
        tree.left.right = new TreeNode(6);
        tree.right.left = new TreeNode(5);
        tree.right.right = new TreeNode(4);

        System.out.println("ZigZag Order traversal of binary tree is");
        List<List<Long>> mainList = mainSolution.zigzagLevelOrder(tree);
        for(List<Long> list :mainList){
            for(Long newLong : list){
                System.out.print(newLong+" ");
                //System.out.println("i m here");
            }
            System.out.println();
        }
    }
}
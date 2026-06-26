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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);// offer is used to insert data in queue
        int count=0;
        while(!queue.isEmpty()){
            count++;
            int levelsize=queue.size();
            List<Integer> ans=new ArrayList<>();
            for(int i=0;i<levelsize;i++){
                TreeNode currentNode=queue.poll();//it is used for pop the element
                ans.add(currentNode.val);
                if(currentNode.left!=null)
                    queue.offer(currentNode.left);
                if(currentNode.right!=null)
                    queue.offer(currentNode.right);
            }
            if(count%2==1)
                res.add(ans);
            else
                res.add(ans.reversed());
        }
        return res;
    }
}
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
         List<Double> ans=new ArrayList<>();      
        if(root==null){
            return ans;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);// offer is used to insert data in queue

        while(!queue.isEmpty()){
            int levelsize=queue.size();
            double sum=0;
            for(int i=0;i<levelsize;i++){
                TreeNode currentNode=queue.poll();//it is used for pop the element
                sum+=currentNode.val;
                if(currentNode.left!=null)
                    queue.offer(currentNode.left);
                if(currentNode.right!=null)
                    queue.offer(currentNode.right);
            }
            ans.add(sum/levelsize);
        }
        return ans;
    }
}
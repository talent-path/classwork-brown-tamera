import javax.swing.tree.TreeNode;

public class App {
    public static void main(String[] args) {


    }
    public class TreeNode {
        int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

  int sum=0;
    public int rangeSumBST(TreeNode root, int low, int high) {

        if(root==null) return 0;
        if(root.val>=low && root.val<=high){
            sum+=root.val;
            rangeSumBST(root.right,low,high);
            rangeSumBST(root.left,low,high);


        }
        else if(root.val<low) {
            rangeSumBST(root.right,low,high);
        }
        else{
            rangeSumBST(root.left,low,high);
        }

        return sum;

        }

}

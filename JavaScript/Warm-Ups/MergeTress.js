/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root1
 * @param {TreeNode} root2
 * @return {TreeNode}
 */
var mergeTrees = function(root1, root2) {
    if(!root1 || !root2) return root1 || root2;

    root1.val+=root2.val

    root1.left=(mergeTrees(root1.left,root2.left));
    root1.right=(mergeTrees(root1.right,root2.right));

    return root1;


    // Does not giv correct answer

    // if(!root1 && !root2) return null;

    // const root3=new TreeNode((root1 ? root1.val : 0) + (root2 ? root2.val : O));
    // root3.left=mergeTrees((root1 ? root1.left : null, root2 ? root2.left : null));
    // root3.right=mergeTrees((root1 ? root1.right : null, root2 ? root2.right : null));

    // return root3;
};
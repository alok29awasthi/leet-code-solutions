/* Count Complete Tree Nodes */

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
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int size = 0;

        queue.add(root);
        while(!queue.isEmpty()) {
            size++;
            TreeNode temp = queue.poll();

            if(temp.left != null) {
                queue.add(temp.left);
            }
            if(temp.right != null) {
                queue.add(temp.right);
            }
        }

        return size;
    }
}

/*
Consider the following complete binary tree:

        1
       / \
      2   3
     / \ / \
    4  5 6  7
   /
  8

For this tree, the `countNodes` function will traverse each level using BFS and count the nodes. The queue starts with the root, and we keep adding nodes until the queue is empty.

Here's how it works step by step:

1. Initially, the queue contains the root (1), and `size` is 0.
2. We poll the root, increment `size` to 1, and enqueue its left and right children (2 and 3).
3. For the next level, we poll 2 and enqueue its children (4 and 5). Similarly, we enqueue the children of 3 (6 and 7).
4. The process continues. For the next level, we poll 4 and enqueue its child (8).
5. The traversal continues until all nodes are processed.

The final value of `size` will be the total number of nodes in the tree. In this example, the count is 8, as there are eight nodes in the complete binary tree.

The time complexity of this algorithm is less than O(n) because it stops traversing the tree as soon as it encounters a `null` node, reaching a time complexity proportional to the number of nodes in the tree.
*/

package Tester;

public class BinaryTree {

   public static class TreeNode {

        String data;
        TreeNode left;
        TreeNode right;

        TreeNode(String value)  {
            this.data = value;
            left = null;
            right = null;

        }

        public boolean isLeaf() {
            return left == null ? right == null : false;
        }
    }

    TreeNode root;

   public void preOrder()   {
       preOrder(root);
   }

   public void preOrder(TreeNode node)  {
       if (node == null)    {
           return;
       }

       preOrder(node.left);
       System.out.printf("%s ", node.data);
       preOrder(node.right);
   }
}
/*BinaryTree bt = new BinaryTree();
        BinaryTree.TreeNode root = new BinaryTree.TreeNode("1");
        bt.root = root;

        bt.root.left = new BinaryTree.TreeNode("2");
        bt.root.left.left = new BinaryTree.TreeNode("4");
        bt.root.left.left.left = new BinaryTree.TreeNode("8");
        bt.root.left.right = new BinaryTree.TreeNode("5");

        bt.root.right = new BinaryTree.TreeNode("3");
        bt.root.right.left = new BinaryTree.TreeNode("6");
        bt.root.right.right = new BinaryTree.TreeNode("7");

        bt.preOrder();
        System.out.println();*/
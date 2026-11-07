public class Solution {

    // 1. Định nghĩa lớp Node (HackerRank ẩn phần này)
    static class Node {
        int val;
        int ht;
        Node left;
        Node right;

        Node() {}

        Node(int val) {
            this.val = val;
            this.ht = 0;
        }
    }

    // 2. Hàm main để chạy và kiểm thử trên IntelliJ
    public static void main(String[] args) {
        Node root = null;
        int[] values = {3, 2, 4, 5, 6};

        for (int val : values) {
            root = insert(root, val);
        }

        System.out.println("Gốc của cây AVL hiện tại: " + root.val);
    }

    // 3. Hàm insert và các hàm hỗ trợ
    static Node insert(Node root, int val) {
        if (root == null) {
            Node node = new Node();
            node.val = val;
            node.ht = 0;
            return node;
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        } else {
            return root;
        }

        root.ht = 1 + Math.max(getHeight(root.left), getHeight(root.right));

        int balance = getBalance(root);

        if (balance > 1 && val < root.left.val) {
            return rotateRight(root);
        }

        if (balance < -1 && val > root.right.val) {
            return rotateLeft(root);
        }

        if (balance > 1 && val > root.left.val) {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }

        if (balance < -1 && val < root.right.val) {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }

        return root;
    }

    static int getHeight(Node node) {
        if (node == null) return -1;
        return node.ht;
    }

    static int getBalance(Node node) {
        if (node == null) return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    static Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.ht = 1 + Math.max(getHeight(y.left), getHeight(y.right));
        x.ht = 1 + Math.max(getHeight(x.left), getHeight(x.right));

        return x;
    }

    static Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.ht = 1 + Math.max(getHeight(x.left), getHeight(x.right));
        y.ht = 1 + Math.max(getHeight(y.left), getHeight(y.right));

        return y;
    }
}
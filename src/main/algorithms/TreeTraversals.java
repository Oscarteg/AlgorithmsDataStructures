package main.algorithms;

import main.utils.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Oscar on 08/04/2017.
 */
public class TreeTraversals {

    public static void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    public static void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public void levelOrder(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root); // add first level to queue
        int level = 1;
        while (!q.isEmpty()) {
            Node x = q.remove();
            level--;
            if (x.left != null)
                q.add(x.left);
            if (x.right != null)
                q.add(x.right);

            if (level == 0 && !q.isEmpty()) {
                level += q.size();
                System.out.println(q);
            }
        }
    }
}
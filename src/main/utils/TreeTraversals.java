package main.utils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This class is for printing all Trees that implement the Tree class.
 * <p>
 * Created by Oscar on 08/04/2017.
 */
public class TreeTraversals {

    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.print(root.getValue() + " ");
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getValue() + " ");
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.getLeft());
        System.out.print(root.getValue() + " ");
        inOrder(root.getRight());
    }

    public static void print(Node rootNode) {
        _print(rootNode, 0);
    }

    private static void _print(Node node, final int indentation) {
        if (null == node) {
            return;
        }

        final String type;
        if (indentation == 0) {
            type = "Root";
        } else {
            type = "Child";
        }

        String indent = "";
        for (int i = 0; i < indentation; i++)
            indent += "    ";

        System.out.printf("%s└── %s node with value '%s'\n", indent, type, node.getValue());

        _print(node.getLeft(), indentation + 1);
        _print(node.getRight(), indentation + 1);
    }

    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root); // add first level to queue
        int level = 1;
        while (!q.isEmpty()) {
            Node x = q.remove();
            level--;
            if (x.getLeft() != null) {
                q.add(x.getLeft());
            }
            if (x.getRight() != null) {
                q.add(x.getRight());
            }

            if (level == 0 && !q.isEmpty()) {
                level += q.size();
                System.out.println(q);
            }
        }
    }

}

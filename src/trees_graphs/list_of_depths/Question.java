package trees_graphs.list_of_depths;

//  Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth
//  (e.g., if you have a tree with depth D, you'll have D linked lists).

import helpers.TreeUtil;
import trees_graphs.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Question {
    public static void main(String[] args) {
        int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeUtil.createTreeFromArray(nodes_flattened);
        ArrayList<LinkedList<TreeNode>> list = createLevelLinkedListDFS(root);
        printResult(list);
    }

    public static void printResult(ArrayList<LinkedList<TreeNode>> result) {
        int depth = 0;
        for (LinkedList<TreeNode> entry : result) {
            Iterator<TreeNode> i = entry.listIterator();
            System.out.print("Link list at depth " + depth + ":");
            while (i.hasNext()) {
                System.out.print(" " + i.next().getData());
            }
            System.out.println();
            depth++;
        }
    }

    public static void createLevelLinkedListDFS(TreeNode treeNode, ArrayList<LinkedList<TreeNode>> list, int level) {
        if (treeNode == null) return;

        LinkedList<TreeNode> treeNodes;
        if (list.size() == level) {
            treeNodes = new LinkedList<>();
            list.add(treeNodes);
        } else {
            treeNodes = list.get(level);
        }
        treeNodes.add(treeNode);
        createLevelLinkedListDFS(treeNode.getLeft(), list, level + 1);
        createLevelLinkedListDFS(treeNode.getRight(), list, level + 1);
    }

    private static ArrayList<LinkedList<TreeNode>> createLevelLinkedListDFS(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> list = new ArrayList<>();
        createLevelLinkedListDFS(root, list, 0);
        return list;
    }

    public static ArrayList<LinkedList<TreeNode>> createLevelLinkedListBFS(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();

        // visit root
        LinkedList<TreeNode> current = new LinkedList<>();
        if (root != null)
            current.add(root);

        while (current.size() > 0) {
            result.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<>();
            for (TreeNode parent : parents) {
                if (parent.getLeft() != null) {
                    current.add(parent.getLeft());
                }
                if (parent.getRight() != null) {
                    current.add(parent.getRight());
                }
            }
        }
        return result;
    }
}

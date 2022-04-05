package Interface;

import Interface.AbstractTree;

import javax.swing.tree.TreeNode;

public class BST<E extends Comparable<E>> extends AbstractTree<E> {
    protected Interface.TreeNode<E> root;
    protected int size = 0;

    public BST() {
    }

    public BST(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            insert(objects[i]);
    }

    @Override
    public boolean insert(E e) {
        if (root == null)
            root = (Interface.TreeNode<E>) createNewNode(e); /*create a new root*/
        else {
            /*locate the parent node*/
            Interface.TreeNode parent = null;
            Interface.TreeNode current = (Interface.TreeNode) root;
            while (current != null) {
                if (e.compareTo((E) current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo((E) current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    return false; /*Duplicate node not inserted*/
            }
            if (e.compareTo((E) parent.element) < 0)
                parent.left = (Interface.TreeNode) createNewNode(e);
            else
                parent.right = (Interface.TreeNode) createNewNode(e);
        }
        size++;
        return true; /*element inserted successfully*/
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    @Override
    public int getSize() {
        return size;
    }
}
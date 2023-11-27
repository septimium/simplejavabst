package bst;

public class BST<T extends Comparable<T>>{

    public static class Node<T>{
        T value;
        BST.Node<T> left;
        BST.Node<T> right;

        Node(T value){
            this.value = value;
            right = null;
            left = null;
        }
    }

    private Node<T> root;
    
    public void insert(T val){
        root = insertRec(root, val);
    }

    public Node<T> insertRec(Node<T> root, T val){
        if (root == null){
            root = new Node<T>(val);
            return root;
        }
        if(val.compareTo(root.value) < 0){
            root.left = insertRec(root.left, val);
        }
        else if(val.compareTo(root.value) > 0){
            root.right = insertRec(root.right, val);
        }
        return root;
    }

    public boolean find(T val) {
        return findRec(root, val);
    }

    private boolean findRec(Node<T> root, T val) {
        if (root == null) {
            return false;
        }
        if (val.equals(root.value)) {
            return true;
        }
        if (val.compareTo(root.value) < 0) {
            return findRec(root.left, val);
        }
        else {
            return findRec(root.right, val);
        }
    }

    public void display() {
        inOrderTraversal(root);
    }
    public void display2() {
        preOrderTraversal(root);
    }
    public void display3() {
        postOrderTraversal(root);
    }

    private void inOrderTraversal(Node<T> node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.value);
            inOrderTraversal(node.right);
        }
    }

    private void postOrderTraversal(Node<T> node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.println(node.value);
        }
    }
    private void preOrderTraversal(Node<T> node) {
        if (node != null) {
            System.out.println(node.value);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }
}

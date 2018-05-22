public class BinarySearchTree {
    Node root;
    public static void main(String[] args){
        BinarySearchTree newTree = new BinarySearchTree();

        newTree.insert(50,100);
        newTree.insert(10,200);
        newTree.insert(15,300);
        newTree.insert(40,400);
        newTree.insert(9,700);
        newTree.insert(66,500);
        newTree.insert(12,600);
        newTree.insert(99,700);

        newTree.inOrderTraverseTree(newTree.root);
        System.out.println("***************************");
        newTree.preOrderTraverseTree(newTree.root);
        System.out.println("***************************");
        newTree.postOrderTraverseTree(newTree.root);
        System.out.println("***************************");
        System.out.println(newTree.findNode(12));


    }

    /**
     * Binary tree insert method
     * @param key The key of the node
     * @param value The value of the node
     */
    public void insert(int key, int value) {
        Node newNode = new Node(key,value);
        if(root == null){
            root = newNode;
        }else{
            Node focusNode = root;
            Node parent;
            while(true){
                parent = focusNode;
                if(key < focusNode.key){
                    focusNode = focusNode.left;
                    if(focusNode == null){
                        parent.left = newNode;
                        return;
                    }
                }else{
                    focusNode = focusNode.right;
                    if(focusNode == null){
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }

    }

    /**
     * This method will print all the nodes in order
     * Inorder traversal
     * @param focusNode The current node which is iterating or the root node
     */
    public void inOrderTraverseTree(Node focusNode) {
        if(focusNode != null){
            inOrderTraverseTree(focusNode.left);
            System.out.println(focusNode);
            inOrderTraverseTree(focusNode.right);

        }
    }

    /**
     * PreOrder traversal
     * @param focusNode The current node which is iterating or the root node
     */
    public void preOrderTraverseTree(Node focusNode) {
        if(focusNode != null){
            System.out.println(focusNode);
            preOrderTraverseTree(focusNode.left);
            preOrderTraverseTree(focusNode.right);

        }
    }

    /**
     * PostOrder traversal
     * @param focusNode The current node which is iterating or the root node
     */
    public void postOrderTraverseTree(Node focusNode) {
        if(focusNode != null){
            postOrderTraverseTree(focusNode.left);
            postOrderTraverseTree(focusNode.right);
            System.out.println(focusNode);


        }
    }


    /**
     * Binary tree search method
     * @param key The key associated withe the value to find
     * @return will return the value assocoiated with the searched key
     */
    public Node findNode(int key){
        Node focusNode = root;
        while(focusNode.key != key){
            if(key < focusNode.key){
                focusNode = focusNode.left;
            }else {
                focusNode = focusNode.right;
            }
            if(focusNode == null){
                return null;
            }
        }
        return focusNode;
    }

}


/**
 * Node class
 */
class Node {

    int key;
    Node left;
    Node right;
    int data;

    /**
     * @param data new node value of the Binary tree
     * overloaded constructor
     */
    public Node(int key, int data) {
        this.key = key;
        this.data = data;
    }

    public String toString(){
        return data+" has a key of "+key;
    }

}


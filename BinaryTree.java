import java.util.ArrayList;

/**
 * Class that represents a full binary tree
 * @see Node
 */
public class BinaryTree{
    private Node root = null;

    /**
     * Method to add data to the binary tree
     * @param newData The data to insert into the binary tree
     */
    public void insert(String newData){
        Node newNode = new Node(newData);
        if(root == null){
            root = newNode;
        }else{
            Node parent = null;
            Node current = newNode;
            boolean searching = true;
            do{
                parent = current;
                if(newNode.compareTo(current) <= 0){
                    current = current.left;
                    if(current == null){
                        parent.left = newNode;
                        searching = false;
                    }
                }else{
                    current = current.right;
                    if(current == null){
                        parent.right = newNode;
                        searching = false;
                    }
                }
            }while(searching);
        }
    }

    /**
     * Method to test if a node is in the binary tree
     * @param n The node to check
     * @return A boolean representing if the node is in the binary tree
     */
    public boolean in(Node n){
        if(root == null){
            return false;
        }
        Node current = root;
        while(!current.equals(n)){
            if(n.compareTo(current) <= 0){
                current = current.left;
            }else{
                current = current.right;
            }
            if(current == null){
                return false;
            }
        }
        return true;
    }

    /**
     * A method that finds the lowest value node in the tree
     * @return The node that has the lowest value
     */
    public Node min(){
        if(root == null){
            return null;
        }
        Node current = root;
        while(current.left != null){
            current = current.left;
        }
        return current;
    }

    /**
     * A method that finds the highest value node in the tree
     * @return The node that has the highest value
     */
    public Node max(){
        if(root == null){
            return null;
        }
        Node current = root;
        while(current.right != null){
            current = current.right;
        }
        return current;
    }

    /**
     * A method that preordered traverses the tree
     * @return The array of all the data in the tree preordered
     */
    public Node[] preorder(){
        return preorder(root);
    }

    /**
     * A method that preordered traverses a subtree
     * @param n The subtree to return the data of
     * @return The array of all the data in the sub-tree
     */
    public static Node[] preorder(Node n){
        if(n == null){
            return null;
        }
        ArrayList<Node> result = new ArrayList<Node>();
        result.add(n);
        if(n.left != null){
            for(Node i: preorder(n.left)){
                result.add(i);
            }
        }
        if(n.right != null){
            for(Node i: preorder(n.right)){
                result.add(i);
            }
        }
        Node[] end = new Node[result.size()];
        for(int i = 0; i < result.size(); i++){
            end[i] = result.get(i);
        }
        return end;
    }

    /**
     * A method that traverses the tree in order
     * @return The array of all the data in the tree
     */
    public Node[] inorder(){
        return inorder(root);
    }

    /**
     * A method that traverses a subtree in order
     * @param n The sub-tree to traverse
     * @return The array of all the data in the subtree
     */
    public static Node[] inorder(Node n){
        if(n == null){
            return null;
        }
        ArrayList<Node> result = new ArrayList<Node>();
        if(n.left != null){
            for(Node i: preorder(n.left)){
                result.add(i);
            }
        }
        result.add(n);
        if(n.right != null){
            for(Node i: preorder(n.right)){
                result.add(i);
            }
        }
        Node[] end = new Node[result.size()];
        for(int i = 0; i < result.size(); i++){
            end[i] = result.get(i);
        }
        return end;
    }

    /**
     * A method that postorder traverses the tree
     * @return The array of all the data in the tree
     */
    public Node[] postorder(){
        return postorder(root);
    }

    /**
     * A method that postorder traverses a subtree
     * @param n The subtree to traverse
     * @return The array of all the data in the subtree
     */
    public static Node[] postorder(Node n){
        if(n == null){
            return null;
        }
        ArrayList<Node> result = new ArrayList<Node>();
        if(n.left != null){
            for(Node i: preorder(n.left)){
                result.add(i);
            }
        }
        if(n.right != null){
            for(Node i: preorder(n.right)){
                result.add(i);
            }
        }
        result.add(n);
        Node[] end = new Node[result.size()];
        for(int i = 0; i < result.size(); i++){
            end[i] = result.get(i);
        }
        return end;
    }
}

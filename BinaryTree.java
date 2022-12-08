import java.util.ArrayList;

public class BinaryTree{
    private Node root = null;

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

    public boolean in(Node n){
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

    public Node min(){
        Node current = root;
        while(current.left != null){
            current = current.left;
        }
        return current;
    }

    public Node max(){
        Node current = root;
        while(current.right != null){
            current = current.right;
        }
        return current;
    }

    public Node[] preorder(){
        return preorder(root);
    }

    public static Node[] preorder(Node n){
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
}

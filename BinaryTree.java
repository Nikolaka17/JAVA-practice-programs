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

    public Node search(){
        Node current = root;
    }

    public Node min(){

    }

    public Node max(){

    }
}

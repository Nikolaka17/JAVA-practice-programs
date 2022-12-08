public class Node implements Comparable<Node>{
    private String data;
    public Node left = null;
    public Node right = null;

    public Node(String s){
        data = s;
    }

    public String getData(){
        return data;
    }

    @Override
    public int compareTo(Node n){
        return data.compareTo(n.getData());
    }

    @Override
    public boolean equals(Object o){
        return data.equals(((Node) o).data);
    }
}

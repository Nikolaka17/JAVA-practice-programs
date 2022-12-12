/**
 * A class that holds a specific node of a binary tree
 * @see BinaryTree
 */
public class Node implements Comparable<Node>{
    private String data;
    public Node left = null;
    public Node right = null;

    /**
     * Constructor that sets the stored data
     * @param s The data to store in the node
     */
    public Node(String s){
        data = s;
    }

    /**
     * Accessor for the instance variable data
     * @return The value stored in 'data'
     */
    public String getData(){
        return data;
    }

    /**
     * Overriden method to compare different nodes
     * @param n The node to compare to
     * @return An integer, 1 if n is greater, 0 if n is equal, -1 if n is lesser
     */
    @Override
    public int compareTo(Node n){
        int l1 = data.length();
        int l2 = n.getData().length();
        int lmin = Math.min(l1, l2);

        for(int i = 0; i < lmin; i++){
            int char1 = (int) data.charAt(i);
            int char2 = (int) n.getData().charAt(i);

            if(char1 != char2){
                return char1 - char2;
            }
        }

        if(l1 != l2){
            return l1 - l2;
        }

        return 0;
    }

    /**
     * overriden method to check if nodes are equal
     * @param o A node to compare to
     * @return A boolean representing if the data of the two nodes is equal
     */
    @Override
    public boolean equals(Object o){
        return data.equals(((Node) o).getData());
    }
}

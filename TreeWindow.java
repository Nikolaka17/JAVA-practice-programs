import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridLayout;

public class TreeWindow{
	
	public static void main(String[] args){
		JFrame window = new JFrame("Binary Tree");
		
		JButton addButton = new JButton("Add an item");
		JButton searchButton = new JButton("Search for an item");
		JButton minButton = new JButton("Find min");
		JButton maxButton = new JButton("Find max");
		JButton inorderButton = new JButton("Inorder traversal");
		JButton preorderButton = new JButton("Preorder traversal");
		JButton postorderButton = new JButton("Postorder traversal");
		
		JTextField addField = new JTextField(5);
		JTextField searchField = new JTextField(5);

        BinaryTree tree = new BinaryTree();

        window.setLayout(new GridLayout(7,2, 5, 20));
        window.add(addField);
        window.add(addButton);
        window.add(searchField);
        window.add(searchButton);
        window.add(new JLabel());
        window.add(minButton);
        window.add(new JLabel());
        window.add(maxButton);
        window.add(new JLabel());
        window.add(inorderButton);
        window.add(new JLabel());
        window.add(preorderButton);
        window.add(new JLabel());
        window.add(postorderButton);

        window.setSize(500, 300);
        window.setVisible(true);
	}
}

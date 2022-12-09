import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JTextField;

public class TreeWindow{
	
	public static void main(String[] args){
		JFrame window = new JFrame("Binary Tree");
		
		JButton addButton = new JButton("Add an item");
		JButton searchButton = new JButton("Search for an item");
		JButton minButton = new JButton("Find min");
		JButton maxButton = new JButton("Find max");
		JButton inorderButton = new JButton("Inorder traversal");
		JButton preorderTraversal = new JButton("Preorder traversal");
		JButton postorderTraversal = new JButton("Postorder traversal");
		
		JTextField addField = new JTextField(5);
		JTextField searchField = new JTextField(5);
	}
}

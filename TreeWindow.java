import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        addButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                if(addField.getText() != null && !addField.getText().equals("")){
                    tree.add(addField.getText());
                    JOptionPane.showMessageDialog(window, addField.getText() + " has been added to the tree", "Item added", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(window, "No value given", "Error", JOptionPane.ERROR_MESSAGE);
                }
                addField.setText("");
            }
        });
        searchButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                if(searchField.getText() != null && !searchField.getText().equals("")){
                    if(tree.in(new Node(searchField.getText()))){
                        JOptionPane.showMessageDialog(window, searchField.getText() + " was found in the tree", "Item found", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(window, searchField.getText() + " was not found in the tree", "Item not found", JOptionPane.INFORMATION_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(window, "No value given", "Error", JOptionPane.ERROR_MESSAGE);
                }
                searchField.setText("");
            }
        });
        minButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                JOptionPane.showMessageDialog(window, tree.min().getData() + " has the lowest value of the tree", "Min", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        maxButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                JOptionPane.showMessageDialog(window, tree.max().getData() + " has the highest value of the tree", "Max", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        inorderButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                StringBuilder result = new StringBuilder();
                Node[] nodes = tree.inorder();
                for(Node n: nodes){
                    result = result.append(n.getData());
                    result = result.append("\n");
                }
                JOptionPane.showMessageDialog(window, result, "Inorder", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        preorderButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                StringBuilder result = new StringBuilder();
                Node[] nodes = tree.preorder();
                for(Node n: nodes){
                    result = result.append(n.getData());
                    result = result.append("\n");
                }
                JOptionPane.showMessageDialog(window, result, "Preorder", JOptionPane.INFORMATION_MESSAGE);
            }
        });
       postorderButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                StringBuilder result = new StringBuilder();
                Node[] nodes = tree.postorder();
                for(Node n: nodes){
                    result = result.append(n.getData());
                    result = result.append("\n");
                }
                JOptionPane.showMessageDialog(window, result, "Postorder", JOptionPane.INFORMATION_MESSAGE);
            }
        });

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
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
	}
}

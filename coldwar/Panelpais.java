package coldwar2;



import javax.swing.*;

public class Panelpais extends JPanel{

	JButton button;
	public Panelpais(){

		final JFrame parent = new JFrame();
		button = new JButton();

		button.setText("Click me to show dialog!");
		parent.add(button);
		parent.pack();
		parent.setVisible(true);

		button.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				String name = JOptionPane.showInputDialog(parent,
						"What is your name?", null);
			}
		});
	}
}


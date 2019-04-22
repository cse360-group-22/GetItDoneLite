package proj;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Panel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.BoxLayout;
import javax.swing.JMenuItem;
import java.awt.Label;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.TextArea;
import java.awt.Button;
import javax.swing.JCheckBox;

public class TeamProject360 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		ArrayList<Entry> entries = new ArrayList<Entry>();
		
		//Example of saving to file
		/*entries.add(new Entry(1, "This is a description", "01/01/2000"));
		entries.add(new Entry(0, "Do this today", "01/02/2004"));
		entries.add(new Entry(2, "Test Description", "06/01/2010"));
		entries.add(new Entry(2, "This is a description", "08/06/2010"));
		FileLoader.save("data.txt", entries);*/
		
		//Example of loading from file
		entries = FileLoader.load("data.txt");
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeamProject360 frame = new TeamProject360();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TeamProject360() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JSeparator separator = new JSeparator();
		
		JButton btnNewButton = new JButton("Add");
		
		JButton btnSave = new JButton("Save");
		
		JButton btnRestore = new JButton("Restore");
		
		JButton btnPrint = new JButton("Print");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Sort By:", "Ex"}));
		
		Panel panel = new Panel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnNewButton)
									.addGap(6)
									.addComponent(btnSave)
									.addGap(5)
									.addComponent(btnRestore)
									.addGap(5)
									.addComponent(btnPrint)
									.addPreferredGap(ComponentPlacement.RELATED, 360, Short.MAX_VALUE)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(separator, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton)
								.addComponent(btnSave)
								.addComponent(btnRestore)
								.addComponent(btnPrint)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(null);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Priority    Date Started     Date Finished     Description     ");
		mntmNewMenuItem.setBounds(12, 12, 387, 19);
		panel.add(mntmNewMenuItem);
		
		Button button = new Button("Complete");
		button.setBounds(484, 12, 86, 23);
		panel.add(button);
		
		Button button_1 = new Button("Edit\n");
		button_1.setBounds(577, 12, 86, 23);
		panel.add(button_1);
		
		Button button_2 = new Button("Delete");
		button_2.setBounds(670, 12, 86, 23);
		panel.add(button_2);
		contentPane.setLayout(gl_contentPane);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}

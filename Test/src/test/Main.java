package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import java.awt.List;
import javax.swing.JMenuBar;
import javax.swing.JSlider;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Main extends JFrame {

	private JPanel contentPane;
	private static DefaultListModel list1 = new DefaultListModel();
	public static DefaultListModel model = new DefaultListModel();
	public static JList list_1 = new JList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		ArrayList<Entry> entries = new ArrayList<Entry>();
		
		/*//Example of saving to file
		entries.add(new Entry(1, "This is a description", "01/01/2000"));
		entries.add(new Entry(0, "Do this today", "01/02/2004"));
		entries.add(new Entry(2, "Test Description", "06/01/2010"));
		entries.add(new Entry(2, "This is a description", "08/06/2010"));
		FileLoader.save("data.txt", entries);*/
		
		//Example of loading from file
		/*entries = FileLoader.load("data.txt");*/

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 995, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//*************************************************************ADD*********************************
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddGUI add = new AddGUI();
				add.setVisible(true);
			}
		});
		//************************************************************START OVER***************************
		JButton btnSave = new JButton("Start Over");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				for(int ii = 0; ii < ArrList.entries.size();ii++) {
					if(ArrList.entries.size() == 0) {
						return;
					}
					else {
					model.removeAllElements();
					ArrList.entries.removeAll(ArrList.entries);
					ArrList.finished.removeAll(ArrList.finished);
					}
				}
			}
		});
		//*****************************************************SAVE****************************************
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FileLoader.save("data.txt", ArrList.entries);
				SaveGUI save = new SaveGUI();
				save.setVisible(true);
			}
		});
		
		JLabel lblPriority = new JLabel("Priority         Status               Description                                  Date Started:        Due Date:      Date Finished:\n");
		//*******************************************************RESTORE***********************************
		JButton btnRestore = new JButton("Restore");
		btnRestore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(ArrList.entries.size());
			}
		});
		/*btnRestore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ArrList.entries.size() == 0) {
					return;
				}
				for(int ii = 0; ii < 5; ii++) {
					System.out.println("Size: " + ArrList.entries.get(ii));
					Main.model.addElement(ArrList.entries.get(ii));
					Main.list_1.setModel(Main.model);
				}
				ArrList.entries = FileLoader.load("data.txt");
			}
		});*/
		//**************************************************************************SORT*******************
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Priority", "Due Date", "Status", "Description"}));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//int ii = ArrList.entries.size() - 1;
				String selected = (String) comboBox.getSelectedItem();
				//System.out.println(selected);
				model.removeAllElements();
				for(int ii = 0; ii < ArrList.entries.size(); ii++) {
					GUIFunctions.SortDisplay(ArrList.entries, selected);
					Main.model.addElement(ArrList.entries.get(ii));
					Main.list_1.setModel(Main.model);
				}
			}
		});
		
		
		//******************************************************PRINT************************************
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				PrintGUI print = new PrintGUI();
				print.setVisible(true);
				
			}
		});
		//*****************************************************COMPLETE************************************
		JButton btnComplete = new JButton("Complete");
		btnComplete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditGUI.status = Entry.STATUS_FINISHED;
				if(ArrList.entries.size() == 0) {
					return;
				}
				int index = list_1.getSelectedIndex();
				ArrList.finished.add(ArrList.entries.get(index));
				ArrList.entries.remove(index);
				model.remove(index);
			}
		});
		//****************************************************EDIT*****************************************
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditGUI change = new EditGUI();
				change.setVisible(true);
			}
		});
		
		JLabel lblSortBy = new JLabel("Sort By:");

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(32, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnAdd)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEdit)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnComplete)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRestore)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPrint))
						.addComponent(lblPriority)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(625)
							.addComponent(btnSave))
						.addComponent(list_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 817, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSortBy))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEdit)
						.addComponent(btnComplete)
						.addComponent(btnNewButton)
						.addComponent(btnRestore)
						.addComponent(btnPrint)
						.addComponent(btnAdd))
					.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPriority)
						.addComponent(lblSortBy))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(list_1, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSave)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}

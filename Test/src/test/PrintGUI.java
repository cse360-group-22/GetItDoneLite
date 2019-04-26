package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;

public class PrintGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrintGUI frame = new PrintGUI();
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
	public PrintGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 722, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblIncomplete = new JLabel("Incomplete");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblComplete = new JLabel("Complete");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel lblFormatForTask = new JLabel("Format for Task as Follows (Priority, Status, Description, Date Started, Date Due, and Date Finished).");
		lblFormatForTask.setForeground(Color.RED);
		lblFormatForTask.getColorModel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblFormatForTask))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(293)
							.addComponent(lblIncomplete)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE))
					.addGap(50))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(300)
					.addComponent(lblComplete)
					.addContainerGap(347, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addComponent(lblFormatForTask)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblIncomplete)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblComplete)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(41, Short.MAX_VALUE))
		);
		
		JList list = new JList();
		scrollPane_1.setViewportView(list);
		contentPane.setLayout(gl_contentPane);
		
		JList list_1 = new JList();
		scrollPane.setViewportView(list_1);
		
		
		DefaultListModel model = new DefaultListModel();
		DefaultListModel model1 = new DefaultListModel();
		
		if(ArrList.entries.size() + 1 == 0) {
			return;
		}
		
		if(ArrList.finished.size() + 1 == 0) {
			return;
		}
		
		for(int ii = 0; ii < ArrList.entries.size(); ii++) {
			EditGUI.status = Entry.STATUS_FINISHED;
			model.addElement(ArrList.entries.get(ii).toString1());
			list_1.setModel(model);
		}
		
		for(int ii = 0; ii < ArrList.finished.size(); ii++) {
			EditGUI.status = Entry.STATUS_FINISHED;
			model1.addElement(ArrList.finished.get(ii).toString1());
			list.setModel(model1);
		}
	}

}

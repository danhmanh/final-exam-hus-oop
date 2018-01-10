package p;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import b.StudentB;
import b.UserB;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private StudentB studentB ; 
	private UserB userB ; 
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnDelete;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public void initModel() {
		studentB = new StudentB() ; 
		try {
			DefaultTableModel model = studentB.getAllStudent() ;
			table.setModel(model);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnUser = new JMenu("User");
		menuBar.add(mnUser);
		
		JMenuItem mntmLogin = new JMenuItem("Login");
		mntmLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LoginDialog loginDialog = new LoginDialog(MainFrame.this) ; 
				loginDialog.setVisible(true);
				userB = new UserB() ; 
				try {
					boolean flag = userB.checkLogin(loginDialog.getTfUsername().getText(), loginDialog.getTfPassword().getText()) ;
					if(flag) {
						setEnabledButton(flag);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
				
			}
		});
		mnUser.add(mntmLogin);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentB  = new StudentB() ; 
				Dialog dialog = new Dialog(MainFrame.this) ;
				dialog.setVisible(true);
				try {
					studentB.addStudent(dialog.getTfName().getText(), Double.parseDouble(dialog.getTfScore().getText()), dialog.getTfGender().getText()) ;
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					initModel() ; 
				}
			}
		});
		panel.add(btnAdd);
		
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentB = new StudentB() ; 
				Dialog dialog = new Dialog(MainFrame.this) ; 
//				dialog.getTfName.setText(table.getValueAt(table.getSelectedRow() , 2));
				dialog.getTfName().setText((String)table.getValueAt(table.getSelectedRow(), 1)); 
				dialog.getTfScore().setText((String) table.getValueAt(table.getSelectedRow(), 2));
				dialog.getTfGender().setText((String) table.getValueAt(table.getSelectedRow(), 3));
				
				dialog.setVisible(true);
				
				try {
					studentB.updateStudent((String) table.getValueAt(table.getSelectedRow(), 0), dialog.getTfName().getText(), Double.parseDouble(dialog.getTfScore().getText()), dialog.getTfGender().getText()) ;
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					initModel() ; 
				}
			}
		});
		panel.add(btnEdit);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentB = new StudentB()  ; 
				try {
					studentB.deleteStudent((String) table.getValueAt(table.getSelectedRow(), 0)) ;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					initModel() ; 
				}
			}
		});
		panel.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		initModel() ; 
		setEnabledButton(false);
	}
	
	private void setEnabledButton(boolean flag) {
		btnAdd.setEnabled(flag);
		btnDelete.setEnabled(flag);
		btnEdit.setEnabled(flag);
	}

}

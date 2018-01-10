package p;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class LoginDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfUsername;
	private JPasswordField tfPassword;


	public LoginDialog(JFrame parent) {
		super(parent , ""  , true) ; 
		setBounds(100, 100, 336, 235);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][grow]", "[][]"));
		{
			JLabel lblUsername = new JLabel("Username");
			contentPanel.add(lblUsername, "cell 0 0,alignx trailing");
		}
		{
			tfUsername = new JTextField();
			contentPanel.add(tfUsername, "cell 1 0,growx");
			tfUsername.setColumns(10);
		}
		{
			JLabel lblPassword = new JLabel("Password");
			contentPanel.add(lblPassword, "cell 0 1,alignx trailing");
		}
		{
			tfPassword = new JPasswordField();
			contentPanel.add(tfPassword, "cell 1 1,growx");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				buttonPane.add(cancelButton);
			}
		}
	}


	public JTextField getTfUsername() {
		return tfUsername;
	}


	public void setTfUsername(JTextField tfUsername) {
		this.tfUsername = tfUsername;
	}


	public JPasswordField getTfPassword() {
		return tfPassword;
	}


	public void setTfPassword(JPasswordField tfPassword) {
		this.tfPassword = tfPassword;
	}

}

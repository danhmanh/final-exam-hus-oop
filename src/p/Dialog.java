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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class Dialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfName;
	private JTextField tfScore;
	private JTextField tfGender;


	public JTextField getTfName() {
		return tfName;
	}


	public void setTfName(JTextField tfName) {
		this.tfName = tfName;
	}


	public JTextField getTfScore() {
		return tfScore;
	}


	public void setTfScore(JTextField tfScore) {
		this.tfScore = tfScore;
	}


	public JTextField getTfGender() {
		return tfGender;
	}


	public void setTfGender(JTextField tfGender) {
		this.tfGender = tfGender;
	}


	/**
	 * Create the dialog.
	 */
	public Dialog(JFrame parent) {
		super(parent , "" , true) ; 
		setBounds(100, 100, 333, 209);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][grow]", "[][][]"));
		{
			JLabel lblName = new JLabel("Name");
			contentPanel.add(lblName, "cell 0 0,alignx trailing");
		}
		{
			tfName = new JTextField();
			contentPanel.add(tfName, "cell 1 0,growx");
			tfName.setColumns(10);
		}
		{
			JLabel lblScore = new JLabel("Score");
			contentPanel.add(lblScore, "cell 0 1,alignx trailing");
		}
		{
			tfScore = new JTextField();
			contentPanel.add(tfScore, "cell 1 1,growx");
			tfScore.setColumns(10);
		}
		{
			JLabel lblGender = new JLabel("Gender");
			contentPanel.add(lblGender, "cell 0 2,alignx trailing");
		}
		{
			tfGender = new JTextField();
			contentPanel.add(tfGender, "cell 1 2,growx");
			tfGender.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
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
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				buttonPane.add(cancelButton);
			}
		}
	}

}

package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class dlgThayDoiMatKhau extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Create the frame.
	 */
	public dlgThayDoiMatKhau(JFrame frmTrangChu) {
		super(frmTrangChu, true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thay đổi mật khẩu");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(84, 10, 285, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nhập mật khẩu cũ:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(31, 76, 135, 19);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nhập mật khẩu mới:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(31, 155, 144, 19);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Xác nhận mật khẩu:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(31, 228, 144, 19);
		contentPane.add(lblNewLabel_1_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(187, 73, 236, 30);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(187, 152, 236, 30);
		contentPane.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(187, 225, 236, 30);
		contentPane.add(passwordField_2);
		
		JLabel lblNewLabel_2 = new JLabel("Vui lòng nhập mật khẩu cũ");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setBounds(187, 113, 165, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Vui lòng nhập mật khẩu mới");
		lblNewLabel_2_1.setForeground(Color.RED);
		lblNewLabel_2_1.setBounds(187, 192, 165, 13);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Mật khẩu không khớp");
		lblNewLabel_2_2.setForeground(Color.RED);
		lblNewLabel_2_2.setBounds(187, 265, 165, 13);
		contentPane.add(lblNewLabel_2_2);
		
		JButton btnNewButton = new JButton("Xác nhận");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(104, 306, 126, 40);
		contentPane.add(btnNewButton);
		
		JButton btnHy = new JButton("Hủy");
		btnHy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlgThayDoiMatKhau.this.dispose();
			}
		});
		btnHy.setBackground(new Color(255, 255, 255));
		btnHy.setForeground(new Color(0, 0, 0));
		btnHy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnHy.setBounds(265, 306, 126, 40);
		contentPane.add(btnHy);
	}
}

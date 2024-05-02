package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class frmThongTinKhachHang extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					frmThongTinKhachHang frame = new frmThongTinKhachHang();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public frmThongTinKhachHang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 816, 508);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã khách hàng:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(50, 50, 144, 23);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(240, 52, 308, 32);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblGiiTnh = new JLabel("Giới tính");
		lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGiiTnh.setBounds(50, 115, 144, 23);
		panel.add(lblGiiTnh);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại:");
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSinThoi.setBounds(50, 184, 144, 23);
		panel.add(lblSinThoi);
		
		JLabel lblNewLabel_2_1 = new JLabel("Điểm tích lũy:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(50, 257, 144, 23);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Ngày thêm:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_2.setBounds(50, 334, 144, 23);
		panel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("0");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_3.setBounds(240, 257, 144, 23);
		panel.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("29-04-2024");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_4.setBounds(240, 334, 144, 23);
		panel.add(lblNewLabel_2_4);
		
		JButton btnNewButton = new JButton("Xác nhận");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(278, 402, 111, 32);
		panel.add(btnNewButton);
		
		JButton btnng = new JButton("Đóng");
		btnng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnng.setBounds(438, 402, 111, 32);
		panel.add(btnng);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(240, 113, 308, 32);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(240, 175, 308, 32);
		panel.add(textField_2);
	}

}

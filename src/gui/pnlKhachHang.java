package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pnlKhachHang extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	/**
	 * Create the frame.
	 */
	public pnlKhachHang() {
		setBackground(new Color(205,201,195,255));
		setBounds(10, 58, 1491, 697);
		setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(56, 10, 383, 56);
		add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(27, 19, 99, 27);
		panel_2.add(btnNewButton);
		
		JButton btnCpNht = new JButton("Cập nhật");
		btnCpNht.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCpNht.setBounds(158, 19, 131, 27);
		panel_2.add(btnCpNht);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Danh s\u00E1ch kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(133, 73, 1127, 614);
		add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 94, 1107, 510);
		panel_3.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 20, 1107, 64);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nhập mã KH:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 10, 174, 19);
		panel_4.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(20, 32, 208, 20);
		panel_4.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Tìm");
		btnNewButton_1.setBounds(254, 31, 60, 21);
		panel_4.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Từ ngày:");
		lblNewLabel_1.setBounds(392, 16, 132, 13);
		panel_4.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(402, 33, 216, 19);
		panel_4.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(661, 33, 216, 19);
		panel_4.add(textField_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Đến ngày:");
		lblNewLabel_1_1.setBounds(651, 16, 120, 13);
		panel_4.add(lblNewLabel_1_1);
		
		JButton btnNewButton_2 = new JButton("Lọc");
		btnNewButton_2.setBounds(894, 31, 60, 21);
		panel_4.add(btnNewButton_2);
	}

}

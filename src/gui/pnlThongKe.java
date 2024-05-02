package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pnlThongKe extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JFrame frmTrangChu;
	/**
	 * Create the frame.
	 */
	public pnlThongKe(JFrame frmTrangChu) {
		this.frmTrangChu = frmTrangChu;
		setBackground(new Color(205,201,195,255));
		setBounds(10, 58, 1491, 697);
		setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 64, 1471, 258);
		add(panel_1);
		panel_1.setLayout(null);
		
		JPanel pnlTuanNay = new JPanel();
		pnlTuanNay.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(64, 128, 128), null, null, null));
		pnlTuanNay.setBounds(541, 0, 412, 258);
		panel_1.add(pnlTuanNay);
		pnlTuanNay.setLayout(null);
		
		JLabel lblTunNy = new JLabel("Tuần này");
		lblTunNy.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblTunNy.setBounds(125, 10, 164, 51);
		pnlTuanNay.add(lblTunNy);
		
		JLabel lblNewLabel_3_1 = new JLabel("500.000.000đ");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_3_1.setBounds(112, 71, 186, 65);
		pnlTuanNay.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_3 = new JLabel("Số hóa đơn:");
		lblNewLabel_4_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_3.setBounds(39, 179, 107, 19);
		pnlTuanNay.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_4_1_2 = new JLabel("10");
		lblNewLabel_4_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_1_2.setBounds(187, 179, 100, 19);
		pnlTuanNay.add(lblNewLabel_4_1_2);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Số sản phẩm:");
		lblNewLabel_4_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_2_1.setBounds(39, 208, 107, 19);
		pnlTuanNay.add(lblNewLabel_4_2_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("10");
		lblNewLabel_4_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_1_1_1.setBounds(187, 208, 100, 19);
		pnlTuanNay.add(lblNewLabel_4_1_1_1);
		
		JPanel pnlHomNay = new JPanel();
		pnlHomNay.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(64, 128, 128), null, null, null));
		pnlHomNay.setBounds(42, 0, 412, 258);
		panel_1.add(pnlHomNay);
		pnlHomNay.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hôm nay");
		lblNewLabel.setBounds(130, 10, 164, 51);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		pnlHomNay.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("500.000.000đ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(118, 73, 186, 65);
		pnlHomNay.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Số hóa đơn:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(27, 177, 107, 19);
		pnlHomNay.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("10");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_1.setBounds(175, 177, 100, 19);
		pnlHomNay.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Số sản phẩm:");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_2.setBounds(27, 206, 107, 19);
		pnlHomNay.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("10");
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_1_1.setBounds(175, 206, 100, 19);
		pnlHomNay.add(lblNewLabel_4_1_1);
		
		JPanel pnlThangNay = new JPanel();
		pnlThangNay.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnlThangNay.setBounds(1033, 0, 412, 258);
		panel_1.add(pnlThangNay);
		pnlThangNay.setLayout(null);
		
		JLabel lblThngNy = new JLabel("Tháng này");
		lblThngNy.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblThngNy.setBounds(131, 10, 209, 51);
		pnlThangNay.add(lblThngNy);
		
		JLabel lblNewLabel_3_2 = new JLabel("500.000.000đ");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_3_2.setBounds(131, 71, 186, 65);
		pnlThangNay.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_4_4 = new JLabel("Số hóa đơn:");
		lblNewLabel_4_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_4.setBounds(30, 172, 107, 19);
		pnlThangNay.add(lblNewLabel_4_4);
		
		JLabel lblNewLabel_4_1_3 = new JLabel("10");
		lblNewLabel_4_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_1_3.setBounds(178, 172, 100, 19);
		pnlThangNay.add(lblNewLabel_4_1_3);
		
		JLabel lblNewLabel_4_2_2 = new JLabel("Số sản phẩm:");
		lblNewLabel_4_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_2_2.setBounds(30, 201, 107, 19);
		pnlThangNay.add(lblNewLabel_4_2_2);
		
		JLabel lblNewLabel_4_1_1_2 = new JLabel("10");
		lblNewLabel_4_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_1_1_2.setBounds(178, 201, 100, 19);
		pnlThangNay.add(lblNewLabel_4_1_1_2);
		
		JButton btnNewButton = new JButton("Thống kê theo ca");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlgThongKeTheoCa dlgThongKe = new dlgThongKeTheoCa(frmTrangChu);
				dlgThongKe.setLocationRelativeTo(frmTrangChu);
				dlgThongKe.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(1292, 10, 171, 33);
		add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "T\u00F9y ch\u1EC9nh", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 331, 1471, 356);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Từ ngày:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(37, 44, 90, 25);
		panel_2.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(37, 79, 296, 25);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(37, 177, 296, 25);
		panel_2.add(textField_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Đến ngày:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(37, 142, 135, 25);
		panel_2.add(lblNewLabel_1_1);
		
		JButton btnNewButton_1 = new JButton("Thống kê");
		btnNewButton_1.setBounds(201, 260, 128, 39);
		panel_2.add(btnNewButton_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(64, 128, 128), null, null, null));
		panel_3.setBounds(404, 22, 1077, 332);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(null, "S\u1EA3n ph\u1EA9m b\u00E1n ch\u1EA1y", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(409, 10, 642, 332);
		panel_3.add(panel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 622, 300);
		panel_4.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel pnlTuyChinh = new JPanel();
		pnlTuyChinh.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(64, 128, 128), null, null, null));
		pnlTuyChinh.setBounds(10, 10, 389, 312);
		panel_3.add(pnlTuyChinh);
		pnlTuyChinh.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("29/04/2024");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(22, 10, 146, 51);
		pnlTuyChinh.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("30/04/2024");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2_2.setBounds(204, 10, 172, 51);
		pnlTuyChinh.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("-");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2_1.setBounds(173, 10, 21, 51);
		pnlTuyChinh.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("500.000.000đ");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_3_1_1.setBounds(101, 87, 186, 65);
		pnlTuyChinh.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_4_5 = new JLabel("Số hóa đơn:");
		lblNewLabel_4_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_5.setBounds(10, 242, 107, 19);
		pnlTuyChinh.add(lblNewLabel_4_5);
		
		JLabel lblNewLabel_4_1_4 = new JLabel("10");
		lblNewLabel_4_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_1_4.setBounds(158, 242, 100, 19);
		pnlTuyChinh.add(lblNewLabel_4_1_4);
		
		JLabel lblNewLabel_4_2_3 = new JLabel("Số sản phẩm:");
		lblNewLabel_4_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_2_3.setBounds(10, 271, 107, 19);
		pnlTuyChinh.add(lblNewLabel_4_2_3);
		
		JLabel lblNewLabel_4_1_1_3 = new JLabel("10");
		lblNewLabel_4_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4_1_1_3.setBounds(158, 271, 100, 19);
		pnlTuyChinh.add(lblNewLabel_4_1_1_3);
		
		JLabel lblNewLabel_5 = new JLabel("(*) Nhấn vào để xem chi tiết");
		lblNewLabel_5.setBounds(10, 45, 161, 13);
		add(lblNewLabel_5);
		
		pnlHomNay.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e) {
				dlgThongKeTheoCa dlgThongKe = new dlgThongKeTheoCa(frmTrangChu);
				dlgThongKe.setLocationRelativeTo(frmTrangChu);
				dlgThongKe.setVisible(true);
            }
		});
	}
}

package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class dlgThongKeTheoCa extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Create the jdialog.
	 */
	public dlgThongKeTheoCa(JFrame frmTrangChu) {
		super(frmTrangChu, true);
		setTitle("THỐNG KÊ THEO CA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1058, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1038, 533);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 1018, 76);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Từ ngày:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 10, 143, 19);
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(20, 33, 176, 19);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblnNgy = new JLabel("Đến ngày:");
		lblnNgy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblnNgy.setBounds(241, 10, 143, 19);
		panel_1.add(lblnNgy);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(251, 33, 176, 19);
		panel_1.add(textField_1);
		
		JButton btnNewButton = new JButton("Lọc");
		btnNewButton.setBounds(469, 32, 58, 21);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("(*) Trong ngày");
		lblNewLabel_1.setForeground(new Color(255, 128, 64));
		lblNewLabel_1.setBounds(574, 36, 86, 13);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("(*) Ca đã reset");
		lblNewLabel_1_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1_1.setBounds(708, 36, 86, 13);
		panel_1.add(lblNewLabel_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 87, 1018, 434);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1018, 426);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 ca", "Nh\u00E2n vi\u00EAn", "Th\u1EDDi gian b\u1EAFt \u0111\u1EA7u", "Th\u1EDDi gian k\u00EAt th\u00FAc", "Ti\u1EC1n ban \u0111\u1EA7u", "T\u1ED5ng ti\u1EC1n ca"
			}
		));
		table.getColumnModel().getColumn(2).setPreferredWidth(94);
		table.getColumnModel().getColumn(3).setPreferredWidth(94);
		scrollPane.setViewportView(table);
	}

}

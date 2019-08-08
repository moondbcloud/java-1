package tutorial;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JTblTest extends JFrame {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet result = null;
	String sql = null;
	
	private JPanel contentPane;
	private JTable table;
	private JTextField txtUserID;
	private JTextField txtUserPWD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTblTest frame = new JTblTest();
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
	public JTblTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUserID = new JTextField();
		txtUserID.setBounds(103, 168, 116, 24);
		contentPane.add(txtUserID);
		txtUserID.setColumns(20);
		
		txtUserPWD = new JTextField();
		txtUserPWD.setColumns(20);
		txtUserPWD.setBounds(103, 220, 116, 24);
		contentPane.add(txtUserPWD);
		
		JLabel lblUserid = new JLabel("UserID");
		lblUserid.setBounds(28, 171, 62, 18);
		contentPane.add(lblUserid);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(27, 223, 73, 18);
		contentPane.add(lblPassword);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(261, 106, 435, 291);
		contentPane.add(scrollPane);
		
		// table에 마우스 클릭 이벤트 핸들러 추가... 테이블을 클릭하면 몇번째 행인지 체크하여 해당 행의 아이디 값으로 데이터를 조회하여
		// txt....에 세트한다.
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "madang", "madang");
					
					int row = table.getSelectedRow();
					String uid =(table.getModel().getValueAt(row, 0)).toString();
					System.out.println(uid);
					sql = "SELECT * FROM members where userid=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, uid);
					
					result = pstmt.executeQuery();
					while(result.next()) {
						txtUserID.setText(result.getString("userid"));
						txtUserPWD.setText(result.getString("userpwd"));
					}
					
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//
				
				
			}
		});
		scrollPane.setViewportView(table);
		
		refreshTable();
		
// 저장, 인서트, 업데이트 등 버튼이 클릭되어 동작 후 테이블을 새로고침 메서드를 호출함.
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				try {
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "madang", "madang");
					
					sql = "INSERT INTO members values(?, ?)";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, txtUserID.getText());
					pstmt.setString(2, txtUserPWD.getText());
					
					int cnt = pstmt.executeUpdate();
					
					if(cnt != 0)JOptionPane.showMessageDialog(null,  "Data inserted successfully.");
					refreshTable();
					
					pstmt.close();
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnSave.setBounds(114, 277, 105, 27);
		contentPane.add(btnSave);
		

		
		JButton btnLoadMembersData = new JButton("Load Members Data");
		btnLoadMembersData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refreshTable();
			}
		});
		btnLoadMembersData.setBounds(412, 50, 184, 27);
		contentPane.add(btnLoadMembersData);
	}// end of JTblTest()
		
		public void refreshTable() {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "madang", "madang");
				
				sql = "SELECT * FROM members";
				pstmt = conn.prepareStatement(sql);
				result = pstmt.executeQuery();

				// rs2xml.jar를 다운로드하여 external jar 추가하고... 
				table.setModel(DbUtils.resultSetToTableModel(result));
				
				result.close();
				pstmt.close();
				conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}// end of refreshTable();
}

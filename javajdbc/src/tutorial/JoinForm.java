package tutorial;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

public class JoinForm extends JFrame {
	Connection conn;
	PreparedStatement pstmt;
	String sql;
	ResultSet result;
	
	private JPanel contentPane;
	private JTextField txtUserID;
	private JTextField txtUserPWD;
	private JTextField txtPhone;
	private JTextField txtAddress;
	/**
	 * Create the frame.
	 */
	public JoinForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 843, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeAll();
				dispose();
				LoginForm loginform = new LoginForm();
				loginform.setVisible(true);
			}
		});
		btnExit.setBounds(675, 525, 129, 29);
		contentPane.add(btnExit);
		
		txtUserID = new JTextField();
		txtUserID.setBounds(318, 126, 237, 27);
		contentPane.add(txtUserID);
		txtUserID.setColumns(20);
		
		JLabel lblNewMemberJoin = new JLabel("New Member Join to us");
		lblNewMemberJoin.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewMemberJoin.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewMemberJoin.setBounds(163, 45, 404, 49);
		contentPane.add(lblNewMemberJoin);
		
		txtUserPWD = new JTextField();
		txtUserPWD.setColumns(20);
		txtUserPWD.setBounds(318, 193, 237, 27);
		contentPane.add(txtUserPWD);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(20);
		txtPhone.setBounds(318, 253, 237, 27);
		contentPane.add(txtPhone);
		
		txtAddress = new JTextField();
		txtAddress.setColumns(20);
		txtAddress.setBounds(318, 322, 237, 27);
		contentPane.add(txtAddress);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setBounds(173, 132, 82, 21);
		contentPane.add(lblUserId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(173, 199, 82, 21);
		contentPane.add(lblPassword);
		
		JLabel lblPhone = new JLabel("Phone Number");
		lblPhone.setBounds(173, 259, 134, 21);
		contentPane.add(lblPhone);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(173, 328, 134, 21);
		contentPane.add(lblAddress);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUserID.setText("");
				txtUserPWD.setText("");
				txtPhone.setText("");
				txtAddress.setText("");
			}
		});
		btnReset.setBounds(187, 422, 129, 29);
		contentPane.add(btnReset);
		
		JButton btnJoin = new JButton("Join");
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbconnect();
				String uid = txtUserID.getText();
				String upwd = txtUserPWD.getText();
				String uphone = txtPhone.getText();
				String uaddr = txtAddress.getText();
				if(!chkDuplicate(uid)) {
					sql = "INSERT INTO members VALUES(?,?,?,?)";
					try {
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, uid);
						pstmt.setString(2, upwd);
						pstmt.setString(3, uphone);
						pstmt.setString(4, uaddr);
						int rst = pstmt.executeUpdate();
						if(rst==1)JOptionPane.showMessageDialog(null, "1개의 레코드를 추가하였습니다.");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "동일한 ID의 레코드가 존재합니다.");
				}// end of if else
			}
		});
		btnJoin.setBounds(390, 422, 129, 29);
		contentPane.add(btnJoin);
	}
	
	void dbconnect() {
		// 연결 설정
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "madang", "madang");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버가 로드되지 않았습니다.");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("데이터베이스 연결에 문제가 있습니다.");
			e.printStackTrace();
		}
		
	}// end of dbconnect()
	
	boolean chkDuplicate(String newid) {
		boolean exist = false;
		dbconnect();
		
		sql = "SELECT * FROM members WHERE userid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newid);
			result = pstmt.executeQuery();
			if(result.next()) {
				exist = true;
			}else exist = false;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return exist;
	}//end of chkDuplicate()
	
	void closeAll() {
		if(pstmt != null )
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}//end of closeAll()

}// end of class JoinForm

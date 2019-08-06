package tutorial;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UserForm extends JFrame {
	Connection conn;
	PreparedStatement pstmt;
	String sql;
	ResultSet result;
	
	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public UserForm() {
		setTitle("Common User Forem");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 984, 637);
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
		btnExit.setBounds(792, 520, 129, 29);
		contentPane.add(btnExit);
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
}

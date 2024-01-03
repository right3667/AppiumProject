package resouce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DB_connect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		String url = "jdbc:oracle:thin:@192.168.36.14:1521:orcl";
		String id = "system";
		String pwd = "admin123!";
		
		
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pwd);
			System.out.println("데이터베이스 연결 성공!!");
			
			String sql = "INSERT INTO TESTDB2 values('admin', 'admin')";
			PreparedStatement pstm = con.prepareStatement(sql);
			
			pstm.executeUpdate();
			
			System.out.println("데이터베이스 insert 성공!!");
			
			
		}catch (Exception e) {
			System.out.println("데이터베이스 연결 실패!!");
			e.printStackTrace();
		}finally {
			try {
				if(con != null)
					con.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}

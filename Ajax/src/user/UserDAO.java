package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	
	public UserDAO() {
		try {
			String url = "jdbc:mysql://localhost:3306/testajax";
			String dbid = "root";
			String pwd = "admin12345";
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url,dbid,pwd);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<UserVO> search(String userName){
		List<UserVO> list = new ArrayList<>();
		String sql = "SELECT * FROM USER WHERE userName LIKE concat('%',?,'%')";
		
		try {
			
			pst = conn.prepareStatement(sql);
			pst.setString(1, userName);
			System.out.println(sql);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				UserVO user = new UserVO();
				user.setUserName(rs.getNString("userName"));
				user.setUserAge(rs.getInt("userAge"));
				user.setUserGender(rs.getString("userGender"));
				user.setUserEmail(rs.getString("userEmail"));
				list.add(user);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		
		List<UserVO> list = dao.search("");
		
		for(UserVO vo : list) {
			System.out.println(vo.getUserName());
		}
	}
}

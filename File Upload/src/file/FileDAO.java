package file;
//C:\JSP\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\File Upload 폴더 만들기!
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;

public class FileDAO {
	Connection conn;
	public FileDAO() {
		try {
			String dbURL="jdbc:mysql://localhost:3306/File";
			String dbID="root";
			String dbPassword = "111111";
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(dbURL, dbID, dbPassword);
			
			}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int upload(String fileName,String fileRealName) {
		String SQL = "insert into FILE VALUES(?, ?, 0);";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, fileName);
			pstmt.setString(2, fileRealName);
			return pstmt.executeUpdate();//1
		}catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	public int hit(String fileRealName) {
		String SQL = "Update file set downloadCount = downloadCount + 1 where fileRealName = ?;";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, fileRealName);
			return pstmt.executeUpdate();//1
		}catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	public ArrayList<FileDTO> getList(){
		String SQL = "select * from FILE;";
		ArrayList<FileDTO> list = new ArrayList<FileDTO>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				FileDTO file = new FileDTO(rs.getString(1),rs.getString(2),rs.getInt(3));
				list.add(file);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}

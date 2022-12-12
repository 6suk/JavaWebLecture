package baseballPlayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class PlayerDAO {
	private static Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public static void myGetConn() {
		try {
			Context initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/world");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** 1. 선수 목록 */
	public List<Player> getPlayerList() {
		String sql = "SELECT * FROM bplayer WHERE bye = 0 ORDER BY FIELD(POSITION,'투수','포수','내야수','외야수');";
		List<Player> playerList = new ArrayList<>();

		try {
			myGetConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Player p = new Player();
				p.setNum(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setPosition(rs.getString(3));
				p.setbDay(LocalDate.parse(rs.getString(4)));
				p.setHeight(rs.getInt(5));
				playerList.add(p);
			}

			rs.close();
			conn.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return playerList;
	}

	/** 1-1. 선수1명 목록 */
	public Player getPlayer(int num) {
		String sql = "SELECT * FROM bplayer WHERE number = ?;";
		Player p = new Player();

		try {
			myGetConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				p.setNum(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setPosition(rs.getString(3));
				p.setbDay(LocalDate.parse(rs.getString(4)));
				p.setHeight(rs.getInt(5));
				p.setBye(rs.getInt(6));
			}

			rs.close();
			conn.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	/** 1-2. 방출된 선수 목록 */
	public List<Player> byePlayerList() {
		String sql = "SELECT * FROM bplayer WHERE bye = 1 ORDER BY FIELD(POSITION,'투수','포수','내야수','외야수');";
		List<Player> playerList = new ArrayList<>();

		try {
			myGetConn();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Player p = new Player();
				p.setNum(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setPosition(rs.getString(3));
				p.setbDay(LocalDate.parse(rs.getString(4)));
				p.setHeight(rs.getInt(5));
				playerList.add(p);
			}

			rs.close();
			conn.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return playerList;
	}

	/** 2. 선수 등록 */
	public void setPlayer(Player p) {
		String sql = "INSERT INTO bplayer VALUES(?, ?, ?, ?, ?, 0);";

		try {
			myGetConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p.getNum());
			pstmt.setString(2, p.getName());
			pstmt.setString(3, p.getPosition());
			pstmt.setString(4, String.valueOf(p.getbDay()));
			pstmt.setInt(5, p.getHeight());

			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			System.out.println("  [선수 등록 완료]");
		} catch (SQLException e) {
			System.out.println("  [오류] " + e.getMessage());
		}
	}

	/** 3. 선수 정보 수정 */
	public void updatePlayer(Player p) {
		String sql = "UPDATE bplayer SET `name` = ?, `position` = ?, height = ?, birthday = ? WHERE number = ?;";

		try {
			myGetConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getName());
			pstmt.setString(2, p.getPosition());
			pstmt.setInt(3, p.getHeight());
			pstmt.setString(4, p.getbDay().toString());
			pstmt.setInt(5, p.getNum());

			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("  [오류] " + e.getMessage());
		}

	}

	/** 4. 선수 방출 */
	public void byePlayer(int num) {
		String sql = "UPDATE bplayer SET `bye` = 1 WHERE NUMBER = ?;";

		try {
			myGetConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			System.out.println("  " + getPlayer(num).getName()+"선수가 방출되었습니다.");
		} catch (SQLException e) {
			System.out.println("  [오류] " + e.getMessage());
		}

	}

	/** 5. 선수 재입단 */
	public void welcomPlayer(int num) {
		String sql = "UPDATE bplayer SET `bye` = 0 WHERE NUMBER = ?;";

		try {
			myGetConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			System.out.println("  " + getPlayer(num).getName()+"선수가 재입단했습니다.");
		} catch (SQLException e) {
			System.out.println("  [오류] " + e.getMessage());
		}
	}
}

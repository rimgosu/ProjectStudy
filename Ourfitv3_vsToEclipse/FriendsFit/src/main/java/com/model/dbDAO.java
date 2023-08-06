package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import file.model.fileDTO;

public class dbDAO {

	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	private int cnt = 0;

	// db 연결
	public void getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String db_url = "jdbc:oracle:thin:@project-db-stu3.smhrd.com:1524:xe";
			String db_id = "Insa4_Spring_hacksim_5";
			String db_pw = "aishcool5";

			conn = DriverManager.getConnection(db_url, db_id, db_pw);

			System.out.print("conn completed. ");
		}

		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("ojdbc6.jar 또는 경로를 확인하세요"); // syse
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("DB연결에 필요한 정보가 맞는지 체크하세요!");
		}
	}

	// db 종료
	public void close() {
		try {

			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}

			System.out.println("close completed.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int fileUpload(String fileName, String fileRealName) {
		getConnection();

		try {
			String sql = "INSERT INTO TB_FILE VALUES (FILE_NUM.NEXTVAL, ?, ?, 0, 'Y', SYSDATE )";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, fileName);
			psmt.setString(2, fileRealName);
			psmt.executeUpdate();

			sql = "SELECT FILE_NUM.CURRVAL FROM dual";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			int fileNum = 0;
			if (rs.next()) {
				fileNum = rs.getInt(1);
			}

			return fileNum;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}

	public int reviewUpload(reviewDTO reviewdto, int fileNum) {
		getConnection();

		try {
			String sql = "INSERT INTO TB_REVIEW VALUES (REVIEW_NUM.NEXTVAL, ?, ?, ?, ?, ?, SYSDATE, 0, 0, ?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, reviewdto.getReviewTitle());
			psmt.setString(2, reviewdto.getReviewContent());
			psmt.setInt(3, reviewdto.getFacilityNum());
			psmt.setString(4, reviewdto.getID());
			psmt.setInt(5, fileNum);
			psmt.setInt(6, reviewdto.getReviewGrade());

			cnt = psmt.executeUpdate();

			return cnt;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}

	public ArrayList<reviewSelectDTO> getReviews() {
		ArrayList<reviewSelectDTO> list = new ArrayList<reviewSelectDTO>();
		getConnection();
		try {
			String sql = "select * from tb_review";
			psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				reviewSelectDTO reviews = new reviewSelectDTO(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getInt(9),
						rs.getInt(10));
				list.add(reviews);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public reviewSelectDTO getReview(int reviewNum) {
		ArrayList<reviewSelectDTO> list = new ArrayList<reviewSelectDTO>();
		getConnection();
		try {
			String sql = "select * from tb_review where 리뷰번호=?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, reviewNum);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				reviewSelectDTO reviews = new reviewSelectDTO(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getInt(9),
						rs.getInt(10));
				list.add(reviews);
			}
			return list.get(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return null;
	}

	public int commentUpload(commentDTO commentdto) {
		getConnection();

		try {
			String sql = "INSERT INTO TB_REVIEW_COMMENT VALUES (COMMENT_NUM.NEXTVAL, ?, ?, ?, SYSDATE, ?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, commentdto.getCommentContent());
			psmt.setString(2, commentdto.getID());
			psmt.setInt(3, commentdto.getReviewNum());
			psmt.setInt(4, commentdto.getCommentLikeNum());

			cnt = psmt.executeUpdate();

			return cnt;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}

	public ArrayList<reviewComment_memberDTO> getReviewComment(int reviewNum) {
		ArrayList<reviewComment_memberDTO> list = new ArrayList<reviewComment_memberDTO>();
		getConnection();
		try {
			String sql = "select a.아이디, 포인트, a.등록일자, 댓글내용, 좋아요 from tb_review_comment a, tb_member b where a.아이디 = b.아이디 and 리뷰번호=?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, reviewNum);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				reviewComment_memberDTO reviews = new reviewComment_memberDTO(rs.getString(1), rs.getInt(2),
						rs.getString(3), rs.getString(4), rs.getInt(5));
				list.add(reviews);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return null;
	}

	public ArrayList<String> facilitySearch(String query) {
		ArrayList<String> list = new ArrayList<String>();
		getConnection();
		try {
			String sql = "select 시설이름 from tb_facility where 시설이름 like ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "%"+query+"%");
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(1));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return null;
	}

}

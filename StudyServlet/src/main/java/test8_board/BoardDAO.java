package test8_board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// study_jsp3.board 테이블의 데이터 처리 작업 담당하는 BoardDAO 클래스 정의
public class BoardDAO {
	
	// alt + shift + z : try-catch
	
	// 글쓰기 작업 수행하는 insert 메소드
	public int insert(BoardDTO board) {
		int insertCount = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null, pstmt2 = null;
		ResultSet rs = null;

		try {
			con = JdbcUtil.getConnection();

			// 1) 새 글 번호 계산 : 데이터베이스 max() 함수 활용
			int idx = 1; // 새 글 번호 저장할 변수 선언 (기본값 1)

			// 3단계
			// MAX(컬럼명) 함수 사용하여 특정 컬럼에서 가장 큰 값 조회 가능
			String sql = "SELECT MAX(idx) FROM board";
			pstmt = con.prepareStatement(sql);

			// 4단계
			rs = pstmt.executeQuery();

			if (rs.next()) {
				idx = rs.getInt(1) + 1;
			}

			// 2) 글 등록하기 (INSERT)
			// 3단계
			sql = "INSERT INTO board VALUES(?,?,?,?,?,now(),0)";
			pstmt2 = con.prepareStatement(sql);

			pstmt2.setInt(1, idx);
			pstmt2.setString(2, board.getName());
			pstmt2.setString(3, board.getPasswd());
			pstmt2.setString(4, board.getSubject());
			pstmt2.setString(5, board.getContent());

			// 4단계
			insertCount = pstmt2.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생! - insert() : " + e.getMessage());
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(pstmt2);
			JdbcUtil.close(con);
		}

		return insertCount;
	}
	
	// -------------------------------------------------------------------------------------------------
	
	// 글목록 조회 작업을 수행하는 select() 메소드 정의
	// => 파라미터 : 없음    리턴타입 : java.util.List(boardList) => 제네릭타입 BoardDTO
	public List<BoardDTO> select() {

		// 글목록 조회 결과를 리턴할 List 타입 변수 선언
		// 1개 레코드가 저장된 BoardDTO 객체 복수개를 하나의 묶음으로 관리할 List 타입
		List<BoardDTO> boardList = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = JdbcUtil.getConnection();

			// 3단계
			String sql = "SELECT * FROM board ORDER BY idx DESC";
			pstmt = con.prepareStatement(sql);

			// 4단계
			rs = pstmt.executeQuery();

			// 복수개의 레코드(복수개의 BoardDTO 객체)를 저장하는 ArrayList 객체 생성
			// => 제네릭타입 BoardDTO 지정
			// => 반복문 실행 전 먼저 객체 생성한 후 반복문 내에서 BoardDTO 객체 저장 필수!
			boardList = new ArrayList<BoardDTO>();

			while (rs.next()) {
				BoardDTO board = new BoardDTO();

				// 1개 레코드의 각 컬럼 데ㅇ에는 마지막 레코드 정보만 저장됨
				board.setIdx(rs.getInt("idx"));
				board.setName(rs.getString("name"));
				board.setPasswd(rs.getString("passwd"));
				board.setSubject(rs.getString("subject"));
				board.setContent(rs.getString("content"));
				board.setDate(rs.getDate("date"));
				board.setReadcount(rs.getInt("readcount"));

				boardList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
			JdbcUtil.close(con);
		}

		return boardList;
	}
}
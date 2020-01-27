package com.ninemovies.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ninemovies.board.dto.BoardDTO;
import com.ninemovies.util.idb.DBUtil;

public class BoardDAO {

	//1.BoardList 데이터 가져오기
	//service.BoardListService -> dao.BoardDAO
	public List<BoardDTO> list() throws Exception{
		System.out.println("BoardDAO.list()");
		
		//가져온데이터저장변수(return 타입과 같게)
		List<BoardDTO> list = null;
		
		//1,2데이터 가져오기
		Connection con = DBUtil.getConnection();
		//3
		String sql = "SELECT no, email, nickName, title, content, "
			+ " TO_CHAR(writeDate, 'yyyy-mm-dd') writeDate, "
			+ " hit, cntLike FROM board ORDER BY no DESC ";
		System.out.println("BoardDAO.sql(): "+sql);
		//4실행객체가져오기
		PreparedStatement pstmt = con.prepareStatement(sql);
		//5실행
		ResultSet rs = pstmt.executeQuery();
		//6표시/저장
		if (rs != null) {
			while(rs.next()) {
				if(list==null) {
					//리스트 초기화
					list = new ArrayList<BoardDTO>();
				}
				//데이터 담을 객체 생성
				BoardDTO dto = new BoardDTO();
				//result set에서 가져와서 dto에 담는다.
				dto.setNo(rs.getInt("no"));
				dto.setEmail(rs.getString("email"));
				dto.setNickName(rs.getString("nickName"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setWriteDate(rs.getString("writeDate"));
				dto.setHit(rs.getInt("hit"));
				dto.setCntLike(rs.getInt("cntLike"));
				//dto에 담겨진데이터를 list에 저장시킴
				list.add(dto);
			}//while end
		}//if end
		DBUtil.close(con, pstmt, rs);
		System.out.println("BoardDAO.list().list:" + list);
		return list;
	}//List end
	
	
	
	
	
	
	
	
}//BoardDAO end
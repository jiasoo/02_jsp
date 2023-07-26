package guestbook2.db;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

// DB 처리하는 메서드들을 가지고 있는 클래스
public class DAO {
	// 실제사용하는 클래스 : SqlSession
	private static SqlSession ss;
	
	// 싱글턴패턴(동기화처리): 프로그램이 종료될 때까지 한번 만들어진 객체를 재사용한다.
	private static SqlSession getSession() {
		if(ss == null) {
			ss = DBService.getFactory().openSession();
		}
		return ss;
	}
	
	// 리스트	
	public static List<VO> getList(){
		List<VO> list = getSession().selectList("guestbook2.list");
		return list;
	}
	// 삽입
	public static int getInsert(VO vo) {
		int result = getSession().insert("guestbook2.insert",vo);
		ss.commit();
		return result;
	}
	// 상세보기
	public static VO getOneList(String idx) {
		VO vo = getSession().selectOne("guestbook2", idx);
		return vo;
	}
	// 수정
	public static int getUpdate(VO vo){
		int result = getSession().update("guestbook2.update",vo);
		ss.commit();
		return result;
	}
	// 삭제
	public static int getDeletr(String idx) {
		int result = getSession().delete("guestbook2.delete", idx);
		ss.commit();
		return result;
	}
 }
	 
	 


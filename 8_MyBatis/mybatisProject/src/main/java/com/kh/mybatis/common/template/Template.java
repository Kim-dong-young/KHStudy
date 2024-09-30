package com.kh.mybatis.common.template;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.kh.mybatis.common.vo.PageInfo;

public class Template {
	public static SqlSession getSqlSession() {
		// mybatis-config.xml 읽어들임
		
		SqlSession sqlSession = null;
		
		// SqlSession 생성하기 위해 -> SqlSessionFactory 객체 필요
		// SqlSessionFactory 생성하기 위해 -> SqlSessionFactoryBuilder 필요
		
		String resource = "/mybatis-config.xml";
		
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession(false); // 자동커밋 여부 한번 더 설정, true:자동커밋 / false : 수동커밋
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sqlSession;
	}
	
	/**
	 * 
	 * @param listCount : 총 게시글 수
	 * @param currentPage : 현재 페이지
	 * @param pageLimit : 하단에 보여질 페이징 바의 수
	 * @param boardLimit : 한 페이지에 보여질 게시글 최대 수
	 * @return PageInfo
	 */
	public static PageInfo getPageInfo(int listCount, int currentPage, int pageLimit, int boardLimit) {
		int maxPage = (int) Math.ceil( (double)listCount / boardLimit ); // 가장 마지막 페이지
		int startPage = ((currentPage - 1) / pageLimit) * pageLimit + 1; // 페이징바의 시작
		int endPage = startPage + pageLimit - 1; // 페이징바의 마지막

		endPage = endPage > maxPage ? maxPage : endPage;
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		return pi;
	}
}
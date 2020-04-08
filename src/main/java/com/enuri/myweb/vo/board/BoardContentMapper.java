package com.enuri.myweb.vo.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardContentMapper {

	public List<BoardContent> getBoardList();
	//main-list
	public BoardContent readBoard(int cnt);
	//read
	public int deleteBoard(int cnt);
	//delete
	public int updateBoard(BoardContent boardcontet);
	//modify
	public void insertBoard(BoardContent boardcontet);
	//write
	
}

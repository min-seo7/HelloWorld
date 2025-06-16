package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.ReplyVo;

public interface ReplyMapper {
	public int insertreply(ReplyVo reply);
	public List<ReplyVo> selectList(@Param("bno") int bno, @Param("page") int page);
	public ReplyVo selectReply(int rvo);
	public int deletereply(int rvo);
	public int selectTotal(int bno);
}

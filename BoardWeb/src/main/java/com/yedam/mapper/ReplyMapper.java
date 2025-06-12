package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.ReplyVo;

public interface ReplyMapper {
	public int insertreply(ReplyVo reply);
	public List<ReplyVo> selectList(int bno);
	public ReplyVo selectReply(int rvo);
	public int deletereply(int rvo);
}

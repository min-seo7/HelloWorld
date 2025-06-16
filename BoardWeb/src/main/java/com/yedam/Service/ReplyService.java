package com.yedam.Service;

import java.util.List;

import com.yedam.vo.ReplyVo;

public interface ReplyService {
	public boolean addReply(ReplyVo rvo); //댓글추가
	public List<ReplyVo> replyList(int bno, int page); //댓글목록
	public ReplyVo getReply(int rno); //댓글검색
	public boolean removeReply(int rno);  //댓글삭제
	public int totalCount(int bno);
}

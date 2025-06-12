package com.yedam.common;

import java.util.List;

import com.yedam.Service.ReplyService;
import com.yedam.Service.ReplyServiceImpl;
import com.yedam.vo.ReplyVo;

public class AppTest {
	public static void main(String[] args) {
		ReplyService svc = new ReplyServiceImpl();
		
		//글에서 댓글조회
		List<ReplyVo> rep = svc.replyList(707);
		for(ReplyVo re : rep) {
			System.out.println(re.toString());
		}
		
		//추가
		ReplyVo test = new ReplyVo();
		test.setBoardNo(700);
		test.setReply("타자좀");
		test.setReplyer("오타유발자");
		
		svc.addReply(test);
		
		//삭제.(댓글번호)
		svc.removeReply(7);
		
		//댓글번호조회
		ReplyVo reply = svc.getReply(1);
		System.out.println(reply.toString());		
	}
}
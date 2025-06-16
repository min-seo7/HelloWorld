package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.Service.ReplyService;
import com.yedam.Service.ReplyServiceImpl;
import com.yedam.common.Control;
import com.yedam.vo.ReplyVo;

public class ReplyInfoControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		// TODO Auto-generated method stub
		String rno = req.getParameter("rno");
		ReplyService svc = new ReplyServiceImpl();
		ReplyVo rvo = svc.getReply(Integer.parseInt(rno));

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(rvo);
		resp.getWriter().print(json);
	}

}

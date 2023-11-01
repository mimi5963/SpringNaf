package frontcontroller.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.MemberRepositroy;
import domain.MemberVO;

public class LoginController implements Controller{
	
	private MemberRepositroy memberDB;
	public LoginController() {
		memberDB = MemberRepositroy.getInstance();
	}

	@Override
	public String Dohandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String method = request.getMethod();
		if(method.equalsIgnoreCase("get")) {
			return "login";
		}
		
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		
		MemberVO loginMember = memberDB.findMemberByNameAndPwd(name, pwd);
		
		if(loginMember != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", loginMember.getId());
			session.setAttribute("userName", loginMember.getName());
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인실패");
		}
		
		for(MemberVO vo : memberDB.memberList()) {
			System.out.println(vo.getName());
		}
		
		return "redirect:/home.do";
	}

}

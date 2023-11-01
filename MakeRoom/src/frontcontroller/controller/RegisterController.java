package frontcontroller.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.MemberRepositroy;
import domain.MemberVO;

public class RegisterController implements Controller{
	private MemberRepositroy memberDB;
	public RegisterController() {
		memberDB = MemberRepositroy.getInstance();
	}

	@Override
	public String Dohandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getMethod();
		if("get".equalsIgnoreCase(method)) {
			return "register";
		}
		
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		MemberVO newMember = new MemberVO();
		newMember.setName(name);
		newMember.setPwd(pwd);
		memberDB.saveMember(newMember);
		System.out.println("멤버저장완료");
		return "redirect:/home.do";
	}

}

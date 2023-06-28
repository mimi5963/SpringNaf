package kr.bit.myapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.bit.model.MemberDAO;
import kr.bit.model.MemberVO;

@Controller
public class MemberController {
	@Autowired
	private MemberDAO dao;
	
	@RequestMapping("/memberList.do")
	public String memberList(Model model) { //HttpServletRequest == model
		//MemberDAO dao = new MemberDAO(); 쓰지말자
		List<MemberVO> list =dao.memberList();
		model.addAttribute("list",list);
		return "memberList"; 
	}
	
	@RequestMapping("/memberInsert.do")
	public String memberInsert(MemberVO vo) {
		//파라미터 수집전에 인코딩 필요 
		//따라서 프론트컨트롤러가 한글처리하도록 해줘야함
		//디스팻쳐 오기전에 필터 설정하자
		int cnt = dao.memberInsert(vo);
		
		return "redirect:/memberList.do";
	}
	
	@RequestMapping("/memberRegister.do")
	public String memberRegister() {
		
		
		
		return "memberRegister";
	}
	
	@RequestMapping("/memberDelete.do")
	public String memberDelete(@RequestParam("num") int num) { //변수이름 바꾸려면 requestParam달아야함
		
		//파라미터 수집 해야함 num하나 있어요 
		//물론 VO로 수집해도됨! num하나만 된 vo나오겠지뭐
		int cnt = dao.memberDelete(num);
		
		return "redirect:/memberList.do";
	}
	
	@RequestMapping("/memberContent.do")
	public String memberContent(@RequestParam("num") int s, Model model) {
		MemberVO vo =dao.memberContent(s);
		model.addAttribute("vo", vo);
		
		return "memberContent";
	}
	
	@RequestMapping("/memberUpdate.do")
	public String memberUpdate(MemberVO vo) {
		int cnt= dao.memberUpdate(vo);
		
		return "redirect:/memberList.do";
	}
		
	
}

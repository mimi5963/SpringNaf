package kr.narp.myapp2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.bit.mapper.MemberMapper;

import kr.bit.model.MemberVO;

@Controller
public class MemberController {
	@Autowired
	//private MemberDAO dao;
	private MemberMapper memberMapper;
	@RequestMapping("/memberList.do")
	public String memberList(Model model) { //HttpServletRequest == model
		//MemberDAO dao = new MemberDAO(); 쓰지말자
		List<MemberVO> list =memberMapper.memberList();
		model.addAttribute("list",list);
		return "memberList"; 
	}
	
	@RequestMapping("/memberInsert.do")
	public String memberInsert(MemberVO vo) {
		//파라미터 수집전에 인코딩 필요 
		//따라서 프론트컨트롤러가 한글처리하도록 해줘야함
		//디스팻쳐 오기전에 필터 설정하자
		int cnt = memberMapper.memberInsert(vo);
		
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
		int cnt = memberMapper.memberDelete(num);
		
		return "redirect:/memberList.do";
	}
	
	@RequestMapping("/memberContent.do")
	public String memberContent(@RequestParam("num") int s, Model model) {
		MemberVO vo =memberMapper.memberContent(s);
		model.addAttribute("vo", vo);
		
		return "memberContent";
	}
	
	@RequestMapping("/memberUpdate.do")
	public String memberUpdate(MemberVO vo) {
		int cnt= memberMapper.memberUpdate(vo);
		
		return "redirect:/memberList.do";
	}
		
	@RequestMapping("/memberAjaxList.do")
	public @ResponseBody List<MemberVO> memberAjaxList() {
		//@ResponseBody String view 넘기고 forward model이런거 말고 바로 객체 응답
		List<MemberVO> list =memberMapper.memberList();
		//응답을 $.ajax() -> callback 함수로 json pojo에선 response로 응답했음 
		//프론트 컨트롤러로 넘기는게 아니라! 바로 ajax로 응답 @Responsebody
		
		return list; // Object->Json (Jackson-databind)
	}
}

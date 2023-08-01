package kr.inflearn.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.inflearn.model.BoardVO;
import kr.inflearn.service.BoardService;

@Controller
public class BoardController {

@Autowired 
private BoardService service;
	
@RequestMapping("/list.do")
public String list(Model model) {
	List<BoardVO> list = service.getList();
	model.addAttribute("list", list);
	return "boardList";
}

	
}

/*
 /list.do --> Get --> list()
 /register.do -> POST -> register()
 /read.do ---> Get -->read()
 /remove.do -->Get -->remove()
 /modify.do -->POST --->modify()   
  
  */
 
package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AudiController {

	
	//@GetMapping("/index.do")
	public String index() {
		return "index";
	}
}

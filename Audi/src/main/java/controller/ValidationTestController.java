package controller;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class ValidationTestController {
	
//	
//	@ExceptionHandler(IllegalArgumentException.class)
//	public String illegalExHandle(IllegalArgumentException e) {
//		System.out.println("사소한 오류야 넘어가~");
//		return "index";
//	}
	@GetMapping("/getip")
	public void ipPort(@RequestParam IpPort port) {
		System.out.println("예수");
		System.out.println(port.getIp() +" ip주소");
		System.out.println(port.getPort()+" port번호");
		
	}
	@GetMapping("/v/ex")
	public void exMethod() {
		
		throw new IllegalArgumentException("예외!");
		//throw new ResponseStatusException(HttpStatus.NOT_FOUND,"에러 메시지",new IllegalAccessException("예외2"));
	}
	
	@GetMapping("/v")
	public String index(ItemVO vo) {
		return "itemForm";
	}
	
	@PostMapping("/v")
	public String form(@Validated ItemVO vo, BindingResult br,Model model) {
			model.addAttribute("error",br);
	
		
//		if(!StringUtils.hasText(vo.getName())) {
//			br.rejectValue("name", "required","기본메시지");
//	
//		}
//		
//		if(vo.getPrice() == null || vo.getPrice() < 1000 || vo.getPrice() > 10000000) {
//			br.rejectValue("price", "range",new Object[] {1000,10000000},"기본메시지");
//		}
//		
//		if(vo.getQuen() == null) {
//			br.rejectValue("quen", "quentity");
//		}
		
		if(vo.getPrice() != null && vo.getQuen() !=null) {
			int resultPrice = vo.getPrice() * vo.getQuen();
			if(resultPrice < 10000) {
				br.reject("totalPrice",new Object[] {},"가격과 수량의 합은 10000보다 커야 합니다.");
			}
		}
		
		if(br.hasErrors()) {
			System.out.println("error");
			
			br.getFieldErrors().stream().forEach(err -> {
				System.out.println(err.getField());
				System.out.println(Arrays.toString(err.getCodes()));
				System.out.println(err.getDefaultMessage());
			});
			
			return "itemForm";
		}
	
		
		//실행할 검증 로직
		return "index";
	}
}

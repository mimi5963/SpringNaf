package jw.bit.frontcontroller;

import java.util.HashMap;
import java.util.Map;

import jw.bit.controller.Controller;
import jw.bit.controller.MemberContentController;
import jw.bit.controller.MemberDeleteController;
import jw.bit.controller.MemberInsertController;
import jw.bit.controller.MemberListController;
import jw.bit.controller.MemberRegisterController;
import jw.bit.controller.MemberUpdateController;

public class HandlerMapping {
	private Map<String,Controller> mapper = new HashMap<>();
	public HandlerMapping() {
		mapper.put("/memberList.do", new MemberListController());
		mapper.put("/memberContent.do", new MemberContentController());
		mapper.put("/memberRegister.do", new MemberRegisterController());
		mapper.put("/memberInsert.do", new MemberInsertController());
		mapper.put("/memberDelete.do", new MemberDeleteController());
		mapper.put("/memberUpdate.do", new MemberUpdateController());
	}
	
	public Controller getController(String url) {
		return mapper.get(url);
	}

}

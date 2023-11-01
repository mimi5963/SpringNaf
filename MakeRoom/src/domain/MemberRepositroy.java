package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//임시 DB 3가지 기능 저장, 조회, 전체 회원 출력 
public class MemberRepositroy {
	
	private static MemberRepositroy mrv = new MemberRepositroy();
	
	private static Map<Integer,MemberVO> store;
	private static int sequence;
	
	private MemberRepositroy() {
		store = new ConcurrentHashMap<>();
		sequence = 0;
	}
	
	public MemberVO saveMember(MemberVO member) {
		member.setId(++sequence);
		store.put(member.getId(), member);
		return member;
	}
	
	public MemberVO findById(int id) {
		return store.get(id);
	}
	public List<MemberVO> memberList(){
		return new ArrayList(store.values());
	}
	public static MemberRepositroy getInstance() {
		return mrv;
	}
	public static MemberVO findMemberByNameAndPwd(String name, String pwd ) {
		return store.values().stream().
				filter(member -> {
			return name.equals(member.getName()) && pwd.equals(member.getPwd());
		}).findFirst()
		.orElse(null);
	}
}

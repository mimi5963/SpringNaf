package kr.bit.mapper;

import java.util.List;

import kr.bit.model.MemberVO;

public interface MemberMapper {
	public List<MemberVO> memberList(); // -- sql id = "memberList"
	public int memberInsert(MemberVO vo); // ---sql id = "memnerInsert"
	public int memberDelete(int num); // 인터페이스명과 xml에 id와 동일 
	public MemberVO memberContent(int num);
    public int memberUpdate(MemberVO vo);
}

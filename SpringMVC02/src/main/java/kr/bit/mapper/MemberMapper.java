package kr.bit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.bit.model.MemberVO;

@Mapper //(Mybatis(sqlsessionFactoey + sqlsession) 내부적으로 불러옴
public interface MemberMapper {
	@Select("select * from member")
	public List<MemberVO> memberList(); // 메서드 이름 sql id매칭 중요
	@Insert(" insert into member(id, pass, name, age, email, phone)\r\n" + 
			"        values(\r\n" + 
			"        #{id},\r\n" + 
			"        #{pass},\r\n" + 
			"        #{name},\r\n" + 
			"        #{age},\r\n" + 
			"        #{email},\r\n" + 
			"        #{phone}")
	public int memberInsert(MemberVO vo); // sql id = "memberInsert"
	@Delete("delete from member where num=#{num}")
	public int memberDelete(int num);
	@Select(" select * from member where num=#{num}")
	public MemberVO memberContent(int num);
	 @Update(" update member \r\n" + 
	 		"         set age=#{age}, email=#{email}, phone=#{phone} \r\n" + 
	 		"         where num=#{num}")
	public int memberUpdate(MemberVO vo);
}

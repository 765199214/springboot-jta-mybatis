package cn.linkpower.dao.mapper2;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import cn.linkpower.vo.Users;

@Mapper
public interface IUserMapper2 {
	
	@Insert({"insert into users (username,password) values (#{username},#{password})"})
	public int insertUser1(Users user);
}

package cn.linkpower.dao.mapper1;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import cn.linkpower.vo.Users;

@Mapper
public interface IUserMapper1 {
	
	@Insert({"insert into users (username,password) values (#{username},#{password})"})
	public int insertUser1(Users user);
}

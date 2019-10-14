package cn.linkpower.vo;

import java.io.Serializable;
import lombok.Data;

@Data
public class Users implements Serializable {
	private static final long serialVersionUID = -800649829237031505L;
	private Integer userid;
	private String username;
	private String password;
	private String descript;
}

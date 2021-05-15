package net.developia.mvc.models;

import java.io.Serializable;


import org.apache.commons.codec.digest.DigestUtils;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class MemberDTO implements Serializable {
	private long no;
	private String id;
	private String pwd;
	private String email;
	
	public void setPwd(String pwd) {
		this.pwd = DigestUtils.sha512Hex(pwd);
	}
}

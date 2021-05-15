package net.developia.mvc.models;

import java.io.Serializable;


import org.apache.commons.codec.digest.DigestUtils;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class MemberDTO implements Serializable {
	private long memNo;
	private long catNo;
	private long linkNo;
	private String id;
	private String pwd;
	private String email;
	private String name;
	private String title;
	private String link;
	private String content;
	
	public void setPwd(String pwd) {
		this.pwd = DigestUtils.sha512Hex(pwd);
	}
}

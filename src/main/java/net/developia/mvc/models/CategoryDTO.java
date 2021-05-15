package net.developia.mvc.models;

import java.io.Serializable;


import org.apache.commons.codec.digest.DigestUtils;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class CategoryDTO implements Serializable {
	private long no;
	private long member_no;
	private String name;
	
}

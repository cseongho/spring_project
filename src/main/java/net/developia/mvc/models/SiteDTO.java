package net.developia.mvc.models;

import java.io.Serializable;


import org.apache.commons.codec.digest.DigestUtils;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class SiteDTO implements Serializable {
	private long no;
	private long category_no;
	
	private String title;
	private String link;
	private String content;
	
}

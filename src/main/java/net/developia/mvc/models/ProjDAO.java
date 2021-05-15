package net.developia.mvc.models;

import java.sql.SQLException;
import java.util.List;


public interface ProjDAO {
	
	int signupMember(MemberDTO memberDTO) throws SQLException;

	MemberDTO loginMember(MemberDTO memberDTO) throws SQLException;

	List<CategoryDTO> getCategoryList(MemberDTO memberDTO) throws SQLException;

	List<SiteDTO> getSiteList(SiteDTO siteDTO) throws SQLException;

	List<SiteDTO> getSiteDetail(SiteDTO siteDTO) throws SQLException;

}

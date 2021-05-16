package net.developia.mvc.models;

import java.sql.SQLException;
import java.util.List;


public interface ProjDAO {

	MemberDTO loginMember(MemberDTO memberDTO) throws SQLException;
	
	int signupMember(MemberDTO memberDTO) throws SQLException;

	List<CategoryDTO> getCategoryList(MemberDTO memberDTO) throws SQLException;

	List<SiteDTO> getSiteList(SiteDTO siteDTO) throws SQLException;

	List<SiteDTO> getSiteDetail(SiteDTO siteDTO) throws SQLException;

	int siteAdd(SiteDTO siteDTO) throws SQLException;

	int siteDelete(SiteDTO siteDTO) throws SQLException;

	int siteUpdateAction(SiteDTO siteDTO) throws SQLException;

	int categoryAddAction(CategoryDTO categoryDTO) throws SQLException;
	
	int categoryDeleteAction(CategoryDTO categoryDTO) throws SQLException;

	int categoryUpdateAction(CategoryDTO categoryDTO) throws SQLException;

}

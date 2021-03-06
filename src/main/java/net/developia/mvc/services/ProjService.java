package net.developia.mvc.services;

import java.util.List;

import net.developia.mvc.models.CategoryDTO;
import net.developia.mvc.models.MemberDTO;
import net.developia.mvc.models.ProjDTO;
import net.developia.mvc.models.SiteDTO;

public interface ProjService {

	void signupMember(MemberDTO memberDTO) throws Exception;

	MemberDTO loginMember(MemberDTO memberDTO) throws Exception;

	List<CategoryDTO> getCategoryList(MemberDTO memberDTO) throws Exception;

	List<SiteDTO> getSiteList(SiteDTO siteDTO) throws Exception;

	List<SiteDTO> getSiteDetail(SiteDTO siteDTO) throws Exception;

	void siteAdd(SiteDTO siteDTO) throws Exception;

	void siteDelete(SiteDTO siteDTO) throws Exception;

	List<SiteDTO> getSiteUpdate(SiteDTO siteDTO) throws Exception;

	void siteUpdateAction(SiteDTO siteDTO) throws Exception;

	void categoryAddAction(CategoryDTO categoryDTO) throws Exception;

	void categoryDeleteAction(CategoryDTO categoryDTO) throws Exception;

	void categoryUpdateAction(CategoryDTO categoryDTO) throws Exception;

}

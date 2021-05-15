package net.developia.mvc.services;

import java.util.List;

import net.developia.mvc.models.CategoryDTO;
import net.developia.mvc.models.MemberDTO;
import net.developia.mvc.models.ProjDTO;

public interface ProjService {

	void signupMember(MemberDTO memberDTO) throws Exception;

	MemberDTO loginMember(MemberDTO memberDTO) throws Exception;

	List<CategoryDTO> getCategoryList(MemberDTO memberDTO) throws Exception;

	void categoryAdd(ProjDTO projDTO) throws Exception;

	void categoryDelete(ProjDTO projDTO) throws Exception;

	void categoryUpdate(ProjDTO projDTO) throws Exception;

	List<ProjDTO> getSiteList(ProjDTO projDTO) throws Exception;

	void siteAdd(ProjDTO projDTO) throws Exception;

	void siteDelete(ProjDTO projDTO) throws Exception;

	void siteUpdate(ProjDTO projDTO) throws Exception;

	List<ProjDTO> getSiteUpdateList(ProjDTO projDTO) throws Exception;

	List<ProjDTO> getSiteDetail(ProjDTO projDTO) throws Exception;

}

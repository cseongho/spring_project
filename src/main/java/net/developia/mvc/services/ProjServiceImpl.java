package net.developia.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import net.developia.mvc.models.CategoryDTO;
import net.developia.mvc.models.MemberDTO;
import net.developia.mvc.models.ProjDAO;
import net.developia.mvc.models.ProjDTO;
import net.developia.mvc.models.SiteDTO;

@Service
public class ProjServiceImpl implements ProjService {
	
	@Autowired
	@Qualifier(value="projDAO")
	private ProjDAO projDAO;
	
	@Override
	public void signupMember(MemberDTO memberDTO) throws Exception {
		if(projDAO.signupMember(memberDTO) != 1) {
			throw new RuntimeException("");
		}
	}

	@Override
	public MemberDTO loginMember(MemberDTO memberDTO) throws Exception {
		return projDAO.loginMember(memberDTO);
	}

	@Override
	public List<CategoryDTO> getCategoryList(MemberDTO memberDTO) throws Exception{
		return projDAO.getCategoryList(memberDTO);
	}

	@Override
	public List<SiteDTO> getSiteList(SiteDTO siteDTO) throws Exception {
		return projDAO.getSiteList(siteDTO);
	}

	@Override
	public List<SiteDTO> getSiteDetail(SiteDTO siteDTO) throws Exception {
		return projDAO.getSiteDetail(siteDTO);
	}

	@Override
	public void siteAdd(SiteDTO siteDTO) throws Exception {
		if(projDAO.siteAdd(siteDTO) != 1) {
			throw new RuntimeException("");
		}
	}

	@Override
	public void siteDelete(SiteDTO siteDTO) throws Exception {
		if(projDAO.siteDelete(siteDTO) != 1) {
			throw new RuntimeException("");
		}
	}

	@Override
	public List<SiteDTO> getSiteUpdate(SiteDTO siteDTO) throws Exception {
		return projDAO.getSiteDetail(siteDTO);
	}

	@Override
	public void siteUpdateAction(SiteDTO siteDTO) throws Exception {
		if(projDAO.siteUpdateAction(siteDTO) != 1) {
			throw new RuntimeException("");
		}
		
	}

	@Override
	public void categoryAddAction(CategoryDTO categoryDTO) throws Exception {
		if(projDAO.categoryAddAction(categoryDTO) != 1) {
			throw new RuntimeException("");
		}
	}

	@Override
	public void categoryDeleteAction(CategoryDTO categoryDTO) throws Exception {
		if(projDAO.categoryDeleteAction(categoryDTO) != 1) {
			throw new RuntimeException("");
		}
		
	}

	@Override
	public void categoryUpdateAction(CategoryDTO categoryDTO) throws Exception {
		if(projDAO.categoryUpdateAction(categoryDTO) !=1) {
			throw new RuntimeException("");
		}
	}
	

}

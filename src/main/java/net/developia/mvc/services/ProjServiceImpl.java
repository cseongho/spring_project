package net.developia.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import net.developia.mvc.models.CategoryDTO;
import net.developia.mvc.models.MemberDTO;
import net.developia.mvc.models.ProjDAO;
import net.developia.mvc.models.ProjDAOImpl;
import net.developia.mvc.models.ProjDTO;

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
	public void categoryAdd(ProjDTO projDTO) throws Exception {
		if(projDAO.categoryAdd(projDTO) != 1) {
			throw new RuntimeException("");
		}
	}

	@Override
	public void categoryDelete(ProjDTO projDTO) throws Exception {
		projDAO.categoryDelete(projDTO);
	}

	@Override
	public void categoryUpdate(ProjDTO projDTO) throws Exception {
		projDAO.categoryUpdate(projDTO);
		
	}

	@Override
	public List<ProjDTO> getSiteList(ProjDTO projDTO) throws Exception {
		return projDAO.getSiteList(projDTO);
	}

	@Override
	public void siteAdd(ProjDTO projDTO) throws Exception {
		if(projDAO.siteAdd(projDTO) != 1) {
			throw new RuntimeException("");
		}
		
	}

	@Override
	public void siteDelete(ProjDTO projDTO) throws Exception {
		projDAO.siteDelete(projDTO);
	}

	@Override
	public void siteUpdate(ProjDTO projDTO) throws Exception {
		projDAO.siteUpdate(projDTO);
		
	}

	@Override
	public List<ProjDTO> getSiteUpdateList(ProjDTO projDTO) throws Exception {
		return projDAO.getSiteUpdateList(projDTO);
	}

	@Override
	public List<ProjDTO> getSiteDetail(ProjDTO projDTO) throws Exception {
		return projDAO.getSiteUpdateList(projDTO);
	}
	

}

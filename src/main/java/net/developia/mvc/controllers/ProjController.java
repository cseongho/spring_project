package net.developia.mvc.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;
import net.developia.mvc.models.CategoryDTO;
import net.developia.mvc.models.MemberDTO;
import net.developia.mvc.models.ProjDTO;
import net.developia.mvc.models.SiteDTO;
import net.developia.mvc.services.ProjService;

@Slf4j
@Controller
public class ProjController {

	@Autowired
	private ProjService projService;
	
	@RequestMapping(value="/login")
	public ModelAndView login() {
		return new ModelAndView("login");
	}
	
	@PostMapping(value="/loginAction")
	public ModelAndView loginAction(@RequestParam("id") String id,@RequestParam("pwd") String pwd, HttpSession session) throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(id);
		memberDTO.setPwd(pwd);
		
		ModelAndView mav = new ModelAndView();
		try {
			memberDTO = projService.loginMember(memberDTO);
			mav.setViewName("redirect:main");
			String member_no = Long.toString(memberDTO.getNo());
			session.setAttribute("member_no", member_no);
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("result");
			mav.addObject("msg", "");
			mav.addObject("url", "javascript:history.back();");
		}
		return mav;
	}
	
	@PostMapping(value="/signupAction")
	public ModelAndView signupAction(@RequestParam("id") String id,@RequestParam("pwd") String pwd, @RequestParam("email") String email ) throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(id);
		memberDTO.setPwd(pwd);
		memberDTO.setEmail(email);
		
		ModelAndView mav = new ModelAndView();
		try {
			projService.signupMember(memberDTO);
			mav.setViewName("result");
			mav.addObject("msg", memberDTO.getId()+"");
			mav.addObject("url", "login");
			
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("result");
			mav.addObject("msg", "");
			mav.addObject("url", "javascript:history.back();");
		}
		return mav;
	}
	
	@RequestMapping(value="/main")
	public ModelAndView main(HttpSession session) {
		long memNo = Long.parseLong((String) session.getAttribute("member_no"));
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setNo(memNo);
		
		ModelAndView mav = new ModelAndView();
		try {
			List<CategoryDTO> cat_list = projService.getCategoryList(memberDTO);
			mav.setViewName("main");
			mav.addObject("cat_list", cat_list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping(value="/site")
	public ModelAndView site(HttpSession session, @RequestParam("no") long catNo) {
		long memNo = Long.parseLong((String) session.getAttribute("member_no"));
	
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setNo(memNo);
		
		SiteDTO siteDTO = new SiteDTO();
		siteDTO.setCategory_no(catNo);
		
		ModelAndView mav = new ModelAndView();
		try {
			List<CategoryDTO> cat_list = projService.getCategoryList(memberDTO);
			List<SiteDTO> site_list = projService.getSiteList(siteDTO);
			
			mav.setViewName("site");
			mav.addObject("cat_list", cat_list);
			mav.addObject("site_list", site_list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping(value="/siteDetail")
	public ModelAndView siteDetail(HttpSession session, @RequestParam("linkNo") long linkNo) {
		long memNo = Long.parseLong((String) session.getAttribute("member_no"));
				
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setNo(memNo);
		
		SiteDTO siteDTO = new SiteDTO();
		siteDTO.setNo(linkNo);
		
		ModelAndView mav = new ModelAndView();
		try {
			List<CategoryDTO> cat_list = projService.getCategoryList(memberDTO);
			List<SiteDTO> site_list = projService.getSiteDetail(siteDTO);
			mav.setViewName("siteDetail");
			mav.addObject("cat_list", cat_list);
			mav.addObject("site_list", site_list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping(value="/siteAdd")
	public ModelAndView siteAdd(HttpSession session) {
		long memNo = Long.parseLong((String) session.getAttribute("member_no"));
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setNo(memNo);
		
		ModelAndView mav = new ModelAndView();
		try {
			List<CategoryDTO> cat_list = projService.getCategoryList(memberDTO);
			mav.setViewName("siteAdd");
			mav.addObject("cat_list", cat_list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping(value="/siteAddAction")
	public ModelAndView siteAddAction(HttpSession session, 
										@RequestParam("no") long catNo, 
										@RequestParam("title") String title,
										@RequestParam("link") String link,
										@RequestParam("content") String content) {
		long memNo = Long.parseLong((String) session.getAttribute("member_no"));
		
		SiteDTO siteDTO = new SiteDTO();
		siteDTO.setTitle(title);
		siteDTO.setLink(link);
		siteDTO.setContent(content);
		siteDTO.setCategory_no(catNo);
			
		ModelAndView mav = new ModelAndView();
		try {
			projService.siteAdd(siteDTO);
			mav.setViewName("redirect:site?no="+ catNo);
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("result");
			mav.addObject("url", "javascript:history.back();");
		}
		return mav;
	}
	
	@RequestMapping(value="/siteDeleteAction")
	public ModelAndView siteDeleteAction(HttpSession session, @RequestParam("linkNo") long linkNo, @RequestParam("catNo") long catNo) {
		long memNo = Long.parseLong((String) session.getAttribute("member_no"));
		
		SiteDTO siteDTO = new SiteDTO();
		siteDTO.setNo(linkNo);
		siteDTO.setCategory_no(catNo);
		
		//alert 창(삭제하시겠습니까 yes or no)에 따른 코드 작성 예정..
		
		ModelAndView mav = new ModelAndView();
		try {
			projService.siteDelete(siteDTO);
			mav.setViewName("redirect:site?no=" + catNo);
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("result");
			mav.addObject("url", "javascript:history.back();");
		}
		return mav;
	}
}

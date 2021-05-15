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
		System.out.println("memNo2 : "+ memNo);
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
	public ModelAndView handleRquestInternal(HttpSession session, HttpServletRequest request) {
		long memNo = Long.parseLong((String) session.getAttribute("member_no"));
		long catNo = Long.parseLong(request.getParameter("no"));
		
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
			//mav.addObject("parse_site_list", parse_site_list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
}

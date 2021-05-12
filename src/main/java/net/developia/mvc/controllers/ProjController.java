package net.developia.mvc.controllers;

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
import net.developia.mvc.models.ProjDTO;
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
	public ModelAndView loginAction(@RequestParam("id") String id,@RequestParam("pwd") String pwd) throws Exception {
		ProjDTO projDTO = new ProjDTO();
		projDTO.setId(id);
		projDTO.setPwd(pwd);
		
		ModelAndView mav = new ModelAndView();
		try {
			projDTO = projService.loginMember(projDTO);
			System.out.println(projDTO);
			mav.setViewName("main");
			//HttpSession session = request.getSession(true);
			//String member_no = Long.toString(projDTO.getMemNo());
			//session.setAttribute("member_no", member_no);
			//long memNo = Long.parseLong((String) session.getAttribute("member_no"));
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("result");
			mav.addObject("msg", "로그인에 실패 하였습니다.");
			mav.addObject("url", "javascript:history.back();");
		}
		return mav;
	}
	
	@PostMapping(value="/signupAction")
	public ModelAndView signupAction(@RequestParam("id") String id,@RequestParam("pwd") String pwd, @RequestParam("email") String email ) throws Exception {
		ProjDTO projDTO = new ProjDTO();
		projDTO.setId(id);
		projDTO.setPwd(pwd);
		projDTO.setEmail(email);
		
		ModelAndView mav = new ModelAndView();
		try {
			projService.signupMember(projDTO);
			mav.setViewName("result");
			mav.addObject("msg", projDTO.getId()+"님 회원가입이 완료 되었습니다.");
			mav.addObject("url", "login");
			
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("result");
			mav.addObject("msg", "회원가입이 실패 하였습니다.");
			mav.addObject("url", "javascript:history.back();");
		}
		
		return mav;
	}
	
}

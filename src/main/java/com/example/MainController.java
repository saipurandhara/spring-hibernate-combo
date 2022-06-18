package com.example;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping("/insert")
	public ModelAndView insertion(HttpServletRequest req,HttpServletResponse res) {
		ModelAndView mv=new ModelAndView();
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
		Employee e=ac.getBean(Employee.class);
		Empdao dao=ac.getBean(Empdao.class);
		e.setEname(req.getParameter("ename"));
		e.setEemail(req.getParameter("eemail"));
		if(dao.insert(e)>0) {
		mv.setViewName("success.jsp");
		}
		else {
		mv.setViewName("fail.jsp");
		}
		return mv;
	}
	
	
	@RequestMapping("/get")
	public ModelAndView getall(HttpServletRequest req,HttpServletResponse res) {
		ModelAndView mv=new ModelAndView();
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
		Employee e=ac.getBean(Employee.class);
		Empdao dao=ac.getBean(Empdao.class);
		List<Employee> list=dao.getall();
		if(list!=null) {
			mv.setViewName("display.jsp");
			mv.addObject("list", list);
		}
		return mv;
	}
	
	
}

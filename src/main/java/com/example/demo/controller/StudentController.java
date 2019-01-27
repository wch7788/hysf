package com.example.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.bean.Address;
import com.example.demo.bean.JwtUtil;
import com.example.demo.bean.Person;
import com.example.demo.bean.Student;
import com.example.demo.mapper.AddressMapper;
import com.example.demo.mapper.ClassMapper;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.util.POIUtil;


@Controller
public class StudentController {
   int studentid;
	@Autowired
	StudentMapper studentmapper;
	@Autowired
	AddressMapper addressmapper;
	@Autowired
	ClassMapper classmapper;
	
	
	//展示所有学生
	@RequestMapping(value="getStudent")
	public ModelAndView getStudent(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv=new ModelAndView();
		List<Student> list=studentmapper.FindAllStudent();
		
		
		mv.addObject("students",list );
		mv.setViewName("student");
		return mv;
		
     }
	
	
	
	//删除功能
	@RequestMapping(value="delete")
	public ModelAndView delete(HttpServletRequest request,HttpServletResponse response){
		int id=Integer.valueOf(request.getParameter("id"));
		addressmapper.delete(studentmapper.FindStudent(id).getAddress().getId());
		studentmapper.delete(id);
		return new ModelAndView("redirect:/getStudent");
		
	}
	
	//修改跳转页面
	
	@RequestMapping(value="update")
	public ModelAndView update(HttpServletRequest request,HttpServletResponse response){
		studentid=Integer.valueOf(request.getParameter("id"));
		ModelAndView mv=new ModelAndView();
		Student student=studentmapper.FindOneStudentById(studentid);
		mv.addObject("thisstudent", student);
		mv.setViewName("update");
		return mv;
		
	}
	
	//确定修改
	@RequestMapping(value="updateConfirm")
	public ModelAndView updateConfirm(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("123");
		HttpSession session=request.getSession();
		session.setAttribute("msg", "哈哈哈");
		return mv;
	}
	
	@RequestMapping(value="ceshi")
	public String ceshi(){
		System.out.println("wwwwww");
		return "test";
	}
	
	
	
	@RequestMapping(value="addAddress")
	public void addAddress(Address address){
		addressmapper.add(address);
		
	}
	@RequestMapping(value="ajax",method={RequestMethod.POST})
	@ResponseBody
	public Map<String, Object> getajax(HttpServletRequest request,HttpServletResponse response){
		String data=request.getParameter("data");
		Map<String, Object> map=new HashMap<>();
		map.put("one", "145");
		map.put("two", "酷酷酷");
		map.put("three", "琉璃");
	
		return map;
	}

	
	@RequestMapping(value="test")
	 @ResponseBody
	public void getClass(@RequestParam("file") MultipartFile file) throws IOException{
		List<String[]> monthSaleList=POIUtil.readExcel(file);
		System.out.println(monthSaleList.size());
		for(int i=0;i<monthSaleList.size();i++){
			String[] monthsale=monthSaleList.get(i);
			System.out.println(monthsale[0]+"---"+monthsale[1]+"----"+monthsale[2]);
		}
		
	}
	
	@RequestMapping(value="verify")
	 @ResponseBody
	public Map<String, Object> verify(String token,String id){
		Map<String, Object> map=new HashMap<>();
		String username=JwtUtil.getUsername(token);
		String userid=JwtUtil.getUserId(token);
		
		System.out.println(username+""+userid);
		
		map.put("istrue","success" );
		return map;
		
	}
	
	
	@RequestMapping(value="getajax",method={RequestMethod.POST})
	@ResponseBody
		public Map<String, Object>  getAjax(String data,HttpServletRequest request,HttpServletResponse response){
		Person p1=new Person("zs",22);
		Person p2=new Person("ls",23);
		List<Person> list=new ArrayList<>();
		list.add(p1);
		list.add(p2);
		System.out.println("wwww");
		
		Map<String, Object> map=new HashMap<>();
		System.out.println(data);
		
		String s=studentmapper.getmessage();
		map.put("three", s);
		return map;
	}
	
	
	
	
}

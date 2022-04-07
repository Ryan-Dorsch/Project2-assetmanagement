package com.revature.pms.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.revature.pms.bean.Users;
import com.revature.pms.service.UsersService;

@Controller
public class UsersController {

//	@Autowired
//	private UsersService usersService;
//
//	@RequestMapping(value = "/save", method = RequestMethod.POST)
//	public ModelAndView saveUsers(@ModelAttribute("command") Users userBean, BindingResult result) {
//		Users user = prepareModel(UsersBean);
//		usersService.addUsers(UsersBean);
//		return new ModelAndView("redirect:/add.html");
//	}
//
//	@RequestMapping(value = "/users", method = RequestMethod.GET)
//	public ModelAndView listUsers() {
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("users", prepareListofBean(UsersService.listUsers));
//		return new ModelAndView("usersList", model);
//	}
//
//	@RequestMapping(value = "/add", method = RequestMethod.GET)
//	public ModelAndView addUers(@ModelAttribute("command") Users usersBean, BindingResult result) {
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("users", prepareListofBean(UsersService.listUsers()));
//		return new ModelAndView("addUsers", model);
//	}
//
//	@RequestMapping(value = "/index", method = RequestMethod.GET)
//	public ModelAndView welcome() {
//		return new ModelAndView("index");
//	}
//
//	@RequestMapping(value = "/delete", method = RequestMethod.GET)
//	public ModelAndView editEmployee(@ModelAttribute("command") Users userBean, BindingResult result) {
//		UsersService.deleteUsers(prepareModel(UsersBean));
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("user", null);
//		model.put("users", prepareListofBean(UsersService.listUsers()));
//		return new ModelAndView("addUsers", model);
//	}
//
//	@RequestMapping(value = "/edit", method = RequestMethod.GET)
//	public ModelAndView deleteUser(@ModelAttribute("command") Employee employeeBean, BindingResult result) {
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("user", prepareUsersBean(UsersService.getUser(UsersBean.getId())));
//		model.put("users", prepareListofBean(UsersService.listUser()));
//		return new ModelAndView("addEmployee", model);
//	}
//
//	private Users prepareModel(Users users) {
//		Users user = new Users();
//		users.setName(users.getName());
//		users.setId(users.getId());
//		users.setId(null);
//		return users;
//	}
//
//	private List<Users> prepareListofUsers(List<Users> users) {
//		List<Users> beans = null;
//		if (users != null && !users.isEmpty()) {
//			beans = new ArrayList<Users>();
//			Users bean = null;
//			for (Users user : users) {
//				bean = new Users();
//				bean.setName(user.getName());
//				bean.setId(user.getId());
//				beans.add(bean);
//			}
//		}
//		return beans;
//	}
//
//	private Users prepareUsers(Users users) {
//		Users user = new Users();
//		users.setName(users.getName());
//		users.setId(users.getId());
//		return users;
//	}
}

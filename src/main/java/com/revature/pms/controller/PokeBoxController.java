package com.revature.pms.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.revature.pms.model.PokeBox;
import com.revature.pms.service.PokeBoxService;

@RestController
@RequestMapping("/api/pokebox")
@CrossOrigin(origins = "http://localhost:4200")
public class PokeBoxController {
	
	@Autowired
	private PokeBoxService pokeBoxService;
	
//	@RequestMapping(value = "/save", method = RequestMethod.POST)
//	public ModelAndView savePokeBox(@ModelAttribute("command") PokeBox pokeBoxBean, 
//			BindingResult result) {
//		PokeBox pokeBox = prepareModel(pokeBoxBean);
//		pokeBoxService.addPokeBox(pokeBox);
//		return new ModelAndView("redirect:/add.html");
//	}
//
//	@RequestMapping(value="/pokeBoxs", method = RequestMethod.GET)
//	public ModelAndView listPokeBoxs() {
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("pokeBoxs",  prepareListofBean(pokeBoxService.listPokeBoxss()));
//		return new ModelAndView("pokeBoxsList", model);
//	}
//
//	@RequestMapping(value = "/add", method = RequestMethod.GET)
//	public ModelAndView addPokeBox(@ModelAttribute("command") PokeBox pokeBoxBean,
//			BindingResult result) {
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("pokeBoxs",  prepareListofBean(pokeBoxService.listPokeBoxss()));
//		return new ModelAndView("addPokeBox", model);
//	}
//	
//	@RequestMapping(value = "/index", method = RequestMethod.GET)
//	public ModelAndView welcome() {
//		return new ModelAndView("index");
//	}
//	
//	@RequestMapping(value = "/delete", method = RequestMethod.GET)
//	public ModelAndView editPokeBox(@ModelAttribute("command") PokeBox pokeBoxBean,
//			BindingResult result) {
//		pokeBoxService.deletePokeBox(prepareModel(pokeBoxBean));
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("pokeBox", null);
//		model.put("pokeBoxs",  prepareListofBean(pokeBoxService.listPokeBoxss()));
//		return new ModelAndView("addPokeBox", model);
//	}
//	
//	@RequestMapping(value = "/edit", method = RequestMethod.GET)
//	public ModelAndView deletePokeBox(@ModelAttribute("command") PokeBox pokeBoxBean,
//			BindingResult result) {
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("pokeBox", preparePokeBoxBean(pokeBoxService.getPokeBox(pokeBoxBean.getBoxNumber())));
//		model.put("pokeBoxs",  prepareListofBean(pokeBoxService.listPokeBoxss()));
//		return new ModelAndView("addPokeBox", model);
//	}
//	
//	private PokeBox prepareModel(PokeBox pokeBoxBean){
//		PokeBox pokeBox = new PokeBox();
//		pokeBox.setBoxNumber(pokeBoxBean.getBoxNumber());
//		pokeBox.setTableId(pokeBoxBean.getTableId());
//		//pokeBoxBean.setId(null);
//		return pokeBox;
//	}
//	
//	private List<PokeBox> prepareListofBean(List<PokeBox> pokeBoxs){
//		List<PokeBox> beans = null;
//		if(pokeBoxs != null && !pokeBoxs.isEmpty()){
//			beans = new ArrayList<PokeBox>();
//			PokeBox bean = null;
//			for(PokeBox pokeBox : pokeBoxs){
//				bean = new PokeBox();
//				bean.setBoxNumber(pokeBox.getBoxNumber());
//				bean.setTableId(pokeBox.getTableId());
//				
//				beans.add(bean);
//			}
//		}
//		return beans;
//	}
//	
//	private PokeBox preparePokeBoxBean(PokeBox pokeBox){
//		PokeBox bean = new PokeBox();
//		bean.setBoxNumber(pokeBox.getBoxNumber());
//		bean.setTableId(pokeBox.getTableId());
//		return bean;
//	}
	@GetMapping
	public List<PokeBox> findAll() {
		// TODO Auto-generated method stub
		return pokeBoxService.findAll();
	}

	@GetMapping("/{id}")
	public PokeBox getPokeBox(@PathVariable int id) {
		// TODO Auto-generated method stub
		return pokeBoxService.findById(id);
	}

	@PostMapping
	public void addPokeBox(@RequestBody PokeBox pokeBox) {
		// TODO Auto-generated method stub
		pokeBoxService.addPokeBox(pokeBox);
	}
//	@PutMapping("/pokebox/{id}")
//	public void updateStudent(@PathVariable int id, @RequestBody PokeBox pokeBox) {
//		// TODO Auto-generated method stub
//		PokeBoxService.updatePokeBox(id, pokebox);
//	}
//
//	@DeleteMapping("/pokebox/{id}")
//	public void deletePokeBox(@PathVariable int id) {
//		// TODO Auto-generated method stub
//		PokeBoxService.deletePokeBox(id);
//	}
//
//	@DeleteMapping("/pokebox")
//	public void deleteAll() {
//		// TODO Auto-generated method stub
//		PokeBoxService.deleteAll();
//	}
//}
	
	
}

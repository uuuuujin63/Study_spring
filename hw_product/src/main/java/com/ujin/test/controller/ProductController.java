package com.ujin.test.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ujin.test.model.MemberDto;
import com.ujin.test.model.ProductDto;
import com.ujin.test.model.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/register")
	public String register() {
		return "/product/register";
	}
	
	@PostMapping("/register")
	public String register(ProductDto productDto, Model model, HttpSession session) throws Exception {
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		productDto.setUserid(memberDto.getUserid());
		System.out.println(productDto.toString());
		productService.registerProduct(productDto);
		return "redirect:/product/list";
	}
	
	@GetMapping("/list")
	public ModelAndView list(@RequestParam Map<String, String> map) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		List<ProductDto> list = productService.listProduct(map);
		mav.addObject("products", list);
		mav.setViewName("product/list");
		return mav;
	}
	
	@GetMapping("/modify")
	public ModelAndView modify(@RequestParam("pcode")	String pcode) throws Exception {
		ModelAndView mav = new ModelAndView();
		ProductDto productDto = productService.getProduct(pcode);
		mav.addObject("productinfo",productDto );
		mav.setViewName("product/modify");
		return mav;
	}
	
	@PostMapping("modify")
	public String modify(@RequestParam("productcode") String pcode, ProductDto productDto) throws Exception {
		productService.updateProduct(pcode, productDto);
		return "redirect:/product/list";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("pcode") String pcode ) throws Exception {
		productService.deleteProduct(pcode);
		return "redirect:/product/list";
	}

	
}

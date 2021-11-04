package com.ujin.product.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ujin.product.model.FileInfoDto;
import com.ujin.product.model.MemberDto;
import com.ujin.product.model.ProductDto;
import com.ujin.product.model.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/register")
	public String register() {
		return "/product/register";
	}
	
	@PostMapping("/register")
	public String register(ProductDto productDto, Model model, @RequestParam("upfile") MultipartFile[] files, HttpSession session, RedirectAttributes redirectAttributes) throws Exception {
		MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
		productDto.setUserid(memberDto.getUserid());
		
		if(!files[0].isEmpty()) {
			String realPath = servletContext.getRealPath("/upload");
			String today = new SimpleDateFormat("yyMMdd").format(new Date());
			String saveFolder = realPath + File.separator + today;
			
			File folder = new File(saveFolder);
			if (!folder.exists())
				folder.mkdirs();
			List<FileInfoDto> fileInfos = new ArrayList<FileInfoDto>();
			for (MultipartFile mfile : files) {
				FileInfoDto fileInfoDto = new FileInfoDto();
				String originalFileName = mfile.getOriginalFilename();
				if (!originalFileName.isEmpty()) {
					String saveFileName = UUID.randomUUID().toString()
							+ originalFileName.substring(originalFileName.lastIndexOf('.'));
					fileInfoDto.setFile_path_org(today);
					fileInfoDto.setFile_name(originalFileName);
					fileInfoDto.setSavefile_name(saveFileName);
					mfile.transferTo(new File(folder, saveFileName));
				}
				fileInfos.add(fileInfoDto);
			}
			productDto.setFileInfos(fileInfos);
		}
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

package com.SpringExample.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import com.SpringExample.hibernate.IProductService;
import com.SpringExample.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller()
@RequestMapping("productController")
public class ProductController {
	
	@Autowired
	IProductService productService;

	@RequestMapping("/getAllProduct")
	public ModelAndView getAllProducts() {
		//创建一个List集合用于接收Service层方法的返回值
		List<Product> results = productService.findAll();
		//创建一个ModelAndView对象 括号里面的参数是指定要跳转到哪个jsp页面
		ModelAndView mav = new ModelAndView("getAll");
		//通过addObject（）方法 我们把要存的值存了进去。
		mav.addObject("listProduct", results);
		//最后把ModelAndView对象返回出去
		return mav;
	}

	@RequestMapping("/getProductById")
	public ModelAndView getUserById(Integer pId) {
		ModelAndView mav = new ModelAndView("toUpd");
		Product product = productService.findProductById(pId);
		mav.addObject("product", product);
		return mav;

	}

	@RequestMapping("/updateProduct")
	public String update(Product product){
		productService.update(product);
		return "forward:getAllProduct";

	}

	@RequestMapping("/deleteProduct")
	public String del(Integer pId) {
		productService.delete(pId);
		return "forward:getAllProduct";
	}
}

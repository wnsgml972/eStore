package kr.ac.hansung.cse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.hansung.cse.model.Product;
import kr.ac.hansung.cse.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping
	public String adminPage() {
		return "admin";
	}
	
	@RequestMapping("/productInventory")
	public String getProducts(Model model) {  //controller  ->  model

		List<Product> products = productService.getProducts();
		model.addAttribute("products", products);
		
		return "productInventory";  //return view mapping
	}
	
	@RequestMapping(value="/productInventory/addProduct", method=RequestMethod.GET)
	public String addProduct(Model model) {  

		Product product = new Product();
		product.setCategory("��ǻ��");  //default �� ����

		model.addAttribute("product", product);
		
		return "addProduct";
	}
	
	@RequestMapping(value="/productInventory/addProduct", method=RequestMethod.POST)
	public String addProductPost(Product product) {  
		
		if ( !productService.addProduct(product) )
			System.out.println("Adding product cannot be done");
		
		return "redirect:/admin/productInventory"; //���� �ְ� �����ֱ� ���� ���� productInventory�� �Ѿ
	}
}

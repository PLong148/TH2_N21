package com.qlds.qlds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qlds.qlds.entity.Product;
import com.qlds.qlds.repository.ProductRepository;

@Controller
public class Products {
	@Autowired
	ProductRepository pr;
	//trả về dữ liệu và đưa lên web danh sách sản phẩm
	@GetMapping("/products")
	public String getProducts(Model model) {
		List<Product> products = pr.findAll();
		model.addAttribute("products", products);
		return "products";
	}
	
	//trả về trang update.jsp
	@GetMapping("/update")
	public String update(Model model) {
		return "update";
	}
	
	//lấy dữ liêu từ người dùng gửi lên, kiểm tra nếu đúng thì sẽ lưu vào database, sai thì ghi lỗi trên trang update
	@PostMapping("/update")
	public String updateProduct(Model model, @RequestParam String code,
			@RequestParam String description, @RequestParam Double price) {
		String url = "products";
		String message = "";
		if (price <= 0) {
			url = "update";
			message += "Nhap vao so lon hon 0 <\\br>";
		}

		Product product = pr.findOneByCode(code);
		if (product == null) {
			product = new Product();
			product.setCode(code);
			product.setDescription(description);
			product.setPrice(price);
		}
		else {
			product.setDescription(description);
			product.setPrice(price);
			message += "Da ton tai code nay";
			url = "update";
		}
		
		model.addAttribute("message", message);
		model.addAttribute("product", product);
		
		if (url.equals("products")) {
			pr.save(product);
			this.getProducts(model);
		}
		
		return url;
	}
	
	//kiểm tra sản phẩm phẩm có trong database không, nếu có trả về trang edit.jsp, không thì báo lỗi 
	@GetMapping("/edit")
	public String edit(Model model, @RequestParam String code) {
		Product product = pr.findOneByCode(code);
		if (product == null) {
			model.addAttribute("message", "Không tìm thấy sản phẩm");
			return "error";
		} else {
			model.addAttribute("product", product);
			return "edit";
		}
	}
	
	//kiểm tra nếu sản phẩm không có thì trả về lỗi, có thì kiểm tra price có thỏa mãn điều kiện không, 
	//không thì hiện lỗi và cần nhập lại, có thì update dữ liệu lên database
	@PostMapping("/edit")
	public String editProduct(Model model, @RequestParam String code,
			@RequestParam String description, @RequestParam Double price) {
		
		Product product = pr.findOneByCode(code);
		if (product == null) {
			model.addAttribute("message", "Không tìm thấy sản phẩm");
			return "error";
		} else {
			product.setDescription(description);
			product.setPrice(price);
		}
		if (price <= 0) {
			model.addAttribute("message", "Nhap vao so lon hon 0 <\\br>");
			model.addAttribute("product",product);
			return "edit";
		} 
		pr.deleteById(code);
		pr.save(product);
		return this.getProducts(model);
	}
	
	//kiểm tra sản phẩm có tồn tại không, không thì trả về lỗi không tìm thấy sản phẩm, có thì trả về trang delete
	@GetMapping("/confirmdelete")
	public String confirmDelete(Model model, @RequestParam String code) {
		Product product = pr.findOneByCode(code);
		if (product == null) {
			model.addAttribute("message", "Không tìm thấy sản phẩm");
			return "error";
		} else {
			model.addAttribute("product", product);
			return "delete";
		}
	}
	
	//kiểm tra sản phẩm có tồn tại không, không thì trả về lỗi không tìm thấy sản phẩm, có thì xóa dữ liệu khỏi database
	@GetMapping("/delete")
	public String delete(Model model, @RequestParam String code) {
		Product product = pr.findOneByCode(code);
		if (product == null) {
			model.addAttribute("message", "Không tìm thấy sản phẩm");
			return "error";
		} else {
			pr.deleteById(code);
			return this.getProducts(model);
		}
	}
	
}













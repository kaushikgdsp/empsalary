package com.shopping.productmanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController 
{

	@Autowired
	ProductService pService;
	
	
	@PostMapping(value="/api/product", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Product saveProduct(@RequestBody Product product)
	{
		return pService.saveProduct(product);
	}
	
	@GetMapping(value="/api/product/{code}")//, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Product fetchProductById(@PathVariable("code") int code)
	{
		Product p=new Product();
		p.setCode(code);
		
		return pService.fetchProduct(p);
		
	}
	
	@GetMapping(value="/api/product/{lPrice}/{uPrice}")//, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Product> fetchProductByPriceRange(@PathVariable("lPrice") double lPrice, @PathVariable("uPrice") double uPrice)
	{
		return pService.fetchByPriceBetween(lPrice, uPrice);
		
	}
		
}

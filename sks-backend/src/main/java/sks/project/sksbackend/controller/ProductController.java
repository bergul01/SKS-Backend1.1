package sks.project.sksbackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import sks.project.sksbackend.dto.ProductDto;
import sks.project.sksbackend.serviceBusiness.ProductService;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

	private ProductService productService;
	
	@GetMapping()
	public ResponseEntity<List<ProductDto>> getAllProduct(){
		
		List<ProductDto> product = productService.getAllProduct();
		
		return ResponseEntity.ok(product);
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long productId){
		
		ProductDto productDto = productService.getProductById(productId);
		
		return ResponseEntity.ok(productDto);
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") Long productId,@RequestBody ProductDto updateProduct){		
		
		ProductDto productDto = productService.updateProduct(productId, updateProduct);
		
		return ResponseEntity.ok(productDto);
	
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") Long productId){
		
		productService.deleteProduct(productId);
		
		return ResponseEntity.ok("Ürün silme işlemi başarılı");
		
	}
	
	@PostMapping()
	public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
		
		ProductDto savedProduct = productService.createProduct(productDto);
		
		return new ResponseEntity<>(savedProduct,HttpStatus.CREATED);
	
	}
	
	
	
}

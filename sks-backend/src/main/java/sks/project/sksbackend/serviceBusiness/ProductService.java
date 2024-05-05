package sks.project.sksbackend.serviceBusiness;

import java.util.List;

import sks.project.sksbackend.dto.ProductDto;

public interface ProductService {
	
	ProductDto getProductById(Long productId);
	
	List<ProductDto> getAllProduct();
	
	ProductDto updateProduct(Long productId, ProductDto updateProduct);
	
	void deleteProduct(Long productId);
	
	ProductDto createProduct(ProductDto productDto);
}

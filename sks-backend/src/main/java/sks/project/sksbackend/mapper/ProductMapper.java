package sks.project.sksbackend.mapper;

import sks.project.sksbackend.dto.ProductDto;
import sks.project.sksbackend.entities.Product;

public class ProductMapper {
	public static ProductDto mapToProductDto(Product product) {
		
		return new ProductDto(
					product.getId(),
					product.getProductName()
				);
	}
	
	public static Product mapToProduct(ProductDto productDto) {
		
		return new Product(
					productDto.getId(),
					productDto.getProductName()
				);
	}
}

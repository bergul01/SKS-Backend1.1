package sks.project.sksbackend.serviceBusiness.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import sks.project.sksbackend.dto.ProductDto;
import sks.project.sksbackend.entities.Product;
import sks.project.sksbackend.exception.ResourceNotFoundException;
import sks.project.sksbackend.mapper.ProductMapper;
import sks.project.sksbackend.repositoryDataAccess.ProductRepository;
import sks.project.sksbackend.serviceBusiness.ProductService;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{
	
	private ProductRepository productRepository;

	@Override
	public ProductDto getProductById(Long productId) {
		
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Verilen kimliğe sahip ürün mevcut değil" + productId));
			
			return ProductMapper.mapToProductDto(product);
		
	}

	@Override
	public List<ProductDto> getAllProduct() {
		
		List<Product> products = productRepository.findAll();
		
			return products.stream().map((product) -> ProductMapper.mapToProductDto(product)).collect(Collectors.toList());
		
	}

	@Override
	public ProductDto updateProduct(Long productId, ProductDto updateProduct) {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Verilen kimliğe sahip ürün mevcut değil" + productId));
		
		product.setProductName(updateProduct.getProductName());
		
		Product newProduct = productRepository.save(product);
		
		
		return ProductMapper.mapToProductDto(newProduct);
	}

	@Override
	public void deleteProduct(Long productId) {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Verilen kimliğe sahip ürün mevcut değil" + productId));
		
		productRepository.deleteById(productId);
		
	}

	@Override
	public ProductDto createProduct(ProductDto productDto) {
		
		Product product = ProductMapper.mapToProduct(productDto);
		
		Product savedProduct = productRepository.save(product);
		
		return ProductMapper.mapToProductDto(savedProduct);
	}
	
	
	

}

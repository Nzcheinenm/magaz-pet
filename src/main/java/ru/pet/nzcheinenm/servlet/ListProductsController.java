package ru.pet.nzcheinenm.servlet;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.pet.nzcheinenm.entity.Product;
import ru.pet.nzcheinenm.repository.ReactiveProductRepository;

import java.util.List;

@Scope (value = "session")
@Component (value = "listProducts")
@ELBeanName(value = "listProducts")
@Join(path = "/", to = "/product/product-list.jsf")
public class ListProductsController {
	@Autowired
	private ReactiveProductRepository productRepository;

	private List<Product> products;

	@Deferred
	@RequestAction
	@IgnorePostback
	public void loadData() {
		products = productRepository.findAll()
				.toStream()
				.toList();
	}

	public List<Product> getProducts() {
		return products;
	}

	public String delete(Product product) {
		productRepository.delete(product);
		loadData();
		return null;
	}
}

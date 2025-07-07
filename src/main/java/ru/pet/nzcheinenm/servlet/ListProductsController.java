package ru.pet.nzcheinenm.servlet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.spring6.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring6.context.webflux.ReactiveDataDriverContextVariable;
import ru.pet.nzcheinenm.entity.Product;
import ru.pet.nzcheinenm.repository.ReactiveProductRepository;

@Controller
@RequiredArgsConstructor
public class ListProductsController {
    private final ReactiveProductRepository productRepository;

    @GetMapping("/hello-products")
    public String getProducts(Model model) {
        IReactiveDataDriverContextVariable reactiveDataDrivenMode =
                new ReactiveDataDriverContextVariable(productRepository.findAll(), 1);

        model.addAttribute("products", reactiveDataDrivenMode);

        return "hello-products";
    }

    public String delete(Product product) {
        productRepository.delete(product);
//		loadData();
        return null;
    }
}

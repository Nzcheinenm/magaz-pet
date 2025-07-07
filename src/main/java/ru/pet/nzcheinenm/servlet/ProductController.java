package ru.pet.nzcheinenm.servlet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.pet.nzcheinenm.dto.entity.ProductDto;
import ru.pet.nzcheinenm.mapper.ProductMapper;
import ru.pet.nzcheinenm.repository.ReactiveProductRepository;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ReactiveProductRepository productRepository;
    private final ProductMapper productMapper;

    @GetMapping("/hello-save")
    public String save(Model model) {
        return "hello-save";
    }

    @PostMapping("/hello-save")
    public String save(@ModelAttribute("product") ProductDto product) {
        productRepository.save(productMapper.convert(product));
        return "redirect:/hello-products#";
    }

}

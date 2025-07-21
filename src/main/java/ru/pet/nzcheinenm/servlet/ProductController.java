package ru.pet.nzcheinenm.servlet;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import reactor.core.publisher.Mono;
import ru.pet.nzcheinenm.dto.entity.ProductDto;
import ru.pet.nzcheinenm.mapper.ProductMapper;
import ru.pet.nzcheinenm.repository.ProductRepository;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @GetMapping("/save")
    public String save(Model model) {
        model.addAttribute("product", ProductDto.builder().build()); // Создаем пустую модель для формы
        return "save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("product") ProductDto product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "home";
        } else {
            productRepository.save(productMapper.convert(product));
            return "redirect:/home";
        }
    }
}

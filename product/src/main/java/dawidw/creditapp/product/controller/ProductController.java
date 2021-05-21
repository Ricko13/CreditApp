package dawidw.creditapp.product.controller;

import dawidw.creditapp.product.model.CreateProductRequest;
import dawidw.creditapp.product.model.ProductDTO;
import dawidw.creditapp.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Long> createProduct(@RequestBody CreateProductRequest request) {
        return ResponseEntity.ok(productService.createProduct(request));
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getProductsForCreditIds(@RequestParam List<UUID> creditIds) {
        return ResponseEntity.ok(productService.getProductsForCreditIds(creditIds));
    }

}

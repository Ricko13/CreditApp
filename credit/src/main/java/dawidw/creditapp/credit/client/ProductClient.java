package dawidw.creditapp.credit.client;

import dawidw.creditapp.credit.model.product.CreateProductRequest;
import dawidw.creditapp.credit.model.product.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@FeignClient(value = "productclient", url = "${product.host}")
public interface ProductClient {

    @PostMapping("/products")
    void createProduct(@RequestBody CreateProductRequest request);

    @GetMapping("/products")
    List<ProductDTO> getProducts(@RequestParam List<UUID> creditIds);

}

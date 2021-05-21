package dawidw.creditapp.product.service;

import dawidw.creditapp.product.model.CreateProductRequest;
import dawidw.creditapp.product.model.ProductDTO;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    Long createProduct(CreateProductRequest request);

    List<ProductDTO> getProductsForCreditIds(List<UUID> creditIds);

}

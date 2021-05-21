package dawidw.creditapp.product.service;

import dawidw.creditapp.product.mapper.ProductMapper;
import dawidw.creditapp.product.model.CreateProductRequest;
import dawidw.creditapp.product.model.ProductDTO;
import dawidw.creditapp.product.repository.ProductRepository;
import dawidw.creditapp.product.vlaidator.ProductValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductValidator validator;
    private final ProductMapper mapper;

    @Override
    public Long createProduct(CreateProductRequest request) {
        validator.validate(request);
        return productRepository.save(mapper.toEntity(request)).getId();
    }

    @Override
    public List<ProductDTO> getProductsForCreditIds(List<UUID> creditIds) {
        return productRepository.getCustomersForCreditIds(creditIds).stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

}

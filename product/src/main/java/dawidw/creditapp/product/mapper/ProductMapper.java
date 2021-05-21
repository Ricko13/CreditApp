package dawidw.creditapp.product.mapper;

import dawidw.creditapp.product.model.CreateProductRequest;
import dawidw.creditapp.product.model.Product;
import dawidw.creditapp.product.model.ProductDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toDTO(Product product);

    Product toEntity(CreateProductRequest request);

}

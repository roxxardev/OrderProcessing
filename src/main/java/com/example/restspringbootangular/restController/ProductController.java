package com.example.restspringbootangular.restController;

import com.example.restspringbootangular.model.Product;
import com.example.restspringbootangular.service.product.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@Api(tags = "Products")
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ApiOperation(value = "Returns Page with products")
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    Page<Product> getProducts(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "size", defaultValue = "10") int size, Pageable pageable) {
        return productService.getAllByPage(pageable);
    }

    @ApiOperation(value = "Find product by id")
    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    ResponseEntity<Product> getProduct(@PathVariable long id) {
        return productService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @ApiOperation(value = "Delete product by id")
    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    ResponseEntity<?> deleteProduct(@PathVariable long id) {
        try {
            productService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @ApiOperation(value = "Add product")
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    ResponseEntity<Product> createEmployee(@RequestBody Product product) {
        try {
            Product addedProduct = productService.saveProduct(product);
            return ResponseEntity.created(new URI("/products/" + addedProduct.getId())).body(addedProduct);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}

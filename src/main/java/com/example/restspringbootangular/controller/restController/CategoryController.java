package com.example.restspringbootangular.controller.restController;

import com.example.restspringbootangular.model.Category;
import com.example.restspringbootangular.service.category.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "Categories")
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @ApiOperation(value = "Returns list of categories")
    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    List<Category> getCategories() {
        return categoryService.getAll();
    }

    @ApiOperation(value = "Find category by id")
    @RequestMapping(value = "/categories/{id}", method = RequestMethod.GET)
    ResponseEntity<Category> getCategory(@PathVariable long id) {
        return categoryService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


}

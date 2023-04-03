package com.example.thi.dto;

import com.example.thi.model.ProductType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class ProductDto implements Validator {
    private Integer id;

    @NotBlank(message = "Tên sản phẩm không được để trống.")
    @Size(min = 5, max = 50, message = "Tên sản phẩm phải từ 5 đến 50 kí tự.")
    private String name;

    @NotNull(message = "Giá sản phẩm không được để trống.")
    @Min(value = 100000, message = "Giá bắt đầu thấp nhất phải là 100.000 VNĐ.")
    private Integer price;

    @NotBlank(message = "Trạng thái không được để trống.")
    private String status;

    private ProductType productType;

    public ProductDto() {
    }

    public ProductDto(Integer id, String name, Integer price, String status, ProductType productType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
        this.productType = productType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDto productDto = (ProductDto) target;
    }
}

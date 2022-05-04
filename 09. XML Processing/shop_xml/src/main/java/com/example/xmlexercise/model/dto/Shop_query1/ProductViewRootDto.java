package com.example.xmlexercise.model.dto.Shop_query1;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductViewRootDto {

    @XmlElement(name = "product")
    private List<ProductWithSellerDto> products;

    public List<ProductWithSellerDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductWithSellerDto> products) {
        this.products = products;
    }

    @XmlRootElement(name = "product")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class ProductWithSellerDto {

        @XmlAttribute(name = "name")
        private String name;
        @XmlAttribute(name = "price")
        private BigDecimal price;

        @XmlAttribute(name = "seller")
        private String seller;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public String getSeller() {
            return seller;
        }

        public void setSeller(String seller) {
            this.seller = seller;
        }
    }
}

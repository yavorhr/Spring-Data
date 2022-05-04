package com.example.xmlexercise.model.dto.Shop_query3;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryRootDto {

    @XmlElement(name = "category")
    List<CategoryWithProductDetailsDto> categories;

    public List<CategoryWithProductDetailsDto> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryWithProductDetailsDto> categories) {
        this.categories = categories;
    }
}

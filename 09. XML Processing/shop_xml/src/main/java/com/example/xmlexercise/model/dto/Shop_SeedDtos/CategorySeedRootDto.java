package com.example.xmlexercise.model.dto.Shop_SeedDtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

//името на root елемента взимаме от categories.xml file
@XmlRootElement(name = "categories")
//къде ще слагаме допълнителните настройки
@XmlAccessorType(XmlAccessType.FIELD)
public class CategorySeedRootDto {

    @XmlElement(name = "category")
    private List<CategorySeedDto> categories;

    public List<CategorySeedDto> getCategories() {
        return categories;
    }

}

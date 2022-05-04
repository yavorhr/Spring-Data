package com.example.xmlexercise.model.dto.Shop_query2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserViewRootDto {

    @XmlElement(name = "user")
    private List<UserWithSoldProductsViewDto> users;

    public List<UserWithSoldProductsViewDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserWithSoldProductsViewDto> users) {
        this.users = users;
    }
}

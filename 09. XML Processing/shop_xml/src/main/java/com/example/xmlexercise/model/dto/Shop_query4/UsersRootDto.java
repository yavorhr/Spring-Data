package com.example.xmlexercise.model.dto.Shop_query4;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersRootDto {

    @XmlAttribute(name = "count")
    private int count;

    @XmlElement(name = "user")
    List<UserFullNameAndAge> users;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<UserFullNameAndAge> getUsers() {
        return users;
    }

    public void setUsers(List<UserFullNameAndAge> users) {
        this.users = users;
    }
}

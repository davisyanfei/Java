package com.lux.study.assist;

/**
 * @author: lux
 * @date: 2017/10/24 13:51
 */
public class UserInfo {
    private Integer id;
    private String name;

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

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + "'" +
        '}';
    }
}

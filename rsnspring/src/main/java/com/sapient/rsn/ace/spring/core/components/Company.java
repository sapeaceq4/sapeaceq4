package com.sapient.rsn.ace.spring.core.components;

import com.sapient.rsn.ace.spring.core.bean.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Ravdeep Singh on 25-02-2017.
 */

@Component
public class Company {
    private String name;

    @Autowired
    private Client clients;

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", clients=" + clients +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Client getClients() {
        return clients;
    }

    public void setClients(Client clients) {
        this.clients = clients;
    }
}

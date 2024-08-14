package com.devsuperior.aula.services;

import com.devsuperior.aula.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {


    public double total(Order order){
        return order.getBasic() * (order.getDiscount() / 100);
    }


}

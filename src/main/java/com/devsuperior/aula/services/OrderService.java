package com.devsuperior.aula.services;

import com.devsuperior.aula.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private FreteService freteService;
    public double total(Order order){
        double total = 0;
        double frete = freteService.shipment(order);
        total = order.getBasic() - (order.getBasic() * (order.getDiscount() / 100)) + frete;
        return total;
    }


}

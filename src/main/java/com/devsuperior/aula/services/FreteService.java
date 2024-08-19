package com.devsuperior.aula.services;

import com.devsuperior.aula.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class FreteService {

    public double shipment(Order order){
        if(order.getBasic() < 100){
            return 20;
        } else if(order.getBasic() >= 100 && order.getBasic() < 200){
            return  12;
        } else {
            return 0;
        }
    }
}

package com.promineotech.jeep.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.jeep.entity.Option;
import com.promineotech.jeep.entity.Order;
import com.promineotech.jeep.entity.OrderRequest;
import com.promineotech.jeep.service.JeepOrderService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultJeepOrderController implements JeepOrderController {

  
  @Autowired
  private JeepOrderService jeepOrderService; 
  
  
  @Override
  public Order createOrder(OrderRequest orderRequest) {
    log.info("Order={}", orderRequest);
    return jeepOrderService.createOrder(orderRequest);
  }


  @Override
  public Map<String, Object> deleteOption(String optionId) {
    jeepOrderService.deleteOption(optionId);
    return Map.of("Message" , "Option with ID=" + optionId + "successsfully deleted.");
  }


  @Override
  public Option updateOption(Option option) {
    log.info("Updating option {}", option);
    return JeepOrderService.updateOption(option);
  }

}
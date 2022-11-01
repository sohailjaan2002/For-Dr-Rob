package com.promineotechfinal.samsung.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotechfinal.samsung.entity.Order;
import com.promineotechfinal.samsung.entity.OrderRequest;
import com.promineotechfinal.samsung.service.SamsungOrderService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DefaultSamsungOrderController implements SamsungOrderController {
  
  @Autowired
  private SamsungOrderService samsungOrderService;

  @Override
  public Order createOrder(@Valid OrderRequest orderRequest) {
    log.info("Order={}", orderRequest);
    return samsungOrderService.creatOrder(orderRequest);
  }

}

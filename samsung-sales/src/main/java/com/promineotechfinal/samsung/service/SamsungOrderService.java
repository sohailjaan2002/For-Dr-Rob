package com.promineotechfinal.samsung.service;

import javax.validation.Valid;
import com.promineotechfinal.samsung.entity.Order;
import com.promineotechfinal.samsung.entity.OrderRequest;

public interface SamsungOrderService {

  
  Order creatOrder(@Valid OrderRequest orderRequest);

}

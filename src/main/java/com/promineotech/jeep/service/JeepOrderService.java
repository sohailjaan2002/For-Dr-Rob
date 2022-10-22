
package com.promineotech.jeep.service;

import com.promineotech.jeep.entity.OrderRequest;
import com.promineotech.jeep.entity.Option;
import com.promineotech.jeep.entity.Order;

public interface JeepOrderService {
  
  Order createOrder (OrderRequest orderRequest);

  /**
   * @param optionId
   */
  void deleteOption(String optionId);

  /**
   * @param option
   * @return
   */
   static Option updateOption(Option option) {
    // TODO Auto-generated method stub
    return null;
  } 
    
   

}

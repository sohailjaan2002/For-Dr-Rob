package com.promineotechfinal.samsung.service;

import java.util.List;
import com.promineotechfinal.samsung.entity.Samsung;
import com.promineotechfinal.samsung.entity.SamsungModel;



public interface SamsungSalesService {

  /**
   * @param model
   * @param type
   * @return
   */
  
  List<Samsung> fetchSamsung(SamsungModel model, String type);
  

}

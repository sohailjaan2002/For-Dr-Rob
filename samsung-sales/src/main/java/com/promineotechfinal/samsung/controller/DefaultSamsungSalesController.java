package com.promineotechfinal.samsung.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotechfinal.samsung.entity.Samsung;
import com.promineotechfinal.samsung.entity.SamsungModel;
import com.promineotechfinal.samsung.service.SamsungSalesService;
import lombok.extern.slf4j.Slf4j;

@RestController 
@Slf4j
public class DefaultSamsungSalesController implements SamsungSalesController {
  
  @Autowired
  private SamsungSalesService samsungSalesService;

  @Override
  public List<Samsung> fetchSamsung(SamsungModel model, String type) {
    log.info("model={}, type{}", model , type); // logging info (records HTTP request parameters to
                                                // the console)
    return samsungSalesService.fetchSamsung(model , type);
  }

}

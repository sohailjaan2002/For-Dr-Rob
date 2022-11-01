package com.promineotechfinal.samsung.service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.promineotechfinal.samsung.dao.SamsungSalesDao;
import com.promineotechfinal.samsung.entity.Samsung;
import com.promineotechfinal.samsung.entity.SamsungModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DefaultSamsungSalesService implements SamsungSalesService {
  
  @Autowired 
  private SamsungSalesDao samsungSalesDao;

  @Override
  public List<Samsung> fetchSamsung(SamsungModel model, String type) {
    log.info("The fetchSamsung method was called with model={} and trim={}" , model , type);
    
    List<Samsung> samsungs = samsungSalesDao.fetchSamsung(model , type);
    
    Collections.sort(samsungs);
    return samsungs ;
  }

}

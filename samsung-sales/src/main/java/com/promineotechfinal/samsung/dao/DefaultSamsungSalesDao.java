package com.promineotechfinal.samsung.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import com.promineotechfinal.samsung.entity.Samsung;
import com.promineotechfinal.samsung.entity.SamsungModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DefaultSamsungSalesDao implements SamsungSalesDao {

  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  @Override
  public List<Samsung> fetchSamsung(SamsungModel model, String type) {
    log.info("DAO: model={}, type={}", model, type);
    
 // @formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM models "
        + "WHERE model_id = :model_id  AND type_model = :type_model";
        //+ "AND type_level = :type_level";
    // @formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("model_id", model.toString());
    params.put("type_model", type);
    
    return jdbcTemplate.query(sql, params, new RowMapper<>() {

      @Override
      public Samsung mapRow(ResultSet rs, int rowNum) throws SQLException {
     // @formatter:off
        return Samsung.builder()
            .launchPrice(new BigDecimal(rs.getString("launch_price")))
            .modelId(SamsungModel.valueOf(rs.getString("model_id")))
            .modelPK(rs.getLong("model_pk"))
            .storageInGB(rs.getInt("storage_in_GB"))
            .typeModel(rs.getString("type_model"))
            .screenSize(rs.getInt("screen_size"))
            .build();
     // @formatter :on
      }});
  }

}

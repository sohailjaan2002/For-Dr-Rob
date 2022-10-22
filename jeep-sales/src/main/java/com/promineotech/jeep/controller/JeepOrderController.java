package com.promineotech.jeep.controller;

import java.util.Map;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.jeep.entity.Option;
import com.promineotech.jeep.entity.Order;
import com.promineotech.jeep.entity.OrderRequest;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.val;

@Validated
@RequestMapping("/orders")
@OpenAPIDefinition(info = @Info(title = "Jeep Order Service"),
servers = {@Server(url = "http://localhost:8080", description = "Local server.")})

public interface JeepOrderController {
  
//@formatter:off
  @Operation(
      summary = "Create an order for a Jeep",
      description = "Returns the created Jeep ",
      responses = { 
          @ApiResponse(
              responseCode = "201", 
              description = "The created Jeep is returned", 
              content = @Content(
              mediaType = "application/json", 
              schema = @Schema(implementation = Order.class))),
      },
          parameters = {
              @Parameter(
                  name = "orderRequest", 
                  required = false, 
                  description = "The order as JSON")
          })
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
 Order createOrder(@Valid @RequestBody OrderRequest orderRequest); 
  
  @DeleteMapping("/option")
  Map<String, Object> deleteOption(@RequestParam String optopnId);
  
 @PutMapping("/option")
  Option updateOption(@RequestBody Option option);
 
}
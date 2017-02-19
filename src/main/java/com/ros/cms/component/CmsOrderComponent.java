package com.ros.cms.component;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import com.ros.cms.dto.*;

@Component
public class CmsOrderComponent {

  public CmsOrderComponent() {
  }

  public String test() {
    return "hello from Component1";
  }

  public Order getCmsOrder(int num) {
    return new Order("testing order " + num);
  }

  public ArrayList<Order> getCmsOrders(int from, int to) {
    return IntStream.range(from, to)
             .mapToObj(i -> new Order("order " + i))
             .collect(Collectors.toCollection(ArrayList<Order>::new));
  }
}

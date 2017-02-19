package com.ros.cms.dto;

public class Order {
    private final String num;

    public Order(String num) {
        this.num = num;
    }

    public String getNum() {
        return num;
    }

    public String getStatus() {
      return "processing..";
    }
    
    public String toString() {
    	return "order#: " + num;
    }
}

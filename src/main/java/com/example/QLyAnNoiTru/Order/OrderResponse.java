package com.example.QLyAnNoiTru.Order;


import java.util.List;

public class OrderResponse {
    private List<Order> content;

    public OrderResponse(List<Order> content){
        this.content = content;
    }

    public List<Order> getContent(){
        return content;
    }

    public void setContent(List<Order> content){
        this.content = content;
    }
}

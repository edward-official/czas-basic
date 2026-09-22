package com.groupedward.artifactedward.order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);

}

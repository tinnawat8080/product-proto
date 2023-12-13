package com.example.productproto.controller;

import com.example.productproto.generated.CustomerOuterClass;
import com.example.productproto.model.Customer;
import com.example.productproto.model.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class CustomerController {


    @PostMapping("/orders/search-proto")
    CustomerOuterClass.Customer searchCustomerProductOrdersProto(@RequestBody CustomerOuterClass.Customer customer) {
        List<CustomerOuterClass.ProductOrder> productList = new ArrayList<>();
        UUID uuid = UUID.randomUUID();
        for (int i = 1; i <= 1000; i++ ) {
            CustomerOuterClass.ProductOrder product = CustomerOuterClass.ProductOrder.newBuilder()
                    .setProductId("P"+i)
                    .setOrderId("1011")
                    .setProductName("productName_"+i+"_"+uuid)
                    .setPrice(1.11f)
                    .build();
            productList.add(product);
        }
        customer = customer.toBuilder().addAllProductOrder(productList).build();
        return customer;
    }

    @PostMapping("/orders/search")
    Customer searchCustomerProductOrders(@RequestBody Customer customer) {
        List<Product> productList = new ArrayList<>();
        UUID uuid = UUID.randomUUID();
        for (int i = 1; i <= 1000; i++ ) {
            Product product = Product.builder()
                    .productId("P"+i)
                    .orderId("1011")
                    .productName("producName_"+i+"_"+uuid)
                    .price(1.11f)
                    .build();
            productList.add(product);
        }
        customer.setProductOrderList(productList);

        return customer;
    }


}

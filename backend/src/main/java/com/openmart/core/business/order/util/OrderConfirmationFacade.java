package com.openmart.core.business.order.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openmart.core.activemq.Producer;
import com.openmart.core.business.order.model.Order;
import com.openmart.core.business.order.model.OrderLine;
import com.openmart.core.business.product.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Endalkachew on 12-Jul-16.
 */
@Component
public class OrderConfirmationFacade {

    private static final String THANK_YOU = "Thank you for choosing openmart";
    private static final String ORDER_COMPLETED = "Your order is now being processed for shipping";
    private static final String PRODUCT_TITLE = "Product";
    private static final String QUANTITY = "Quantity";
    private static final String UNIT_PRICE = "Unit price";
    private static final String SUB_TOTAL = "Sub total";
    private static final String TOTAL = "Total";
    private static final String SEPARATOR = "-------------------------------------------------------------------------------------------";
    private static final String TAB = "\t\t";
    private static final String NEW_LINE = "\n\n";
    private static final String ORDER_SUMMARY = "Order summary";
    private static final String ORDER_CONFIRMATION = "Order confirmation";

    private static final String space = "                              ";


    @Autowired
    private Producer producer;

    public void sendConfirmationEmail(String emailAddress, Order order){

        ConfirmationEmail email = new ConfirmationEmail();
        StringBuilder emailBody = new StringBuilder();
        emailBody.append(ORDER_SUMMARY + NEW_LINE );
        emailBody.append(PRODUCT_TITLE + TAB + TAB + QUANTITY + TAB + UNIT_PRICE + TAB + SUB_TOTAL + NEW_LINE + SEPARATOR);

        for(OrderLine orderLine: order.getOrderLines()){
            Product product = orderLine.getProduct();
            emailBody.append(NEW_LINE );
            String title = product.getTitle();
            if(title.length() > space.length()){
                title = title.substring(0, space.length() - 10);
            }
            title = product.getTitle() + space.substring(space.length() - product.getTitle().length());
            emailBody.append( title + orderLine.getQuantity() + TAB + TAB + product.getPrice() + TAB + TAB + product.getPrice() * orderLine.getQuantity());
            emailBody.append(NEW_LINE);
        }
        emailBody.append(SEPARATOR);
        emailBody.append(NEW_LINE + TAB + TAB + TAB+ TAB + TAB + TOTAL + " = " + order.getTotalPrice());
        emailBody.append(NEW_LINE );
        emailBody.append(ORDER_COMPLETED + "\n" + THANK_YOU);

        email.setBody(emailBody.toString());
        email.setSubject(ORDER_CONFIRMATION);
        email.setSendTo(emailAddress);

        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonInString = mapper.writeValueAsString(email);
            producer.send(jsonInString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}

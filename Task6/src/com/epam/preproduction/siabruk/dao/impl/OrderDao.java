package com.epam.preproduction.siabruk.dao.impl;


import com.epam.preproduction.siabruk.entity.Bicycle;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;


public class OrderDao {

    private Map<Date, Map> orderList = new TreeMap<>();

    public void makeOrder(Date date, Map<Bicycle, Integer> basketList) {
        orderList.put(date, basketList);
        BasketDAO.clearBasket();
    }


    public void findByDurability(Date startDate, Date endDate) {
        orderList.forEach((key, value) -> {
            if (value != null && key.after(startDate) && key.before(endDate)) {
                System.out.println(key);
                value.forEach((k, v) -> System.out.println(k));
            }
        });
    }

    public Map<Date, Map> getOrderList() {
        return orderList;
    }

    public Date showOderByDate(Date date) {
        long difference = -1;
        Date trueDate = null;
        for (Map.Entry<Date, Map> entry : getOrderList().entrySet()) {
            long diff = Math.abs(date.getTime() - entry.getKey().getTime());
            if (difference == -1 || difference > diff) {
                difference = diff;
                trueDate = entry.getKey();
            }
        }
        if (trueDate != null) {
            System.out.println(orderList.get(trueDate) + "    " + trueDate.toString());
        } else {
            System.out.println("order not found");
            trueDate = new Date();
        }
        return trueDate;
    }
}

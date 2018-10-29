package entity;

import context.ProductContext;
import enumeration.Status;

import java.sql.Date;
import java.util.Map;

public class Order {
    private Status status;
    private String info;
    private Date date;
    private String login;
private Map<Integer, ProductContext> mapBasket;

    public Map<Integer, ProductContext> getMapBasket() {
        return mapBasket;
    }

    public void setMapBasket(Map<Integer, ProductContext> mapBasket) {
        this.mapBasket = mapBasket;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}

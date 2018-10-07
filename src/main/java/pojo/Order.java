package pojo;

import java.util.List;

public class Order {
    private Integer id;
    private User user;
    private List<Smartphone> smartphone;
    private DeliveryType deliveryType;
    private PaidType paidType;
    private ReceiveType receiveType;

    public Order() {
    }

    public Order(Integer id, User user, List<Smartphone> smartphone, DeliveryType deliveryType, PaidType paidType, ReceiveType receiveType) {
        this.id = id;
        this.user = user;
        this.smartphone = smartphone;
        this.deliveryType = deliveryType;
        this.paidType = paidType;
        this.receiveType = receiveType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Smartphone> getSmartphone() {
        return smartphone;
    }

    public void setSmartphone(List<Smartphone> smartphone) {
        this.smartphone = smartphone;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public PaidType getPaidType() {
        return paidType;
    }

    public void setPaidType(PaidType paidType) {
        this.paidType = paidType;
    }

    public ReceiveType getReceiveType() {
        return receiveType;
    }

    public void setReceiveType(ReceiveType receiveType) {
        this.receiveType = receiveType;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", smartphone=" + smartphone +
                ", deliveryType=" + deliveryType +
                ", paidType=" + paidType +
                ", receiveType=" + receiveType +
                '}';
    }
}

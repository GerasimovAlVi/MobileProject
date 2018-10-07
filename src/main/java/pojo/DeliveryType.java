package pojo;

public class DeliveryType {
    private int id;
    private String delivery;

    public DeliveryType() {
    }

    public DeliveryType(int id, String delivery) {
        this.id = id;
        this.delivery = delivery;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    @Override
    public String toString() {
        return "DeliveryType{" +
                "id=" + id +
                ", delivery='" + delivery + '\'' +
                '}';
    }
}

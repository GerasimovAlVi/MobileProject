package pojo;

public class PaidType {
    private int id;
    private String paid;

    public PaidType() {
    }

    public PaidType(int id, String paid) {
        this.id = id;
        this.paid = paid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    @Override
    public String toString() {
        return "PaidType{" +
                "id=" + id +
                ", paid='" + paid + '\'' +
                '}';
    }
}

package pojo;

public class ReceiveType {
    private int id;
    private String receive;

    public ReceiveType() {
    }

    public ReceiveType(int id, String receive) {
        this.id = id;
        this.receive = receive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReceive() {
        return receive;
    }

    public void setReceive(String receive) {
        this.receive = receive;
    }

    @Override
    public String toString() {
        return "ReceiveType{" +
                "id=" + id +
                ", receive='" + receive + '\'' +
                '}';
    }
}

package pojo;

import java.util.Objects;

public class Screen {
    private Integer id;
    private String name;

    public Screen() {
    }

    public Screen(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Screen{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Screen screen = (Screen) o;
        return Objects.equals(id, screen.id) &&
                Objects.equals(name, screen.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }
}

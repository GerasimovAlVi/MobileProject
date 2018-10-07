package pojo;

import java.util.Objects;

public class Smartphone {
    private Integer id;
    private String name;
    private double price;
    private int ram;
    private double diagonal;
    private String screenResolution;
    private double camera;
    private int rom;
    private int batteryCapacity;
    private String size;
    private String color;
    private int simCount;
    private double cameraFront;
    private Brand brand;
    private Screen screen;
    private int count;

    public Smartphone() {
    }

    public Smartphone(Integer id, String name, double price, int ram, double diagonal, String screenResolution, double camera, int rom, int batteryCapacity, String size, String color, int simCount, double cameraFront, Brand brand, Screen screen, int count) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.ram = ram;
        this.diagonal = diagonal;
        this.screenResolution = screenResolution;
        this.camera = camera;
        this.rom = rom;
        this.batteryCapacity = batteryCapacity;
        this.size = size;
        this.color = color;
        this.simCount = simCount;
        this.cameraFront = cameraFront;
        this.brand = brand;
        this.screen = screen;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }

    public String getScreenResolution() {
        return screenResolution;
    }

    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
    }

    public double getCamera() {
        return camera;
    }

    public void setCamera(double camera) {
        this.camera = camera;
    }

    public int getRom() {
        return rom;
    }

    public void setRom(int rom) {
        this.rom = rom;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSimCount() {
        return simCount;
    }

    public void setSimCount(int simCount) {
        this.simCount = simCount;
    }

    public double getCameraFront() {
        return cameraFront;
    }

    public void setCameraFront(double cameraFront) {
        this.cameraFront = cameraFront;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", ram=" + ram +
                ", diagonal=" + diagonal +
                ", screenResolution='" + screenResolution + '\'' +
                ", camera=" + camera +
                ", rom=" + rom +
                ", batteryCapacity=" + batteryCapacity +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", simCount=" + simCount +
                ", cameraFront=" + cameraFront +
                ", brand=" + brand +
                ", screen=" + screen +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Smartphone that = (Smartphone) o;
        return Double.compare(that.price, price) == 0 &&
                ram == that.ram &&
                Double.compare(that.diagonal, diagonal) == 0 &&
                Double.compare(that.camera, camera) == 0 &&
                rom == that.rom &&
                batteryCapacity == that.batteryCapacity &&
                simCount == that.simCount &&
                Double.compare(that.cameraFront, cameraFront) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(screenResolution, that.screenResolution) &&
                Objects.equals(size, that.size) &&
                Objects.equals(color, that.color) &&
                Objects.equals(brand, that.brand) &&
                Objects.equals(screen, that.screen);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, price, ram, diagonal, screenResolution, camera, rom, batteryCapacity, size, color, simCount, cameraFront, brand, screen);
    }
}

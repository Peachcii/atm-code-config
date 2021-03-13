package ku.ac.th.exam.newcar.model;

public class NewCar {
    private int id;
    private int carId;
    private String nameCar;
    private double price;

    public NewCar(int id, int carId, String nameCar, double price) {
        this.id = id;
        this.carId = carId;
        this.nameCar = nameCar;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getNameCar() {
        return nameCar;
    }

    public void setNameCar(String nameCar) {
        this.nameCar = nameCar;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

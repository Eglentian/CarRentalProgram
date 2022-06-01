package model;

public class Car {

    private Integer id;
    private String model;
    private Integer power;
    private String owner;
    private Integer price;

    public Car() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getPrice() { return price;
    }

    public void setPrice (Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + model + '\'' +
                ", role='" + power + '\'' +
                ", email='" + owner + '\'' +
                ", price ='" + price + '\'' +
                '}';
    }



    public Car(Integer id, String model, Integer power, String owner, Integer price) {
        this.id = id;
        this.model = model;
        this.power = power;
        this.owner = owner;
        this.price = price;


    }
}


package july29;

interface Vehicles{
    int tyres = 4;
    void drive();
}

class Car implements Vehicles{
    @Override
    public void drive() {
        System.out.println("This is a car");
    }
}

class Bike implements Vehicles{
    int tyres = 2;
    @Override
    public void drive() {
        System.out.println("This is a bike");
    }
}

public interface Interface_Ex {
    public static void main(String[] args) {
        Car car = new Car();
        System.out.println(car.tyres); // 4
        car.drive(); // This is a car

        Bike bike = new Bike();
        System.out.println(bike.tyres); // 2
        bike.drive(); // This is a bike
    }
}

import java.util.Random;

public class Vehicle {
    protected String brand;
    protected String model;
    protected int year;
    protected String engineType;

    private String registrationNumber;
    private boolean isRunning;

    public Vehicle() {
        this.brand = "Unknown";
        this.model = "Unknown";
        this.year = 0;
        this.engineType = "Unknown";
        this.registrationNumber = "UNREGISTERED";
        this.isRunning = false;
        System.out.println("Vehicle default constructor called");
    }

    public Vehicle(String brand, String model, int year, String engineType) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engineType = engineType;
        this.registrationNumber = generateRegistration();
        this.isRunning = false;
        System.out.println("Vehicle parameterized constructor called");
    }

    public void start() {
        isRunning = true;
        System.out.println("Vehicle started");
    }

    public void stop() {
        isRunning = false;
        System.out.println("Vehicle stopped");
    }

    public String getVehicleInfo() {
        return "Vehicle Info => Brand: " + brand +
               ", Model: " + model +
               ", Year: " + year +
               ", Engine: " + engineType +
               ", Reg: " + registrationNumber +
               ", Running: " + isRunning;
    }

    public void displaySpecs() {
        System.out.println("Specs => Engine: " + engineType + ", Year: " + year);
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        if (registrationNumber != null && !registrationNumber.isEmpty()) {
            this.registrationNumber = registrationNumber;
        }
    }

    public boolean isRunning() {
        return isRunning;
    }

    private String generateRegistration() {
        Random r = new Random();
        int num = 100000 + r.nextInt(900000);
        return "IND-" + num;
    }

    public static void main(String[] args) {
        System.out.println("--- Default Car ---");
        Car c1 = new Car();
        c1.displaySpecs();
        System.out.println(c1.getVehicleInfo());
        c1.start();
        c1.stop();
        c1.openTrunk();
        c1.playRadio();

        System.out.println("\n--- Parameterized Car ---");
        Car c2 = new Car("Maruti Suzuki", "Swift", 2022, "Inline-4", 4, "Petrol", "Manual");
        System.out.println("Accessing protected fields: " + c2.brand + " " + c2.model);
        c2.displaySpecs();
        c2.start();
        System.out.println("Running? " + c2.isRunning());
        c2.stop();

        System.out.println("\n--- Polymorphism Demo ---");
        Vehicle v = new Car("Tata", "Altroz", 2023, "Inline-3", 4, "Petrol", "Automatic");
        v.displaySpecs();
        v.start();
        v.stop();
    }
}

class Car extends Vehicle {
    private int numberOfDoors;
    private String fuelType;
    private String transmissionType;

    public Car() {
        super();
        this.numberOfDoors = 4;
        this.fuelType = "Petrol";
        this.transmissionType = "Manual";
        System.out.println("Car default constructor called");
    }

    public Car(String brand, String model, int year, String engineType,
               int numberOfDoors, String fuelType, String transmissionType) {
        super(brand, model, year, engineType);
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        System.out.println("Car parameterized constructor called");
    }

    @Override
    public void start() {
        super.start();
        System.out.println("Car systems check OK, AC ready, Infotainment booted");
    }

    @Override
    public void displaySpecs() {
        super.displaySpecs();
        System.out.println("Car Specs => Doors: " + numberOfDoors +
                           ", Fuel: " + fuelType +
                           ", Transmission: " + transmissionType);
    }

    public void openTrunk() {
        System.out.println("Trunk opened");
    }

    public void playRadio() {
        System.out.println("Radio playing music");
    }
}

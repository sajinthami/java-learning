class Dog {
    // Instance variables
    String name;
    String color;

    // Parameterized constructor
    Dog(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public static void main(String[] args) {
        // Creating an object and passing values to the constructor
        Dog dog = new Dog("Buddy", "Brown");

        // Printing the values
        System.out.println("Dog's Name: " + dog.name);
        System.out.println("Dog's Color: " + dog.color);
    }
}
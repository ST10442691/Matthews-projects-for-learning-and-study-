package animal;

public class Demo {
  public static void main(String[] args) {
        // Create an array of Animal objects (including both Dog and Cat)
        Animal[] animals = new Animal[3];
        animals[0] = new Dog("Buddy");
        animals[1] = new Cat("Whiskers");
        animals[2] = new Dog("Max");

        // Iterate through the array and make each animal sound
        for (Animal animal : animals) {
            System.out.println("Name: " + animal.getName());
            animal.makeSound(); // Call the makeSound method (polymorphism in action)
            System.out.println();
        }
    } 
}


package animal;


// Create a subclass "Dog" that extends "Animal"
class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " barks: Woof! Woof!");
    }
}

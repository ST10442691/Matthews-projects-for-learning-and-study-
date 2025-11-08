
package animal;


// Create a subclass "Cat" that extends "Animal"
class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " meows: Meow! Meow!");
    }
}

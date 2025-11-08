
package animal;

// Define a superclass called "Animal"
class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void makeSound() {
        System.out.println("Make some noise for my animal");
    }
}



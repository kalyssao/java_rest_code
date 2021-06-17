// Classes - basic unit of OOP; describe entities within a domain & associated attributes/methods
// Objects - instances of classes; flesh out the attributes
public class Person {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    // Built in method for printing - we would get the object's memory location if not defined
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name){
        this.name = name;
    }

    public static void main(String[] args) {
        // New keyword tells the compiler to allocate memory for your object
        Person samuel = new Person("Samuel", 21);
        Person kalyssa = new Person("Kalyssa");

        System.out.println(kalyssa);
    }
}

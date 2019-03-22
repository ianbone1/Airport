public class Person {

    private String name;
    private int bags;

    public Person(String name, int numberBags){
        this.name=name;
        this.bags=numberBags;
    }

    public String getName() {
        return this.name;
    }

    public int getBags() {
        return this.bags;
    }
}

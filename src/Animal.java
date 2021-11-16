public class Animal {
    private String name;
    private String desc;
    private String type;
    private int age;

    public Animal(String name, String desc, String type, int age) {
        this.name = name;
        this.desc = desc;
        this.type = type;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return  this.type;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return name + " the " + desc + " " + type + ", age " + age;
    }



}

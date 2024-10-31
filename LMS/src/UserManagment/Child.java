package UserManagment;

public class Child {
    private Client Parent;
    private String Name;
    private int Age;

    public Child(Client Parent, String Name, int Age) {
        this.Parent = Parent;
        this.Name = Name;
        this.Age = Age;
    }

    public Client getParent() {
        return Parent;
    }

    public void setParent(Client Parent) {
        this.Parent = Parent;
    }

    public String getName() {
        return Name;
    }

    public void setAge(int age) {
        Age = age;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }
}

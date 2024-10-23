package UserManagment;

public class Child {
    Client Parent;

    public Child(Client Parent) {
        this.Parent = Parent;
    }

    public Client getParent() {
        return Parent;
    }

    public void setParent(Client Parent) {
        this.Parent = Parent;
    }
}

public class Passenger {

    private String name;
    private String email;
    private int passengerId;

    public Passenger(String name, String email, int passengerId) {
        this.name = name;
        this.email = email;
        this.passengerId = passengerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setId(int passengerId) {
        this.passengerId = passengerId;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", passengerId=" + passengerId +
                '}';
    }
}

public class Passenger {

    private String name;
    private String email;
    private int passengerId;

    public Passenger(String name, String email, int passengerId) {
        this.name = name;
        this.email = email;
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

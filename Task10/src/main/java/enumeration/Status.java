package enumeration;

public enum Status {
    ACCEPTED("accepted"), CONFIRMED("confirm"), fORMED("formed");

    public String status;

    Status(String status) {
        this.status = status;
    }
}

package AssignmentFive;

public abstract class Contractor extends Employee {
    private int workingHours;

    public Contractor(String name, int paymentPerHour, int workingHours) {
        super(name, paymentPerHour);
        this.workingHours = workingHours;
    }

    public int calculateSalary() {
        return super.getPaymentPerHour() * workingHours * 20;
    }
}

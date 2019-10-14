package AssignmentFive;

public class MyIndexOutOfBoundException {
    public int lowerBound;
    public int upperBound;
    public int index;

    public void indexOutOfBoundException(int lowerBound, int upperBound, int index) {
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
        this.index = index;

        if (index > upperBound || index < lowerBound)
            throw new RuntimeException("Error Message: Index: " + index + ", but Lower bound: " + lowerBound + ", Upper bound: " + upperBound);
    }

    public static void main(String[] args) {
        try {
            MyIndexOutOfBoundException i = new MyIndexOutOfBoundException();
            i.indexOutOfBoundException(0, 9, 10);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

package AssignmentFive;


import java.text.ParseException;
import java.util.Date;

public class Dog extends Pet implements Boardable {
    private String size;
    private Time start;
    private Time end;

    Dog(String name, String ownerName, String color, String size) {
        super(name, ownerName, color);
        this.size = size;
    }

    String getSize() {
        return size;
    }

    public String toString() {
        return getPetName() + " owned by " + getOwnerName() + "\nColor: " + getColor() + "\nSex: " + getSex() + "\nSize: " + getSize();
    }

    @Override
    public void setBoardStart(int month, int day, int year) {
        start.month = month;
        start.day = day;
        start.year = year;
    }


    @Override
    public void setBoardEnd(int month, int day, int year) {
        end.month = month;
        end.year = year;
        end.day = day;
    }

    @Override
    public boolean boarding(int month, int day, int year) {
        if (month < 1 || month > 12) {
            throw new RuntimeException("invalid Month");
        }
        if (day < 1 || day > 31) {
            throw new RuntimeException("invalid day");
        }
        if (year < 1000 || year > 9999) {
            throw new RuntimeException("invalid year");
        }
        try {
            Date current = Time.dateFormat.parse(year + "-" + month + "-" + day);
            if (current.compareTo(start.getDate()) >= 0 && current.compareTo(end.getDate()) <= 0)
                return true;
        } catch (ParseException e) {
            System.out.println(e.toString());
        }

        return false;
    }
}

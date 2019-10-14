package AssignmentFive;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

class Time {
    public int month;
    public int day;
    public int year;
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Date getDate() throws ParseException {
        String time = year + "-" + month + "-" + day;
        return dateFormat.parse(time);
    }
}

public class Cat extends Pet implements Boardable {
    private String hairLength;
    private Time start;
    private Time end;

    Cat(String name, String ownerName, String color, String hairLength) {
        super(name, ownerName, color);
        this.hairLength = hairLength;
    }

    String getHairLength() {
        return hairLength;
    }

    public String toString() {
        return getPetName() + " owned by " + getOwnerName() + "\nColor: " + getColor() + "\nSex: " + getSex() + "\nHair: " + getHairLength();
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

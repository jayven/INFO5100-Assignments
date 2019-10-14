package AssignmentFive;

import java.util.HashMap;
import java.util.Map;

public class Pet {
    private String name;
    private String ownerName;
    private String color;
    private static int sexid;
    public static final int MALE = 1;
    public static final int FEMALE = 2;
    public static final int SPAYED = 3;
    public static final int NEUTERED = 4;

    public static Map<Integer, String> sexMap = Map.of(
            MALE, "MALE",
            FEMALE, "FEMALE",
            SPAYED, "SPAYED",
            NEUTERED, "NEUTERED"
    );

    Pet(String name, String ownerName, String color) {
        this.name = name;
        this.ownerName = ownerName;
        this.color = color;
    }

    public String getPetName() {
        return name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getColor() {
        return color;
    }

    public void setSex(int sexid) {
        this.sexid = sexid;
    }

    public String getSex() {
        return sexMap.get(sexid);
    }

    public String toString() {
        return getPetName() + " owned by " + getOwnerName() + "\nColor: " + getColor() + "\nSex: " + getSex();
    }

}

import java.util.ArrayList;
import java.util.List;

public class Course {
    private int courseId;
    private String courseName;
    private int maxCapacity;
    private int professorId;
    private double credits;
    private List<Integer> studentIds;

    Course(int courseId) {
        setCourseId(courseId);
    }

    Course(int courseId, int professorId) {
        setCourseId(courseId);
        setProfessorId(professorId);
    }

    Course(int courseId, int professorId, double credits) {
        setCourseId(courseId);
        setProfessorId(professorId);
        setCredits(credits);
    }

    public void registerStudent(int studentId) {
        this.studentIds.add(studentId);
    }

    //if course has reached the maximum capacity
    public List<Integer> removeDuplicates(int[] studentIds) {
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < studentIds.length; i++) {
            if (!temp.contains(studentIds[i])) {
                temp.add(studentIds[i]);
            }
        }
        return temp;
    }

    public int groupsOfStudents(int[] studentIds) {
        int count = 0;
        for (int i = 0; i < studentIds.length; i++) {
            for (int j = i + 1; j < studentIds.length; j++) {
                if ((studentIds[i] + studentIds[j]) % 2 == 0) {
                    count++;
                }
            }

        }
        return count;
    }


    private void setCourseId(int courseId) {
        if (courseId <= 0)
            throw new IllegalArgumentException("Course should be positive number");
        this.courseId = courseId;
    }

    public int getCourseId() {
        return courseId;
    }

    private void setCourseName(String courseName) {
        if (courseName.length() < 10 || courseName.length() > 60)
            throw new IllegalArgumentException("Course name length should be minimum 10 and maximum 60");
        this.courseName = courseName;
    }

    public String setCourseName() {
        return courseName;
    }

    private void setMaxCapacity(int maxCapacity) {
        if (maxCapacity < 10 || maxCapacity > 100)
            throw new IllegalArgumentException("Course capacity should not be less than 10 greater than 100");
        this.maxCapacity = maxCapacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    private void setProfessorId(int professorId) {
        if (String.valueOf(professorId).length() != 6)
            throw new IllegalArgumentException("professorId should be a six digit integer");
        this.professorId = professorId;
    }

    public int getProfessorId() {
        return professorId;
    }

    private void setCredits(double credits) {
        if (credits < 0.1 || credits >= 10)
            throw new IllegalArgumentException("credits should be a single digit but greater than 0.*/");
        this.credits = credits;
    }

    public double getCredits() {
        return credits;
    }

    private void setStudentIds(List<Integer> studentIds) {
        this.studentIds = studentIds;
    }

    public List<Integer> getStudentIds() {
        return studentIds;
    }


}

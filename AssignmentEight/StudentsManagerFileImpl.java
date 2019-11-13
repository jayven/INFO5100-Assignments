package AssignmentEight;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;




public class StudentsManagerFileImpl implements StudentsManager {

    private StudentsManager manager = new StudentsManagerMapImpl();
    private Map<String, Student> studentsMap = new HashMap<String, Student>();
    private String file = "students.txt";

    public StudentsManagerFileImpl() throws Exception {
        readDataFromFileAndAddToTheManager();
    }

    private void readDataFromFileAndAddToTheManager() throws Exception {
        File f = new File(file);
        if (f.exists() == false) {
            return;
        }
        FileInputStream fis = new FileInputStream(f);
        Scanner s = new Scanner(fis);
        while (s.hasNext()) {
            String l = s.nextLine();
            String[] tokens = l.split("\\|");
            Student student = new Student(tokens[0], tokens[1]);
            manager.addStudent(student);
        }

    }

    public void addStudentIntoMap(Student student) {
        String id = student.getId();
        Student s = studentsMap.get(id);
        if (s == null) {
            studentsMap.put(student.getId(), student);
        } else {

            throw new RuntimeException("Student with id -> " + id + " is already added");
        }

    }


    @Override
    public void addStudent(Student student) throws RuntimeException {
        manager.addStudent(student);
        writeIntoFile(student);
    }

    private void writeIntoFile(Student student) {
        try {
            FileOutputStream fos = new FileOutputStream(file, true);
            PrintStream ps = new PrintStream(fos);
            ps.println(student.getId() + "|" + student.getName());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteStudent(String id) {
        manager.deleteStudent(id);
        rewriteContentsIntoFile();
    }

    private void rewriteContentsIntoFile() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            PrintStream ps = new PrintStream(fos);
            for (Student s : manager.getStudents()) {
                ps.println(s.getId() + "|" + s.getName());
            }

        } catch (Exception e) {

        }
        try {
            fos.close();
        } catch (Exception e) {

        }

    }

    @Override
    public void modifyStudent(String id, Student student) {
        manager.modifyStudent(id, student);
        rewriteContentsIntoFile();

    }

    @Override
    public Student findStudent(String name) {
        return manager.findStudent(name);
    }

    @Override
    public int getStudentCount() {
        return manager.getStudentCount();
    }

    @Override
    public void display() {
        manager.display();

    }

    @Override
    public List<Student> getStudents() {
        return manager.getStudents();
    }

}
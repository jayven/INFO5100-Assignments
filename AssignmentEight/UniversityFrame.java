package AssignmentEight;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;


import AssignmentEight.Calculator.BaseFrame;


class StudentsModel implements TableModel {

    protected StudentsManager manager;

    public StudentsModel(StudentsManager manager) {
        this.manager = manager;
    }

    @Override
    public int getRowCount() {
        return manager.getStudentCount();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Roll Number";
        } else {
            return "Name";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {

        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student s = manager.getStudents().get(rowIndex);
        if (columnIndex == 0) {
            return s.getId();
        } else {
            return s.getName();
        }

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        // TODO Auto-generated method stub

    }

}

public class UniversityFrame extends BaseFrame {
    private void makeItVisible(){
        setSize(500,400);
        setVisible(true);
    }
    private JLabel rollLabel, nameLabel, genderLabel;
    private JTextField rollText, nameText;
    private JButton add, modify, delete, find;
    private JTable studentsTable;
    private JComboBox option;
    private StudentsModel model;

    @Override
    public void create() {
        rollLabel = new JLabel("Enter Roll Number : ");
        nameLabel = new JLabel("Enter Student Name : ");
        genderLabel = new JLabel("Gender : ");

        add = new JButton("Add");
        delete = new JButton("Delete");
        modify = new JButton("Modify");
        find = new JButton("Find");

        rollText = new JTextField(12);
        nameText = new JTextField(12);

        option = new JComboBox(new String[]{"Male","Female"});

        try {
            model = new StudentsModel(new StudentsManagerFileImpl());
        } catch (Exception e) {
        }

        studentsTable = new JTable(model);
    }

    @Override
    public void add(Container con) {
        BorderLayout b = new BorderLayout();
        con.setLayout(b);
        con.add(new JScrollPane(studentsTable), "South");
        addComponent(con);
    }


    private void addComponent(Container con) {
        GridLayout gl = new GridLayout(4, 2);
        con.setLayout(gl);
        JPanel panel = new JPanel();
        panel.add(rollLabel);
        panel.add(rollText);
        panel.add(nameLabel);
        panel.add(nameText);
        panel.add(genderLabel);
        panel.add(option);
        panel.add(add);
        panel.add(delete);
        panel.add(modify);
        panel.add(find);
        con.add(panel,BorderLayout.NORTH);
    }

    @Override
    public void addListeners() {
        add.addActionListener((e) -> addStudent());
        find.addActionListener((e) -> findStudent());
        delete.addActionListener((e) -> deleteStudent());
        modify.addActionListener((e) -> modifyStudent());
    }

    private void modifyStudent() {
        Student student = new Student();
        model.manager.modifyStudent(student.getId(),student);
        if ( student != null) {
            JOptionPane.showMessageDialog(this, "Student id: "+ student.getId() + "** modified **");
        }else {
            JOptionPane.showMessageDialog(this, "** student not found **");
        }
        studentsTable.updateUI();
    }

    private void deleteStudent() {
        Student student = new Student();
        model.manager.deleteStudent(student.getId());
        studentsTable.updateUI();
        JOptionPane.showMessageDialog(this,"Student" + student.getId() + " ** deleted **");
    }

    private void findStudent() {
        Student student = new Student();
        model.manager.findStudent(student.getName());
        if ( student != null) {
            JOptionPane.showMessageDialog(this, "Student id: "+ student.getId() + ", Student name: "+ student.getName());
        }else {
            JOptionPane.showMessageDialog(this, "** student not found **");
        }
    }

    private void addStudent() {
        Student student = new Student();
        model.manager.addStudent(student);
        studentsTable.updateUI();
        JOptionPane.showMessageDialog(this,"Student" + student.getId() + " ** added **");
    }


    public static void main(String[] args) {
        new UniversityFrame();

    }

}
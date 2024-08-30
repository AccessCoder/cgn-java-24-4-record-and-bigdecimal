package de.neuefische;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private List<StudentRecord> students = new ArrayList<>();

    public boolean addStudent(StudentRecord newStudent){
        return students.add(newStudent);
    }

    public StudentRecord getStudentById(String id){
        for (StudentRecord s:students ) {
            if (s.id().equals(id)){
                return s;
            }
        }
        return null;
    }

    public List<StudentRecord> getAllStudents(){
        return students;
    }

    public void removeStudent(String id){
        for (StudentRecord s: students){
            if (s.id().equals(id)){
                students.remove(s);
                break;
            }
        }
    }
}

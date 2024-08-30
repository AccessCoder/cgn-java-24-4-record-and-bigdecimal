package de.neuefische;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test
    void addStudent() {
        //GIVEN
        StudentService service = new StudentService();
        StudentRecord testStudent = new StudentRecord("1", "Tom", "Test", 22);
        //WHEN
        boolean actual = service.addStudent(testStudent);
        //THEN
        assertTrue(actual);
    }

    @Test
    void getStudentById_shouldReturnStudent_whenGivenValidId() {
        //GIVEN
        StudentService service = new StudentService();
        StudentRecord testStudent = new StudentRecord("1", "Tom", "Test", 22);
        service.addStudent(testStudent);
        //WHEN
        StudentRecord actual = service.getStudentById("1");
        //THEN
        assertEquals(testStudent, actual);
    }

    @Test
    void getStudentById_shouldReturnNull_whenGivenInvalidId() {
        //GIVEN
        StudentService service = new StudentService();
        StudentRecord testStudent = new StudentRecord("1", "Tom", "Test", 22);
        service.addStudent(testStudent);
        //WHEN
        StudentRecord actual = service.getStudentById("2");
        //THEN
        assertNull(actual);
    }

    @Test
    void getAllStudents_shouldReturnEmptyList_whenCalledInitially() {
        //GIVEN
        StudentService service = new StudentService();
        //WHEN
        List<StudentRecord> actual = service.getAllStudents();
        //THEN
        assertEquals(Collections.EMPTY_LIST, actual);
    }

    @Test
    void getAllStudents_shouldReturnFilledList_whenCalledAfterAdd() {
        //GIVEN
        StudentService service = new StudentService();
        StudentRecord testStudent = new StudentRecord("1", "Tom", "Test", 22);
        service.addStudent(testStudent);
        //WHEN
        List<StudentRecord> actual = service.getAllStudents();
        //THEN
        assertEquals(List.of(testStudent), actual);
    }

    @Test
    void removeStudent_shouldDeleteStudent_whenCalledWithValidId(){
        //GIVEN
        StudentService service = new StudentService();
        StudentRecord testStudent = new StudentRecord("1", "Tom", "Test", 22);
        service.addStudent(testStudent);
        //WHEN
        service.removeStudent("1");
        List<StudentRecord> actual = service.getAllStudents();
        //THEN
        assertEquals(Collections.EMPTY_LIST, actual);

    }
}
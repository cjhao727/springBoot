package com.jojo.dao;

import com.jojo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentDao {

    private static Map<Integer, Student> studentMap;

    static {
        studentMap = new HashMap<Integer, Student>(){
            {
                put(1, new Student(1, "Jay", "CIS"));
                put(2, new Student(2, "Jojo", "CIS"));
                put(3, new Student(3, "Dodo", "Finance"));
            }
        };
    }

    public Collection<Student> getAllStudents() {
        return studentMap.values();
    }

}

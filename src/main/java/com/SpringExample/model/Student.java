package com.SpringExample.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class Student implements Serializable {

    private String stuNo;
    private String stuName;
    private String sex;
    private String tel;
    private String email;

    //一对多
    private Set<StudentCourse> studentCourses;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Student)) {
            return false;
        }
        Student that = (Student) obj;
        if (that.getStuNo().equals(this.getStuNo()))
            return true;
        return false;

    }

    @Override
    public int hashCode() {
        return stuNo.hashCode();
    }
}

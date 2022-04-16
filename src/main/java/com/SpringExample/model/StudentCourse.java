package com.SpringExample.model;

import lombok.Data;

@Data
public class StudentCourse {

    private StudentCoursePK scPk;

    private String year;

    private String teacherName;

    private int score;

    private String remark;

    //多对一
    private Student student;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StudentCourse)) {
            return false;
        }
        StudentCourse that = (StudentCourse) obj;
        if (that.getScPk().getCourseNo().equals(this.getScPk().getCourseNo())
        && that.getScPk().getStuNo().equals(this.getScPk().getStuNo()))
            return true;
        return false;

    }

    @Override
    public int hashCode() {
        return scPk.hashCode();
    }

}

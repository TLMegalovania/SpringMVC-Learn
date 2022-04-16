package com.SpringExample.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class StudentCoursePK implements Serializable {


    private String stuNo;
    private String courseNo;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StudentCoursePK)) {
            return false;
        }
        StudentCoursePK that = (StudentCoursePK) obj;
        if (that.getCourseNo().equals(this.getCourseNo())
                && that.getStuNo().equals(this.getStuNo()))
            return true;
        return false;

    }

    @Override
    public int hashCode() {
        return 31 * stuNo.hashCode() + courseNo.hashCode();
    }

}

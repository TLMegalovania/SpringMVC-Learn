package com.SpringExample.model;

import lombok.Data;

@Data
public class Course {

    private String courseNo;
    private String courseName;
    private double xf;
    private String remark;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Course)) {
            return false;
        }
        Course that = (Course) obj;
        if (that.getCourseNo().equals(this.getCourseNo()))
            return true;
        return false;

    }

    @Override
    public int hashCode() {
        return courseNo.hashCode();
    }
}

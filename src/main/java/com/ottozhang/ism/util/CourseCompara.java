package com.ottozhang.ism.util;

import com.ottozhang.ism.dataModel.Course;

import java.util.Comparator;

/**
 * Created by zhangruoqiu on 2017/5/3.
 */
public class CourseCompara implements Comparator<Course> {
    public int compare(Course o1, Course o2) {
        return o1.getDatet().compareTo(o2.getDatet());
    }
}

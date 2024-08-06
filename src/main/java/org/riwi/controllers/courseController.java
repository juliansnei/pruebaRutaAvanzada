package org.riwi.controllers;

import org.riwi.entities.course;
import org.riwi.models.modelCourse;

import java.util.List;

public class courseController {
    modelCourse courseModel = new modelCourse();
    public course create(course request){
        return this.courseModel.create(request);
    }

    public course update(String query){
        return this.courseModel.update(query);
    }

    public List<course> readAll(int size, int numberPage) {
        return this.courseModel.readAll(size, numberPage);
    }
}

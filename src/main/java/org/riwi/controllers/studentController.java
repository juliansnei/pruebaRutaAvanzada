package org.riwi.controllers;

import org.riwi.entities.student;
import org.riwi.models.modelStudent;

import java.util.List;

public class studentController {
    modelStudent studentModel = new modelStudent();
    public student create(student request){
        return this.studentModel.create(request);
    }

    public student update(String query){
        return this.studentModel.update(query);
    }

    public List<student> readAll(int size, int numberPage) {
        return this.studentModel.readAll(size, numberPage);
    }
}

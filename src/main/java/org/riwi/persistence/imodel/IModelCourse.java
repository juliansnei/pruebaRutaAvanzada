package org.riwi.persistence.imodel;

import org.riwi.persistence.crud.createModel;
import org.riwi.persistence.crud.updateModel;
import org.riwi.persistence.crud.readAllModel;
import org.riwi.entities.course;
public interface IModelCourse extends createModel<course>, updateModel<String,course>, readAllModel<course>{
}

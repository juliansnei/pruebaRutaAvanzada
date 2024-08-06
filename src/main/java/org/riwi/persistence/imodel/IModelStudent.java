package org.riwi.persistence.imodel;

import org.riwi.persistence.crud.createModel;
import org.riwi.persistence.crud.updateModel;
import org.riwi.persistence.crud.readAllModel;
import org.riwi.entities.student;
public interface IModelStudent extends createModel<student>, updateModel<String,student>, readAllModel<student>{

}

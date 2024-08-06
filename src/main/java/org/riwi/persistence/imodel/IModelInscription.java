package org.riwi.persistence.imodel;

import org.riwi.entities.inscription;
import org.riwi.persistence.crud.createModel;
import org.riwi.persistence.crud.readAllModel;
import org.riwi.persistence.crud.updateModel;

public interface IModelInscription  extends createModel<inscription>, updateModel<String,inscription>, readAllModel<inscription> {
}

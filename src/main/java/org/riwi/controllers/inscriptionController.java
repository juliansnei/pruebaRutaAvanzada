package org.riwi.controllers;

import org.riwi.entities.inscription;
import org.riwi.models.modelInscription;

import java.util.List;

public class inscriptionController {
    modelInscription inscriptionModel = new modelInscription();
    public inscription create(inscription request){
        return this.inscriptionModel.create(request);
    }

    public inscription update(String query){
        return this.inscriptionModel.update(query);
    }

    public List<inscription> readAll(int size, int numberPage) {
        return this.inscriptionModel.readAll(size, numberPage);
    }
}

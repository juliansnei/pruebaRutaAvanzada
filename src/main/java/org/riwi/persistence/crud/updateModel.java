package org.riwi.persistence.crud;

public interface updateModel<Query,Entity> {
    public Entity update(Query query);
}

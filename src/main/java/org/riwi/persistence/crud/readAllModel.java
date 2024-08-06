package org.riwi.persistence.crud;
import java.util.List;
public interface readAllModel <Entity>{
    public List<Entity> readAll(int size, int numberPage);
}

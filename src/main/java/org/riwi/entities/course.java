package org.riwi.entities;

public class course {
    private String name;

    public course() {
    }

    public course(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "course{" +
                ", name='" + name + '\'' +
                '}';
    }
}

package com.springapp.mvc.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Yurii on 04.01.2016.
 */
@Entity
@Table(name = "disinfectant_solution", schema = "", catalog = "endo")
public class DisinfectantSolution {
    private int id;
    private String name;
    private float size;
    private Collection<Revisions> revisionsesById;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSize(Float size) {
        this.size = size;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "size")
    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DisinfectantSolution that = (DisinfectantSolution) o;

        if (id != that.id) return false;
        if (Float.compare(that.size, size) != 0) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (size != +0.0f ? Float.floatToIntBits(size) : 0);
        return result;
    }

    @OneToMany(mappedBy = "disinfectantSolutionByDisinfectantSolutionId")
    public Collection<Revisions> getRevisionsesById() {
        return revisionsesById;
    }

    public void setRevisionsesById(Collection<Revisions> revisionsesById) {
        this.revisionsesById = revisionsesById;
    }
}

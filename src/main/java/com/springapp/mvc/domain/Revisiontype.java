package com.springapp.mvc.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Yurii on 12.12.2015.
 */
@Entity
public class Revisiontype {
    private int id;
    private String revisionName;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "revisionName")
    public String getRevisionName() {
        return revisionName;
    }

    public void setRevisionName(String revisionName) {
        this.revisionName = revisionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Revisiontype that = (Revisiontype) o;

        if (id != that.id) return false;
        if (revisionName != null ? !revisionName.equals(that.revisionName) : that.revisionName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (revisionName != null ? revisionName.hashCode() : 0);
        return result;
    }
}

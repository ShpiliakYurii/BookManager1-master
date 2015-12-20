package com.springapp.mvc.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

/**
 * Created by Yurii on 12.12.2015.
 */
@Entity
public class Medicinecard {
    private int identifyCode;
    private String pib;
    private String adress;
    private Date burnDate;

    @Id
    @Column(name = "identifyCode")
    public int getIdentifyCode() {
        return identifyCode;
    }

    public void setIdentifyCode(int identifyCode) {
        this.identifyCode = identifyCode;
    }

    @Basic
    @Column(name = "pib")
    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    @Basic
    @Column(name = "adress")
    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Basic
    @Column(name = "burnDate")
    public Date getBurnDate() {
        return burnDate;
    }

    public void setBurnDate(Date burnDate) {
        this.burnDate = burnDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Medicinecard that = (Medicinecard) o;

        if (identifyCode != that.identifyCode) return false;
        if (adress != null ? !adress.equals(that.adress) : that.adress != null) return false;
        if (burnDate != null ? !burnDate.equals(that.burnDate) : that.burnDate != null) return false;
        if (pib != null ? !pib.equals(that.pib) : that.pib != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = identifyCode;
        result = 31 * result + (pib != null ? pib.hashCode() : 0);
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        result = 31 * result + (burnDate != null ? burnDate.hashCode() : 0);
        return result;
    }
}

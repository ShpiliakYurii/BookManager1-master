package com.springapp.mvc.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Yurii on 12.12.2015.
 */
@Entity
public class Revisions {
    private int id;
    private Integer cardid;
    private Timestamp date;
    private Integer revisionid;
    private Integer doctorid;
    private int medicinecardIdentifyCode;
    private int userId;
    private int revisionTypeId;
    private int revisionsId;
    private int revisionsUserId;
    private int revisionsRevisionTypeId;
    private Medicinecard medicinecardByMedicinecardIdentifyCode1;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "cardid")
    public Integer getCardid() {
        return cardid;
    }

    public void setCardid(Integer cardid) {
        this.cardid = cardid;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "revisionid")
    public Integer getRevisionid() {
        return revisionid;
    }

    public void setRevisionid(Integer revisionid) {
        this.revisionid = revisionid;
    }

    @Basic
    @Column(name = "doctorid")
    public Integer getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(Integer doctorid) {
        this.doctorid = doctorid;
    }

    @Basic
    @Column(name = "medicinecard_identifyCode")
    public int getMedicinecardIdentifyCode() {
        return medicinecardIdentifyCode;
    }

    public void setMedicinecardIdentifyCode(int medicinecardIdentifyCode) {
        this.medicinecardIdentifyCode = medicinecardIdentifyCode;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "revisionType_id")
    public int getRevisionTypeId() {
        return revisionTypeId;
    }

    public void setRevisionTypeId(int revisionTypeId) {
        this.revisionTypeId = revisionTypeId;
    }

    @Basic
    @Column(name = "revisions_id")
    public int getRevisionsId() {
        return revisionsId;
    }

    public void setRevisionsId(int revisionsId) {
        this.revisionsId = revisionsId;
    }

    @Basic
    @Column(name = "revisions_user_id")
    public int getRevisionsUserId() {
        return revisionsUserId;
    }

    public void setRevisionsUserId(int revisionsUserId) {
        this.revisionsUserId = revisionsUserId;
    }

    @Basic
    @Column(name = "revisions_revisionType_id")
    public int getRevisionsRevisionTypeId() {
        return revisionsRevisionTypeId;
    }

    public void setRevisionsRevisionTypeId(int revisionsRevisionTypeId) {
        this.revisionsRevisionTypeId = revisionsRevisionTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Revisions revisions = (Revisions) o;

        if (id != revisions.id) return false;
        if (medicinecardIdentifyCode != revisions.medicinecardIdentifyCode) return false;
        if (revisionTypeId != revisions.revisionTypeId) return false;
        if (revisionsId != revisions.revisionsId) return false;
        if (revisionsRevisionTypeId != revisions.revisionsRevisionTypeId) return false;
        if (revisionsUserId != revisions.revisionsUserId) return false;
        if (userId != revisions.userId) return false;
        if (cardid != null ? !cardid.equals(revisions.cardid) : revisions.cardid != null) return false;
        if (date != null ? !date.equals(revisions.date) : revisions.date != null) return false;
        if (doctorid != null ? !doctorid.equals(revisions.doctorid) : revisions.doctorid != null) return false;
        if (revisionid != null ? !revisionid.equals(revisions.revisionid) : revisions.revisionid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (cardid != null ? cardid.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (revisionid != null ? revisionid.hashCode() : 0);
        result = 31 * result + (doctorid != null ? doctorid.hashCode() : 0);
        result = 31 * result + medicinecardIdentifyCode;
        result = 31 * result + userId;
        result = 31 * result + revisionTypeId;
        result = 31 * result + revisionsId;
        result = 31 * result + revisionsUserId;
        result = 31 * result + revisionsRevisionTypeId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "medicinecard_identifyCode1", referencedColumnName = "identifyCode", nullable = false)
    public Medicinecard getMedicinecardByMedicinecardIdentifyCode1() {
        return medicinecardByMedicinecardIdentifyCode1;
    }

    public void setMedicinecardByMedicinecardIdentifyCode1(Medicinecard medicinecardByMedicinecardIdentifyCode1) {
        this.medicinecardByMedicinecardIdentifyCode1 = medicinecardByMedicinecardIdentifyCode1;
    }
}

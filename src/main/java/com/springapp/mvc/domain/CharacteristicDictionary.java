package com.springapp.mvc.domain;

import javax.persistence.*;

/**
 * Created by Yurii on 04.01.2016.
 */
@Entity
@Table(name = "characteristic_dictionary", schema = "", catalog = "endo")
public class CharacteristicDictionary {
    private int idCharacteristic;
    private String name;
    private Integer idFeatures;
    private Integer last;
    private Integer conclusionDictionaryId;

    public void setIdCharacteristic(Integer idCharacteristic) {
        this.idCharacteristic = idCharacteristic;
    }

    @Id
    @GeneratedValue
    @Column(name = "id_characteristic")
    public int getIdCharacteristic() {
        return idCharacteristic;
    }

    public void setIdCharacteristic(int idCharacteristic) {
        this.idCharacteristic = idCharacteristic;
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
    @Column(name = "id_features")
    public Integer getIdFeatures() {
        return idFeatures;
    }

    public void setIdFeatures(Integer idFeatures) {
        this.idFeatures = idFeatures;
    }

    @Basic
    @Column(name = "last")
    public Integer getLast() {
        return last;
    }

    public void setLast(Integer last) {
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CharacteristicDictionary that = (CharacteristicDictionary) o;

        if (idCharacteristic != that.idCharacteristic) return false;
        if (idFeatures != null ? !idFeatures.equals(that.idFeatures) : that.idFeatures != null) return false;
        if (last != null ? !last.equals(that.last) : that.last != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCharacteristic;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (idFeatures != null ? idFeatures.hashCode() : 0);
        result = 31 * result + (last != null ? last.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "conclusion_dictionary_id")
    public Integer getConclusionDictionaryId() {
        return conclusionDictionaryId;
    }

    public void setConclusionDictionaryId(Integer conclusionDictionaryId) {
        this.conclusionDictionaryId = conclusionDictionaryId;
    }
}

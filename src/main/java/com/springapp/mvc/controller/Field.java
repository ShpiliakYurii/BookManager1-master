package com.springapp.mvc.controller;

/**
 * Created by Yurii on 27.02.2016.
 */
public class Field {
    public static enum TYPES {INT, VARCHAR, DATE, TEXT, FK};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TYPES getType() {
        return type;
    }

    public void setType(TYPES type) {
        this.type = type;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isGeneratedValue() {
        return generatedValue;
    }

    public void setGeneratedValue(boolean generatedValue) {
        this.generatedValue = generatedValue;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    private String name;
    private TYPES type;
    private String caption;
    private String value;
    private boolean generatedValue;
    private boolean visible;
    private boolean fk;

    public boolean isFk() {
        return fk;
    }

    public void setFk(boolean fk) {
        this.fk = fk;
    }


    public String getFkTableName() {
        return fkTableName;
    }

    public void setFkTableName(String fkTableName) {
        this.fkTableName = fkTableName;
    }

    public String getFkField() {
        return fkField;
    }

    public void setFkField(String fkField) {
        this.fkField = fkField;
    }

    public String getFkFieldCaption() {
        return fkFieldCaption;
    }

    public void setFkFieldCaption(String fkFieldCaption) {
        this.fkFieldCaption = fkFieldCaption;
    }

    private String fkTableName;
    private String fkField;
    private String fkFieldCaption;

    public Field(String name, TYPES type, String caption, String value, boolean generatedValue, boolean visible) {
        this.name = name;
        this.type = type;
        this.caption = caption;
        this.value = value;
        this.generatedValue = generatedValue;
        this.visible = visible;
        this.fkFieldCaption = null;
        this.fkField = null;
        this.fkTableName = null;
    }

    public void setFk(String fkTableName, String fkField, String fkFieldCaption) {
        this.fkTableName = fkTableName;
        this.fkField = fkField;
        this.fkFieldCaption = fkFieldCaption;
    }
}

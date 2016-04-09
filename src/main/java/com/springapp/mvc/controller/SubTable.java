package com.springapp.mvc.controller;

/**
 * Created by Yurii on 16.03.2016.
 */
public class SubTable extends Table {

    private String relationCaption;
    private String fk;
    public SubTable(Table t, String relationCaption, String fk){
        super(t.getTableName(), t.getCaption(), t.getTableRepository());
        this.relationCaption = relationCaption;
        this.fk = fk;
    }

    @Override
    public String browseCaptions(){
        String res = "<div class=\"col-sm-12 top-border\">";
        Field f;
        int columnCount = getVisibleCount()+1;
        int columnSize = (int) 12 / columnCount;
        //captions
        for (int i = 0; i < getFields().size(); i++) {
            f = getFields().get(i);
            if (f.isVisible()) {
                res += "<div class=\"col-sm-" + columnSize + "\">";
                res += f.getCaption();
                res += "</div>";
            }
        }
        res += "<div class=\"col-sm-" + columnSize + "\">";
        res += "Дія";
        res += "</div>";
        res += "</div>";
        return res;
    }

    @Override
    public String browseField(String idTable){
        String res = "<div class=\"col-sm-12 top-border\">";
        Field f;
        int columnCount = getVisibleCount();
        int columnSize = (int) 12 / columnCount;
        for (int i = 0; i < getFields().size(); i++) {
            f = getFields().get(i);
            if (f.isVisible()) {
                res += "<div class=\"col-sm-" + columnSize + "\">";
                res += "<a href='"+getUrl()+"edit/"+idTable+"/"+getIdFieldValue()+"'>";
                res += f.getValue();
                res += "</a>";
                res += "</div>";
            }
        }
        res += "<div class=\"col-sm-" + columnSize + "\">";
        res += "<a href='"+getUrl()+"browseSubTable/"+idTable+"/"+fk+"'>";
        res += relationCaption;
        res += "</a>";
        res += "</div>";
        res += "</div>";
        return res;
    }

}

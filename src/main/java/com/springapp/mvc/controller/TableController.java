package com.springapp.mvc.controller;

import com.springapp.mvc.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by Yurii on 03.03.2016.
 */
public class TableController {
    public TableRepository getTableRepository() {
        return tableRepository;
    }

    public void setTableRepository(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    private TableRepository tableRepository;

    public ArrayList<Table> getTables() {
        return tables;
    }

    public void setTables(ArrayList<Table> tables) {
        this.tables = tables;
    }

    private ArrayList<Table> tables;

    @Autowired
    public TableController(TableRepository tableRepository){
        this.tables = new ArrayList<Table>();
        this.tableRepository = tableRepository;
        //initTables();
    }

    public void initTables(){
        Table t = new Table("apparatus", "Апарати",tableRepository);
        t.addField(new Field("id", Field.TYPES.INT, "Ід", "", true, false ));
        t.addField(new Field("name", Field.TYPES.VARCHAR, "Назва", "", false, true ));
        this.tables.add(t);
        t = new Table("medicinecard1", "Пацієнти",tableRepository);
        t.addField(new Field("id", Field.TYPES.INT, "Ід", "", true, false ));
        t.addField(new Field("pib", Field.TYPES.VARCHAR, "ПІБ", "", false, true ));
        t.addField(new Field("adress", Field.TYPES.VARCHAR, "Адреса", "", false, true ));
        t.addField(new Field("burnDate", Field.TYPES.DATE, "Дата народження", "", false, true ));
        t.addField(new Field("identifyCode", Field.TYPES.VARCHAR, "Ідентифікаційний код", "", false, true ));
        this.tables.add(t);
    }

    @RequestMapping(value = "browse/{id}", method = RequestMethod.GET)
    public String browse(@PathVariable Integer id, Model model, HttpSession httpSession){
        Table t = this.tables.get(id);
        model.addAttribute("title", t.getCaption());
        model.addAttribute("text", t.browse(id+"") + t.insert(id+""));
        return "browse";
    }

    @RequestMapping(value = "browse/{idTable}/fieldName/{fieldName}/fieldValue/{fieldValue}/previousTableId/{previousTableId}", method = RequestMethod.GET)
    public String browse(@PathVariable String idTable, @PathVariable String fieldName,
                         @PathVariable String fieldValue, @PathVariable String previousTableId, Model model){
        Table t = this.tables.get(Integer.parseInt(idTable));
        model.addAttribute("title", t.getCaption());
        model.addAttribute("text", t.browse(idTable, fieldName, fieldValue, previousTableId) + t.insert(idTable, fieldValue,
                idTable+"/"+fieldName+"/"+fieldValue+"/"+previousTableId));
        return "browse";
    }

    @RequestMapping(value = "edit/{idTable}/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Integer idTable, @PathVariable Integer id,
                       Model model, HttpSession httpSession){
        Table t = this.tables.get(idTable);
        model.addAttribute("title", "Редагування"+t.getCaption());
        model.addAttribute("text", t.edit(idTable+"",id+"")+ t.delete(idTable+"", id+""));
        return "browse";
    }

    @RequestMapping(value = "execEdit/{idTable}/{id}", method = RequestMethod.POST)
    public String execEdit(@PathVariable Integer idTable, @PathVariable Integer id, Model model,
                           HttpServletRequest request, HttpSession httpSession){
        Table t = this.tables.get(idTable);
        t.execEdit(request, id+"");
        return browse(idTable, model, httpSession);
    }

    @RequestMapping(value = "insert/{idTable}", method = RequestMethod.GET)
    public String insert(@PathVariable Integer idTable, Model model, HttpSession httpSession){
        Table t = this.tables.get(idTable);
        model.addAttribute("title", "Добавити новий запис до " +t.getCaption());
        model.addAttribute("text", t.insert(idTable+""));
        return "browse";
    }

    @RequestMapping(value = "execInsert/{idTable}", method = RequestMethod.POST)
    public String execInsert(@PathVariable Integer idTable, Model model, HttpSession httpSession,
                             HttpServletRequest request){
        Table t = this.tables.get(idTable);
        t.execInsert(request);
        return browse(idTable, model, httpSession);
    }
    @RequestMapping(value = "execInsert1/{idTable}", method = RequestMethod.POST)
    public String execInsert1(@PathVariable Integer idTable, Model model, HttpSession httpSession,
                             HttpServletRequest request){
        Table t = this.tables.get(idTable);
        t.execInsert(request);
        String url = request.getParameter("url").toString();
        String[] m = url.split("/");
        System.out.println(m[0]+"/"+m[1]+"/"+m[2]+"/"+m[3]);
        return browse(m[0],m[1],m[2],m[3],model);
    }

    @RequestMapping(value = "delete/{idTable}/{id}", method = RequestMethod.GET)
    public String execDelete(@PathVariable Integer idTable, @PathVariable Integer id, Model model,
                             HttpSession httpSession){
        Table t = this.tables.get(idTable);
        t.delete(id+"");
        return browse(idTable, model, httpSession);
    }
}

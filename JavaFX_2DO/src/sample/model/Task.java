package sample.model;

import java.time.LocalDate;

public class Task {
    //atributos das Tasks
    private String task;
    private LocalDate datecreate;
    private String descricao;
    
    //Construtor padrão das Tasks
    public Task(){

    }

    //Construtor Principal das Tasks
    public Task(String task, LocalDate datecreate, String descricao) {
        this.task = task;
        this.datecreate = datecreate;
        this.descricao = descricao;
    }

    //metódos gets and sets:
    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public LocalDate getDatecreate() {
        return datecreate;
    }

    public void setDatecreate(LocalDate datecreate) {
        this.datecreate = datecreate;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}

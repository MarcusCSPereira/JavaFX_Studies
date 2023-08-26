package sample.model;

public class Task {
    //atributos das Tasks
    private String task;
    private long datecreate;
    private String descricao;
    
    //Construtor padrão das Tasks
    public Task(){

    }

    //Construtor Principal das Tasks
    public Task(String task, long datecreate, String descricao) {
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

    public long getDatecreate() {
        return datecreate;
    }

    public void setDatecreate(long datecreate) {
        this.datecreate = datecreate;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}

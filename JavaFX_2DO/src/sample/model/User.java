package sample.model;

public class User {
    //atributos de um usuário:
    private String primeiroNome;
    private String sobrenome;
    private String nomeDeUsuario;
    private String senha;
    private String local;
    private String genero;

    //Construtor padrão da Classe:
    public User(){

    }

    //Construtor principal da Classe:
    public User(String primeiroNome, String sobrenome, String nomeDeUsuario, String senha, String local, String genero) {
        this.primeiroNome = primeiroNome;
        this.sobrenome = sobrenome;
        this.nomeDeUsuario = nomeDeUsuario;
        this.senha = senha;
        this.local = local;
        this.genero = genero;
    }

    //metódos get and set:
    public String getPrimeiroNome() {
        return primeiroNome;
    }
    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSobrenome() {
        return sobrenome;
    }
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNomeDeUsuario() {
        return nomeDeUsuario;
    }
    public void setNomeDeUsuario(String nomeDeUsuario) {
        this.nomeDeUsuario = nomeDeUsuario;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }

    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
}

public class Persona {

    private String name;
    private String surname;
    private String fc;
    private String email;

    public Persona(String name, String cognome, String fc){
        this.name=name;
        surname=cognome;
        this.fc=fc;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getSurname(){
        return surname;
    }
    public String getFC(){
        return fc;
    }
    public void setName(String name){
        /*vari controlli su name */
        this.name=name;
    }
    //overloading
    public String toString(){
        return "Nome: "+name+"\nCognome: "+surname+"\nCodice fiscale: "+fc;
    }
}

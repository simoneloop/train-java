import java.util.ArrayList;

public class Database {
    
    private ArrayList<Persona> db;

    public Database(){
        db=new ArrayList<>();
    }

    public void addPersona(Persona p)throws RuntimeException{
        /*ulteriori controlli */
        if(existByFC(p.getFC())){
            throw new RuntimeException("codice fiscale già esistente");
        }
        else{
            db.add(p);
        }
        
    }
    public Persona findByFC(String fc){
        for(int i=0;i<db.size();i++){
            Persona tmp=db.get(i);
            if(tmp.getFC().equals(fc)){
                return tmp;
            }
        }
        return null;
    }

    public void removeByFc(String fc)throws RuntimeException{
        Persona tmp=findByFC(fc);
        if(tmp==null){
            throw new RuntimeException("la persona con codice fiscale: "+fc+" non esiste");
        }
        else{
            db.remove(tmp);
        }
    }
    public boolean existByFC(String fc){
        for (Persona p:db){
            if(p.getFC().equals(fc)){
                return true;
            }
        }
        return false;
    }

    
    public String toString(){
        String ret="";
        ret+="Il database è costituito da:\n";
        ret+="\n";
        for(Persona p: db){
            ret+=p.toString()+"\n";
            ret+="---\n";
        }
        return ret;
    }
}

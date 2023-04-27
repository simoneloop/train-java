import java.util.Scanner;

public class main {
    

    public static void main(String [] args){
        final String COMM1="add";
        final String COMM2="removeFC";
        final String COMM3="showDB";
        Persona p1=new Persona("Simone", "Lopez", "1");
        Persona p2=new Persona("Mario", "Rossi", "2");
        Persona p3=new Persona("Giordano", "Bruno", "3");
        Database db=new Database();
        db.addPersona(p1);
        db.addPersona(p2);
        db.addPersona(p3);
        System.out.println(db.toString());

        //System.out.println(db.findByFC("3"));
        try {
            db.removeByFc("3");
        } catch (RuntimeException e) {
            System.out.println("non è stato possibile aggiungere l'utente, eccezione: "+e.toString());
        }
        
        System.out.println(db.toString());
        Scanner sc=new Scanner(System.in);
        boolean run=true;
        String welcome="";
        welcome+="Ciao! Benvenuto nel sistema di gestione di superumani\n";
        
        String legends="";
        legends+="seleziona una delle seguenti voci:\n";
        legends+="\n";
        legends+="1:"+COMM1+"(per aggiungere un nuovo superumano)\n";
        legends+="2:"+COMM2+"(per rimuovere un superumano)\n";
        legends+="3:"+COMM3+"(per avere la lista di tutti i superumani in giro)\n";
        System.out.println(welcome);
        while(run){
            System.out.println(legends);
            String command=sc.nextLine();
            if(command.equals(COMM1)){
                System.out.println("Inserisci le informazioni necessarie della persona");
                System.out.print("inserisci il nome: ");
                String name=sc.nextLine();
                System.out.print("Inserisci il cognome: ");
                String surname=sc.nextLine();
                System.out.print("Inserisci il codice fiscale: ");
                String fc=sc.nextLine();
                Persona pTmp=new Persona(name, surname, fc);
                try {
                    db.addPersona(pTmp);
                    System.out.println("persona aggiunta con successo");
                } catch (Exception e) {
                    System.out.println("non è stato possibile aggiungere la persona: "+e.toString());
                }
            }
            else if(command.equals(COMM2)){
                System.out.print("inserisci il codice fiscale da rimuovere: ");
                String fc=sc.nextLine();
                try {
                    db.removeByFc(fc);
                } catch (Exception e) {
                    System.out.println("non è stato possibile rimuovere: "+e.toString());
                }
            }
            else if(command.equals(COMM3)){
                System.out.println(db.toString());
            }
            System.out.println("vuoi continuare?y/n");
            String tmp=sc.nextLine();
            if(tmp.toLowerCase().equals("n")){
                run=false;
            }
        }

        
    }
    
}

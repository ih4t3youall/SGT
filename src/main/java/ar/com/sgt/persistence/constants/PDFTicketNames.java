package ar.com.sgt.persistence.constants;

import java.util.ArrayList;
import java.util.List;


public enum PDFTicketNames {
    
    NUMERO_TURNO("numeroTurno"),NOMBRE_TURNO("nombreTurno"),FECHA_TURNO("fechaTurno"),HORA_TURNO("horaTurno");
    
    private static List<String> names;
    
    static {
        names=new ArrayList<String>();
        for (PDFTicketNames formName:PDFTicketNames.values()){
            names.add(formName.getName());
        }
    }
    
    private String name;
    
    
    private PDFTicketNames(String formName) {
        name = formName;
    }
    
    /**
     * Checks if a name is valid for the Form.
     * @param name
     *              name to check if it is valid
     * @return boolean
     */
    protected static boolean isValidName(String name){
        return names.contains(name);
    }
    
    public String getName(){
        return this.name;
    }

}

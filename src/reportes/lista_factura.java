/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

/**
 *
 * @author ING.DARWIN GARCIA
 */
public class lista_factura {
    private String item;
    private String id_equipo;
    private String serial;
    private String diagnostico;
    private String descripcion;
    private String monto;
 
    //private String balance;

    public lista_factura(String item,String id_equipo, String serial, String diagnostico, String descripcion, String monto) {
     
        this.item = item;
        this.id_equipo = id_equipo;
        this.serial = serial;
        this.diagnostico = diagnostico;
        this.descripcion = descripcion;
        this.monto = monto;
       
  
    }
    public String getitem() {
        return item;
    }

    public void setid_item(String item) {
        this.item = item;
    }
    
     public String getid_equipo() {
        return id_equipo;
    }
     
      public void setid_equipo(String item) {
        this.id_equipo = id_equipo;
    }

    public String getserial() {
        return serial;
    }

    public void setserial(String serial) {
        this.serial = serial;
    }

    public String getdiagnostico() {
        return diagnostico;
    }

    public void setdiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getdescripcion() {
        return descripcion;
    }

    public void setdescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getmonto() {
        return monto;
    }
    public void setmonto(String monto) {
       this.monto = monto;
    } 
}

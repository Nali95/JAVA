package misiontic.reto4.model.vo;

public class ProyectoBancoVo { 
     private Integer id;
     private String ciudad;
     private String nombre;
     private String primerapellido;
     

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getCiudad() {
        return ciudad;
    }


    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getPrimerapellido() {
        return primerapellido;
    }


    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }


    @Override
    public String toString(){
        return String.format("%3d %-25s %-20s %-15s", id, ciudad,
        nombre, primerapellido) ;
    }
}
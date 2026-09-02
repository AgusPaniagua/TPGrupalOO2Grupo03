package negocio;

import dao.StaffDao;
import datos.Staff;
import datos.Cocinero;
import datos.Cajero;
import datos.UnidadDeVenta;
import java.time.LocalDate;
import java.util.List;
import datos.UnidadDeVenta;

public class StaffABM {
    StaffDao dao = new StaffDao();

    public Staff traer(long idStaff) {
        Staff s = dao.traer(idStaff);
        return s;
    }

    public int agregarCocinero(String nombre, String apellido, int dni, LocalDate fechaDeNacimiento, LocalDate fechaDeIngreso, int antiguedad, double sueldoBase, UnidadDeVenta unidadDeVenta, String especialidad, int plusFijo) {
        Cocinero c = new Cocinero(nombre, apellido, dni, fechaDeNacimiento, fechaDeIngreso, antiguedad, sueldoBase, unidadDeVenta, especialidad, plusFijo);
        return dao.agregar(c);
    }

    public int agregarCajero(String nombre, String apellido, int dni, LocalDate fechaDeNacimiento, LocalDate fechaDeIngreso, int antiguedad, double sueldoBase, UnidadDeVenta unidadDeVenta, String turnoDeTrabajo) {
        Cajero c = new Cajero(nombre, apellido, dni, fechaDeNacimiento, fechaDeIngreso, antiguedad, sueldoBase, unidadDeVenta, turnoDeTrabajo);
        return dao.agregar(c);
    }

    public void modificar(Staff s) {
        dao.actualizar(s);
    }

    public void eliminar(long idStaff) {
        Staff s = dao.traer(idStaff);
        dao.eliminar(s);
    }
    
    public List<UnidadDeVenta> traerUnidadesConPersonal() {
        return dao.traerUnidadesConPersonal();
    }
    
}
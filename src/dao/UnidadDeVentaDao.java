package dao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import datos.UnidadDeVenta;

public class UnidadDeVentaDao {
    private static Session session;
    private Transaction tx;
    private void iniciaOperacion() throws HibernateException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }
    private void manejaExcepcion(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("ERROR en la capa de acceso a datos", he);
    }
    public int agregar(UnidadDeVenta unidad){
        int id = 0;
        try{
            iniciaOperacion();
            id = Integer.parseInt(session.save(unidad).toString());
            tx.commit();
        }catch (HibernateException he){
            manejaExcepcion(he);
        }finally {
            session.close();
        }
        return id;
    }

    public void actualizar(UnidadDeVenta unidad){
        try{
            iniciaOperacion();
            session.update(unidad);
            tx.commit();
        }catch (HibernateException he){
            manejaExcepcion(he);
        }finally {
            session.close();
        }
    }

    public void eliminar(UnidadDeVenta unidad){
        try{
            iniciaOperacion();
            session.delete(unidad);
            tx.commit();
        }catch (HibernateException he){
            manejaExcepcion(he);
        }finally {
            session.close();
        }
    }

    public UnidadDeVenta traer(long idUnidadDeVenta){
        UnidadDeVenta unidad = null;
        try{
            iniciaOperacion();
            unidad = (UnidadDeVenta) session.get(UnidadDeVenta.class, idUnidadDeVenta);
        }finally {
            session.close();
        }
        return unidad;
    }

    public UnidadDeVenta traer(String codigoUnico){
        UnidadDeVenta unidad = null;
        try{
            iniciaOperacion();
            unidad = (UnidadDeVenta) session.createQuery("from UnidadDeVenta u where u.codigoUnico = :codigoUnico").setParameter("codigoUnico",codigoUnico).uniqueResult();
        }finally {
            session.close();
        }return unidad;
    }
}

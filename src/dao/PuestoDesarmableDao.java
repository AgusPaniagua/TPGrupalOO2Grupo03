package dao;

import datos.PuestoDesarmable;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PuestoDesarmableDao {
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

    public List<PuestoDesarmable> traerPorCantidadDeCarpas(int cantidadDeCarpas){
        List<PuestoDesarmable> lista = null;
        try{
            iniciaOperacion();
            lista = session.createQuery("from PuestoDesarmable p where p.cantidadDeCarpas = :cantidadDeCarpas", PuestoDesarmable.class).setParameter("cantidadDeCarpas", cantidadDeCarpas).list();
             tx.commit();
        }catch (HibernateException he){
            manejaExcepcion(he);
        }finally {
            session.close();
        }
        return lista;
    }
}



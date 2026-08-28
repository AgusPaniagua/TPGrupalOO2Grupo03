package dao;

import datos.FoodTruck;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FoodTruckDao {
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

    public FoodTruck traerPorPatente(String patente){
        FoodTruck ft = null;
        try {
            iniciaOperacion();
            ft = (FoodTruck) session.createQuery("from FoodTruck f where f.patente = :patente").setParameter("patente", patente).uniqueResult();
            tx.commit();
        }catch (HibernateException he){
            manejaExcepcion(he);
        }finally {
            session.close();
        }
        return ft;
    }

}

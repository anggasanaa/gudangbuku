/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Util.gudangUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Transaksi;
/**
 *
 * @author hello
 */
public class TransDAO {
      public List<Transaksi> getAll(){
        List<Transaksi> tList = new ArrayList<Transaksi>();
        Transaction trans = null;
        Session session = gudangUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            Query query = session.createQuery("from Transaksi");
            tList = query.list();
            trans.commit();
        } catch (Exception e){
            System.out.println(e);
        }
        session.close();
        return tList;
    }   
    
    public List<Transaksi> getById(Integer id){
        List<Transaksi> tList = new ArrayList();
        Transaksi t = new Transaksi();
        Transaction trans = null;
        Session session = gudangUtil.getSessionFactory().openSession();
        
        try{
            trans = session.beginTransaction();
            Query query = session.createQuery("from Transaksi where id=:id");
            query.setInteger("id",id);
            t = (Transaksi) query.uniqueResult();
            tList = query.list();
            trans.commit();
        } catch(Exception e){
            System.out.println(e);
        }
        session.close();
        return tList;
    }
    
    public void add(Transaksi t){
        Transaction trans = null;
        Session session = gudangUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(t);
            trans.commit(); 
        } catch (Exception e){
            System.out.println(e);
        }
        session.close();
    }
    
    public void delete(Integer id){
        Transaction trans = null;
        Session session = gudangUtil.getSessionFactory().openSession();
        
        try{
            trans = session.beginTransaction();
            Transaksi t = (Transaksi) session.load(Transaksi.class, new Integer(id));
            session.delete(t);
            trans.commit();
        }catch (Exception e){
            System.out.println(e);
        }
        session.close();
    }
    
    public void edit(Transaksi t){
        Transaction trans = null;
        Session session = gudangUtil.getSessionFactory().openSession();
        
        try{
            trans = session.beginTransaction();
            session.update(t);
            trans.commit();
        }catch (Exception e){
            System.out.println(e);
        }
        session.close();
    }  
}

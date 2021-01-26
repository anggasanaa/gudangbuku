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
import pojo.Pengiriman;

/**
 *
 * @author hello
 */
public class PengirimanDAO {
    public List<Pengiriman> getAll(){
        List<Pengiriman> pList = new ArrayList<Pengiriman>();
        Transaction trans = null;
        Session session = gudangUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            Query query = session.createQuery("from Pengiriman");
            pList = query.list();
            trans.commit();
        } catch (Exception e){
            System.out.println(e);
        }
        return pList;
    }   
    
    public List<Pengiriman> getById(Integer id){
        List<Pengiriman> pList = new ArrayList();
        Pengiriman p = new Pengiriman();
        Transaction trans = null;
        Session session = gudangUtil.getSessionFactory().openSession();
        
        try{
            trans = session.beginTransaction();
            Query query = session.createQuery("from Pengiriman where id=:id");
            query.setInteger("id",id);
            p = (Pengiriman) query.uniqueResult();
            pList = query.list();
            trans.commit();
        } catch(Exception e){
            System.out.println(e);
        }
        session.close();
        return pList;
    }
    
    public void add(Pengiriman peng){
        Transaction trans = null;
        Session session = gudangUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(peng);
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
            Pengiriman peng = (Pengiriman) session.load(Pengiriman.class, new Integer(id));
            session.delete(peng);
            trans.commit();
        }catch (Exception e){
            System.out.println(e);
        }
        session.close();
    }
    
    public void edit(Pengiriman peng){
        Transaction trans = null;
        Session session = gudangUtil.getSessionFactory().openSession();
       
        try{
            trans = session.beginTransaction();
            session.update(peng);
            trans.commit();
        }catch (Exception e){
            System.out.println(e);
        }
        session.close();
    }    
}

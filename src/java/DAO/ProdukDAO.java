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
import pojo.Produk;
/**
 *
 * @author hello
 */
public class ProdukDAO {
    public List<Produk> getAll(){
        List<Produk> prodList = new ArrayList<Produk>();
        Transaction trans = null;
        Session session = gudangUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            Query query = session.createQuery("from Produk");
            prodList = query.list();
            trans.commit();
        } catch (Exception e){
            System.out.println(e);
        }
        session.close();
        return prodList;
    }   
    
    public List<Produk> getById(Integer id){
        List<Produk> prodList = new ArrayList();
        Produk prod = new Produk();
        Transaction trans = null;
        Session session = gudangUtil.getSessionFactory().openSession();
        
        try{
            trans = session.beginTransaction();
            Query query = session.createQuery("from Produk where id=:id");
            query.setInteger("id",id);
            prod = (Produk) query.uniqueResult();
            prodList = query.list();
            trans.commit();
        } catch(Exception e){
            System.out.println(e);
        }
        session.close();
        return prodList;
    }
    
    public void add(Produk produk){
        Transaction trans = null;
        Session session = gudangUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(produk);
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
            Produk produk = (Produk) session.load(Produk.class, new Integer(id));
            session.delete(produk);
            trans.commit();
        }catch (Exception e){
            System.out.println(e);
        }
        session.close();
    }
    
    public void edit(Produk produk){
        Transaction trans = null;
        Session session = gudangUtil.getSessionFactory().openSession();
        
        try{
            trans = session.beginTransaction();
            session.update(produk);
            trans.commit();
        }catch (Exception e){
            System.out.println(e);
        }
        session.close();
    }  
}

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
import pojo.Admin;

/**
 *
 * @author hello
 */
public class AdminDAO {
        public List<Admin> alogin(String uName, String uPass){
        Transaction trans = null;
        Admin adm = new Admin();
        List<Admin> admin = new ArrayList();
        
        Session session = gudangUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Admin where username=:uName and password=:uPass");
            query.setString("uName", uName);
            query.setString("uPass", uPass);
            adm = (Admin) query.uniqueResult();
            admin = query.list();
            trans.commit();
        } catch (Exception e){
            System.out.println(e);
        } 
        session.flush();
        session.close();
        return admin;
    } 
}

package pojo;
// Generated Oct 26, 2020 7:55:38 PM by Hibernate Tools 4.3.1


import DAO.PengirimanDAO;
import DAO.TransDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
@RequestScoped
/**
 * Transaksi generated by hbm2java
 */
public class Transaksi  implements java.io.Serializable {


     private Integer id;
     private int pengirimanId;
     private int produkId;
     private int amount;
     private Date date;
     private String type;

    public Transaksi() {
    }

    public Transaksi(int pengirimanId, int produkId, int amount, Date date, String type) {
       this.pengirimanId = pengirimanId;
       this.produkId = produkId;
       this.amount = amount;
       this.date = date;
       this.type = type;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public int getPengirimanId() {
        return this.pengirimanId;
    }
    
    public void setPengirimanId(int pengirimanId) {
        this.pengirimanId = pengirimanId;
    }
    
    public int getProdukId() {
        return this.produkId;
    }
    
    public void setProdukId(int produkId) {
        this.produkId = produkId;
    }
    public int getAmount() {
        return this.amount;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    public List<Transaksi> getAllRecords(){
        List<Transaksi> tList = new ArrayList<Transaksi>();
        TransDAO t = new TransDAO();
        tList = t.getAll();
        return tList;
    }
    
    public String add(){
        TransDAO add = new TransDAO();
        add.add(this);
         return "transaksi";
    }

    public void getById() {     
        TransDAO t = new TransDAO();
        List<Transaksi> tList = t.getById(id);
        pengirimanId = tList.get(0).pengirimanId;
        produkId = tList.get(0).produkId;
        amount = tList.get(0).amount;
        date = tList.get(0).date;
        type = tList.get(0).type;
    }
    
        public void edit(){
        TransDAO t = new TransDAO();
        t.edit(this);
        pengirimanId = pengirimanId;
        produkId = produkId;
        amount = amount;
        date = date;
        type = "";
        FacesMessage facesMessages = new FacesMessage(FacesMessage.SEVERITY_INFO,"Berhasil Edit Data",null);
    }
    
    public void delete(){
        TransDAO t = new TransDAO();
        t.delete(id);
        pengirimanId = pengirimanId;
        produkId = produkId;
        amount = amount;
        date = date;
        type = "";
    }
    
    public String home(){
        return "transaksi";
    }
    
    public String crud(){
        return "transaksi_edit";
    }


}


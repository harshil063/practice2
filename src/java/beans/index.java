/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.BookBeanLocal;
import entity.Tblbookcategory;
import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Harshil
 */
@Named(value = "index")
@RequestScoped
public class index {
    
    private int bookcat_id;
    private String bookcat_name;
    private Collection<Tblbookcategory> ctgs;

    @EJB BookBeanLocal bc1;
    public Collection<Tblbookcategory> getCtgs() {
        return bc1.ViewBookcat();
    }

    public void setCtgs(Collection<Tblbookcategory> ctgs) {
        this.ctgs = ctgs;
    }
    
    public int getBookcat_id() {
        return bookcat_id;
    }

    public void setBookcat_id(int bookcat_id) {
        this.bookcat_id = bookcat_id;
    }

    public String getBookcat_name() {
        return bookcat_name;
    }

    public void setBookcat_name(String bookcat_name) {
        this.bookcat_name = bookcat_name;
    }
    
    public index() {
        
    }
    
    public String AddBookcat(){
        try{
            if(bookcat_id == 0){
                bc1.AddBookcat(bookcat_name);
            bookcat_name =null;
            System.out.println("Data Inserted!!");
            }
            else{
                bc1.UpdateBookcat(bookcat_id, bookcat_name);
                bookcat_id = 0;
                bookcat_name = null;
                System.out.println("Data Updated..!!");
            }
            
            return "";
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return "";
    }
    public String UpdateBookcat(int id){
        try{
            bookcat_name = bc1.bookcatById(id);
            bookcat_id = id;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return "";
    }
    
    public String DeleteBookcat(int bookcat_id){
        try{
            bc1.RemoveBookcat(bookcat_id);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return "";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Tblbookcategory;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Harshil
 */
@Stateless
public class BookBean implements BookBeanLocal {
    @PersistenceContext(unitName = "exampracticePU")
    EntityManager em;

    @Override
    public void AddBookcat(String bookcat_name) {
        Tblbookcategory bc = new Tblbookcategory();
        bc.setBookcatName(bookcat_name);
        em.persist(bc);
        System.out.println("Category inserted");
    }
    @Override
    public void UpdateBookcat(int bookcat_id, String bookcat_name) {
        Tblbookcategory bc = em.find(Tblbookcategory.class, bookcat_id);
        bc.setBookcatName(bookcat_name);
        em.merge(bc);
        System.out.println("Category Updated");
    }
    @Override
    public void RemoveBookcat(int bookcat_id) {
        Tblbookcategory bc = em.find(Tblbookcategory.class, bookcat_id);
        em.remove(bc);
        System.out.println("Category Updated");
    }
    @Override
    public Collection<Tblbookcategory> ViewBookcat() {
        Collection<Tblbookcategory> ctgs = em.createNamedQuery("Tblbookcategory.findAll").getResultList();
        return ctgs;
    }
    @Override
    public String bookcatById(int bookcat_id) {
        Tblbookcategory bc = em.find(Tblbookcategory.class, bookcat_id);
        return bc.getBookcatName();
    }
    @Override
    public Collection<Tblbookcategory> ViewBookcatById(int bookcat_id) {
        Collection<Tblbookcategory> ctg = em.createNamedQuery("Tblbookcategory.findByBookcatId").setParameter("bookcatId", bookcat_id).getResultList();
        return ctg;
    }

    
}

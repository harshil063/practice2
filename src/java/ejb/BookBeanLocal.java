/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Tblbookcategory;
import java.util.Collection;
import javax.ejb.Local;
/**
 *
 * @author Harshil
 */
@Local
public interface BookBeanLocal {
    public void AddBookcat(String bookcat_name);
    public void UpdateBookcat(int bookcat_id, String bookcat_name);
    public void RemoveBookcat(int bookcat_id);
    public Collection<Tblbookcategory> ViewBookcat();
    public Collection<Tblbookcategory> ViewBookcatById(int bookcat_id);
    public String bookcatById(int bookcat_id);
    
}

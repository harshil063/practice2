/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Harshil
 */
@Entity
@Table(name = "tblbook")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblbook.findAll", query = "SELECT t FROM Tblbook t"),
    @NamedQuery(name = "Tblbook.findByBookId", query = "SELECT t FROM Tblbook t WHERE t.bookId = :bookId"),
    @NamedQuery(name = "Tblbook.findByBookName", query = "SELECT t FROM Tblbook t WHERE t.bookName = :bookName")})
public class Tblbook implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "book_id")
    private Integer bookId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "book_name")
    private String bookName;
    @JoinColumn(name = "bookcat_id", referencedColumnName = "bookcat_id")
    @ManyToOne(optional = false)
    private Tblbookcategory bookcatId;

    public Tblbook() {
    }

    public Tblbook(Integer bookId) {
        this.bookId = bookId;
    }

    public Tblbook(Integer bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Tblbookcategory getBookcatId() {
        return bookcatId;
    }

    public void setBookcatId(Tblbookcategory bookcatId) {
        this.bookcatId = bookcatId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookId != null ? bookId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblbook)) {
            return false;
        }
        Tblbook other = (Tblbook) object;
        if ((this.bookId == null && other.bookId != null) || (this.bookId != null && !this.bookId.equals(other.bookId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tblbook[ bookId=" + bookId + " ]";
    }
    
}

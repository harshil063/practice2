/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Harshil
 */
@Entity
@Table(name = "tblbookcategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblbookcategory.findAll", query = "SELECT t FROM Tblbookcategory t"),
    @NamedQuery(name = "Tblbookcategory.findByBookcatId", query = "SELECT t FROM Tblbookcategory t WHERE t.bookcatId = :bookcatId"),
    @NamedQuery(name = "Tblbookcategory.findByBookcatName", query = "SELECT t FROM Tblbookcategory t WHERE t.bookcatName = :bookcatName")})
public class Tblbookcategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bookcat_id")
    private Integer bookcatId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "bookcat_name")
    private String bookcatName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookcatId")
    private Collection<Tblbook> tblbookCollection;

    public Tblbookcategory() {
    }

    public Tblbookcategory(Integer bookcatId) {
        this.bookcatId = bookcatId;
    }

    public Tblbookcategory(Integer bookcatId, String bookcatName) {
        this.bookcatId = bookcatId;
        this.bookcatName = bookcatName;
    }

    public Integer getBookcatId() {
        return bookcatId;
    }

    public void setBookcatId(Integer bookcatId) {
        this.bookcatId = bookcatId;
    }

    public String getBookcatName() {
        return bookcatName;
    }

    public void setBookcatName(String bookcatName) {
        this.bookcatName = bookcatName;
    }

    @XmlTransient
    public Collection<Tblbook> getTblbookCollection() {
        return tblbookCollection;
    }

    public void setTblbookCollection(Collection<Tblbook> tblbookCollection) {
        this.tblbookCollection = tblbookCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookcatId != null ? bookcatId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblbookcategory)) {
            return false;
        }
        Tblbookcategory other = (Tblbookcategory) object;
        if ((this.bookcatId == null && other.bookcatId != null) || (this.bookcatId != null && !this.bookcatId.equals(other.bookcatId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tblbookcategory[ bookcatId=" + bookcatId + " ]";
    }
    
}

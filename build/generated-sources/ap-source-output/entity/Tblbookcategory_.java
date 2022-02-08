package entity;

import entity.Tblbook;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-02-08T21:03:01")
@StaticMetamodel(Tblbookcategory.class)
public class Tblbookcategory_ { 

    public static volatile SingularAttribute<Tblbookcategory, Integer> bookcatId;
    public static volatile CollectionAttribute<Tblbookcategory, Tblbook> tblbookCollection;
    public static volatile SingularAttribute<Tblbookcategory, String> bookcatName;

}
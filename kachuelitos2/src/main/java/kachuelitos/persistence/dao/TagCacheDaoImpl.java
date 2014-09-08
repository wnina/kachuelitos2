package kachuelitos.persistence.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import kachuelitos.persistence.entity.Tagcache;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "tagcacheDao")

public class TagCacheDaoImpl implements TagCacheDao {
	
    private EntityManager em = null;
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
    
    @Transactional(readOnly = false)
	public Tagcache add(Tagcache tagcache) {
		// TODO Auto-generated method stub

    	return em.merge(tagcache);
    
	}

     @Transactional(readOnly = false)
	public Tagcache getTagcache(int tagcacheid) {
		// TODO Auto-generated method stub
    	 
   	    Tagcache tagcache = null;
    
    	//System.out.print("salida"+"select t from Trabajador t where t.trabajadorDniuser=:"+trabajadorId);
            	
		Query query= em.createQuery("FROM Tagcache t WHERE t.idTagCacheDni = :id");
		query.setParameter("id", Integer.valueOf(tagcacheid));

		tagcache = (Tagcache) query.getSingleResult();
    
    	return tagcache;
		
	}

}
package model;

import java.util.List;

import org.hibernate.Session;
import javax.persistence.Query;

import util.HibernateUtil;


public class ProdutoHibernateDAO {
		
	public static Produto getById(int id) {
		Produto p = null;
		Session session = null;
			
		try {
			session = HibernateUtil.getSessionFactory().openSession();
	        p = session.get(Produto.class, id);
		} catch (Throwable e) {
	    	System.out.println("Erro ao recuperar o produto. Mensagem: " + e.getMessage());
		} finally {
	    	try {
	        	if (session.isOpen()) {
	        		session.close();
	        	} 
	    	} catch (Throwable e) {
	        	System.out.println("Erro ao fechar a sessão. Mensagem: " + e.getMessage());
	    	}
	}
	        	
	return p;
	}
		
	public static void salvar(Produto p) {
			
		Session session = null;
			
		try {
	    	session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        session.save(p);
	        session.getTransaction().commit();
	            
		} catch (Throwable e) {
	    	System.out.println("Erro ao salvar o produto. Mensagem: " + e.getMessage());
		} finally {
	    	try {
	        	if (session.isOpen()) {
	        		session.close();
	        	} 
	    	} catch (Throwable e) {
	        	System.out.println("Erro ao fechar a sessão. Mensagem: " + e.getMessage());
	    	}
		}
	}
		
	public static void atualizar(Produto p) {
			
		Session session = null;
			
		try {
	    	session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        session.update(p);
	        session.getTransaction().commit();
	            
		} catch (Throwable e) {
	    	System.out.println("Erro ao atualizar o produto. Mensagem: " + e.getMessage());
		} finally {
	    	try {
	        	if (session.isOpen()) {
	        		session.close();
	        	} 
	    	} catch (Throwable e) {
	        	System.out.println("Erro ao fechar a sessão. Mensagem: " + e.getMessage());
	    	}
		}
	}
	    
	public static void excluir(Produto p) {
			
		Session session = null;
			
		try {
	    	session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        session.delete(p);
	        session.getTransaction().commit();
	            
		} catch (Throwable e) {
	    	System.out.println("Erro ao excluir o produto. Mensagem: " + e.getMessage());
		} finally {
	    	try {
	        	if (session.isOpen()) {
	        		session.close();
	        	} 
	    	} catch (Throwable e) {
	        	System.out.println("Erro ao fechar a sessão. Mensagem: " + e.getMessage());
	    	}
		}
	}
	
	public static List<Produto> listaDeProdutos() {
		
		List<Produto> p = null;
		Session session = null;
			
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			
			Query q =  session.createQuery("select p from produto as p");
			
	        //p = session.get(Produto.class, 3);
			
			p = q.getResultList();
			System.out.println(p);
			return p;
		} catch (Throwable e) {
	    	System.out.println("Erro ao recuperar o produto. Mensagem: " + e.getMessage());
	    	return null;
		} finally {
	    	try {
	        	if (session.isOpen()) {
	        		session.close();
	        	} 
	    	} catch (Throwable e) {
	        	System.out.println("Erro ao fechar a sessão. Mensagem: " + e.getMessage());
	    	}
		}		

	}
}

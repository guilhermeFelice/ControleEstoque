package principal;

import org.hibernate.Session;

import model.Produto;
import model.ProdutoHibernateDAO;
import util.HibernateUtil;

public class HibernateFactory {
	
	
	public static void save(Produto p) {
		Session sessao = null;
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
			System.out.println("Conectou!");

			p = new Produto();

			ProdutoHibernateDAO.salvar(p);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally { 
			sessao.close(); 
			System.out.println("Desconectou!");
		}
	}
	

	/*public static void main(String[] args) {
		
		Session sessao = null;
		try{
			sessao = HibernateUtil.getSessionFactory().openSession();
			System.out.println("Conectou!");
			
			Produto p = new Produto();
			//p.setCodigo(55);
			p.setNome("doce");
			p.setUnidade(12);
			
			ProdutoHibernateDAO.salvar(p);
			
			
			Produto p1 = ProdutoHibernateDAO.getById(1);
			System.out.println(p1.getCodigo() + " - " + p1.getNome() + " - " + p1.getUnidade());
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally { 
			sessao.close(); 
			System.out.println("Desconectou!");
		}
	}*/
	
}

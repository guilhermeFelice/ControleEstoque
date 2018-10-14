package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import model.Produto;
import model.ProdutoHibernateDAO;

@ManagedBean(name="listarProduto")
public class ListarProdutoMB {
	Produto _produto = new Produto();
	
	
	public ListarProdutoMB(){
		
	}
	
	public List<Produto> getList(){
		ArrayList<Produto> lista = new ArrayList<Produto>();
		_produto.setCodigo(1);
		_produto.setNome("café");
		_produto.setUnidade(33);
		lista.add(_produto);
		_produto = new Produto();
		_produto.setCodigo(2);
		_produto.setNome("Arroz");
		_produto.setUnidade(11);
		lista.add(_produto);
		_produto = new Produto();
		_produto.setCodigo(3);
		_produto.setNome("cerveja");
		_produto.setUnidade(100);
		lista.add(_produto);
		_produto = new Produto();
		_produto.setCodigo(5);
		_produto.setNome("garrafa");
		_produto.setUnidade(11);
		lista.add(_produto);
		
		
		//List<Produto> list =ProdutoHibernateDAO.listaDeProdutos(); 
		
		//System.out.println(list);
		
		return lista;
	}
	
	/*public String getCodigo(){
		return String.valueOf(_produto.getCodigo());
	}
	
	public String getNome(){
		return _produto.getNome();
	}
	public String getUnidade(){
		if(_produto.getUnidade() != null){
			return String.valueOf(_produto.getUnidade());
		}
		return "";
	}
	
	public String salvar(){

		//ProdutoHibernateDAO.salvar(_produto);
		return "cadastraProduto";
		
	}*/

}

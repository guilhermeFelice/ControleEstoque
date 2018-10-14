package controle;

import javax.faces.bean.ManagedBean;

import model.Produto;
import model.ProdutoHibernateDAO;


@ManagedBean(name="editarProduto")
public class EditarProdutoMB {
	
	
private Produto _produto = new Produto();
	
	public EditarProdutoMB(){
	
	}
	public String getCodigo(){
		if(_produto.getCodigo() != null){
			return String.valueOf(_produto.getCodigo());
		}
		return "";
	}
	public void setCodigo(String codigo){
		if(!codigo.isEmpty()){
			_produto.setCodigo(Integer.parseInt(codigo));
			return;
		}	
		_produto.setCodigo(0);
	}
	public String getNome(){
		if(_produto.getNome() != null){
			return _produto.getNome();
		}
		return "";
	}
	public void setNome(String nome){
		_produto.setNome(nome);
	}
	public String getUnidade(){
		if(_produto.getUnidade() != null ){
			return String.valueOf(_produto.getUnidade());
		}
		return "";
	}
	public void setUnidade(String unidade){
		if(!unidade.isEmpty()){
			_produto.setUnidade(Integer.parseInt(unidade));
			return;
		}	
		_produto.setUnidade(0);
	}
	
	public String buscaPorId(){
		Produto p = ProdutoHibernateDAO.getById(Integer.parseInt(this.getCodigo()));
		
		if(p != null){
			_produto = p;
		}
		return "editarProduto";
	}

	public String updateProd(){
		Produto p = _produto;
		ProdutoHibernateDAO.atualizar(p);
		return "editarProduto";
		
	}
	

}

package controle;

import javax.faces.bean.ManagedBean;

import model.Produto;
import model.ProdutoHibernateDAO;

@ManagedBean(name="cadastraProduto")
public class CadastraProdutoMB {
	private Produto _produto = new Produto();
	
	public CadastraProdutoMB(){
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
	public String salvar(){
		Produto p = new Produto();
		
		p.setNome(this.getNome());
		p.setUnidade(Integer.parseInt(this.getUnidade()));
		
		ProdutoHibernateDAO.salvar(p);
		return "cadastraProduto";	
	}
}

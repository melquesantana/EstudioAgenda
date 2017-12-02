package br.com.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
 
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;
 
import br.com.dao.ClienteDao;
import br.com.modelo.Cliente;
 
@ManagedBean  
@ViewScoped
public class ClienteBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Cliente cliente= new Cliente();
	private ClienteDao clienteDao =  new ClienteDao();
	private List<Cliente>clientes ;
	
	
	public void excluir(ActionEvent evento){
		try {
			cliente =   (Cliente) evento.getComponent().getAttributes().get("clienteSelecionado");	 
		 ClienteDao clienteDao =  new ClienteDao();
			 
			clienteDao.excluir(cliente);
			clientes = clienteDao.ListarCliente();
		 
			Messages.addGlobalInfo("cliente excluido com sucesso.");
			//System.out.println("usuario excluido");
			//Messages.addGlobalInfo("o usuario excluido é " +usuario.getPessoa().getNome());
		} catch (RuntimeException erro) {
			Messages.addGlobalError("erro ao tentar remover  o cliente");
			//System.out.println("erro ao tentar remover a cliente");
			erro.printStackTrace();

		}
	}
	
	public void novo() {
		try {
			cliente = new Cliente();
			ClienteDao clienteDao =  new ClienteDao();
			clientes = clienteDao.ListarCliente();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("ocorreu um erro ao gerar um cliente");
			erro.printStackTrace();
		}
	}
	public void editar(ActionEvent evento){
		


		try {
			cliente =   (Cliente) evento.getComponent().getAttributes().get("clienteSelecionado");

			 
			 ClienteDao clienteDao =  new ClienteDao();
				clientes = clienteDao.ListarCliente();
		 
			
		 
			 
		//	System.out.println("usuario selecionado");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("ocorreu um erro ao tentar Selecionar o usuario");
			erro.printStackTrace();
			//System.out.println("erro ao selecionar usuario");
		}}
	 
	public String sair(){
		
		 return "home.xhtml";
		
		
		
	}
	
	
	
	
	
	public void salvar(){		
		try {
		ClienteDao clienteDao =  new ClienteDao();	
		 
				clienteDao.salvar(cliente);
				// salvar cliente
		cliente = new Cliente();
		clientes = clienteDao.ListarCliente();
	Messages.addGlobalInfo("cliente salvo com sucesso!");
		 
	} catch (RuntimeException erro) {
//erro ao tentar salvar cliente
		Messages.addGlobalError("ocorreu um erro ao tentar salvar cliente");
		erro.printStackTrace();	 
	}}
		@PostConstruct
		public void Listar(){
			
			try {
				ClienteDao clienteDao =  new ClienteDao();
				clientes = clienteDao.ListarCliente();

			} catch (RuntimeException erro) {
				Messages.addGlobalError("ocorreu um erro ao tentar listar os clientes");
				erro.printStackTrace();
			}
		}
		public String pagina()
		  {
		    return "cliente.xhtml";
		  }
		
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public List<Cliente> getClientes() {
		return clientes;
	}


	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ClienteDao getClienteDao() {
		return clienteDao;
	}

	public void setClienteDao(ClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}
	
	
}

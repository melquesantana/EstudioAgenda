package br.com.bean;

import java.io.Serializable;
 
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
 

import org.apache.shiro.crypto.hash.SimpleHash;
import org.omnifaces.util.Messages;

import br.com.dao.ClienteDao;
import br.com.dao.UsuarioDAO;
import br.com.modelo.Cliente;
import br.com.modelo.Usuario;
 
@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private List<Cliente> clientes;
	private List<Usuario> usuarios ;
	
	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	 
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	@PostConstruct
	public void listar(){
		try{
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarios = usuarioDAO.ListarUsuarios();
		}catch(RuntimeException erro){
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os usuários");
			erro.printStackTrace();
		}
	}
	
	public void novo() {
		try {
			usuario = new Usuario();

			//ClienteDao clienteDao = new ClienteDao();
			//clientes = clienteDao.ListarCliente();
			 UsuarioDAO usuarioDAO= new UsuarioDAO();
			 usuarios =usuarioDAO.ListarUsuarios();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar criar um novo usuário");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			SimpleHash hash = new SimpleHash("md5" , usuario.getSenhaSCriptografia());
			usuario.setSenha(hash.toHex());
			
			usuarioDAO.salvar(usuario);;
			
			usuario = new Usuario();
			usuarios = usuarioDAO.ListarUsuarios();
			
			ClienteDao clienteDao = new ClienteDao();
			clientes = clienteDao.ListarCliente();
			
			Messages.addGlobalInfo("Usuário salvo com sucesso");
			 
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o usuário");
			erro.printStackTrace();
		}
	}
	public void excluir(ActionEvent evento){
		try {
			usuario =   (Usuario) evento.getComponent().getAttributes().get("usuarioSelecionado");

		 
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			 
			usuarioDAO.excluir(usuario);
			 usuarios=usuarioDAO.ListarUsuarios();
		 
			Messages.addGlobalInfo("usuario excluido com sucesso.");
			//System.out.println("usuario excluido");
			//Messages.addGlobalInfo("o usuario excluido é " +usuario.getPessoa().getNome());
		} catch (RuntimeException erro) {
			Messages.addGlobalError("erro ao tentar remover  o usuario");
			//System.out.println("erro ao tentar remover a cliente");
			erro.printStackTrace();

		}
	}
	public void editar(ActionEvent evento){
		
		 UsuarioDAO usuarioDAO = new UsuarioDAO();
		 

		try {
			usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSelecionado");
			  
			 
			 usuarios=usuarioDAO.ListarUsuarios();
			 
			
		 
			 
		//	System.out.println("usuario selecionado");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("ocorreu um erro ao tentar Selecionar o usuario");
			erro.printStackTrace();
			//System.out.println("erro ao selecionar usuario");
		}}

	 
	 
}

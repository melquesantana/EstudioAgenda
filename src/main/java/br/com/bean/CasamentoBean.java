package br.com.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.dao.CasamentoDao;
import br.com.modelo.Casamento;
@ManagedBean(name="casamentoBean")
@ViewScoped
public class CasamentoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private Casamento casamento = new Casamento();
	 
	private List<Casamento> casamentos ;

	public void excluir(ActionEvent evento) {
		try {
			casamento = (Casamento) evento.getComponent().getAttributes().get("clienteSelecionado");
			CasamentoDao casamentoDao = new CasamentoDao();

			casamentoDao.excluir(casamento);
			casamentos = casamentoDao.ListarCasamento();

			Messages.addGlobalInfo("cliente excluido com sucesso.");
			// System.out.println("usuario excluido");
			// Messages.addGlobalInfo("o usuario excluido é "
			// +usuario.getPessoa().getNome());
		} catch (RuntimeException erro) {
			Messages.addGlobalError("erro ao tentar remover  o cliente");
			// System.out.println("erro ao tentar remover a cliente");
			erro.printStackTrace();

		}
	}

	public void novo() {
		try {
			casamento = new Casamento();
			CasamentoDao casamentoDao = new CasamentoDao();
			casamentos = casamentoDao.ListarCasamento();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("ocorreu um erro ao gerar um cliente");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {

		try {
			casamento = (Casamento) evento.getComponent().getAttributes().get("clienteSelecionado");

			CasamentoDao casamentoDao = new CasamentoDao();
			casamentos = casamentoDao.ListarCasamento();

			// System.out.println("usuario selecionado");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("ocorreu um erro ao tentar Selecionar o usuario");
			erro.printStackTrace();
			// System.out.println("erro ao selecionar usuario");
		}
	}

	public String sair() {

		return "home.xhtml";

	}

	public void salvar() {
		try {
			CasamentoDao casamentoDao = new CasamentoDao();

			casamentoDao.salvar(casamento);
			// salvar cliente
			casamento = new Casamento();
			casamentos = casamentoDao.ListarCasamento();
			Messages.addGlobalInfo("Orçamento salvo com sucesso!");

		} catch (RuntimeException erro) {
			// erro ao tentar salvar cliente
			Messages.addGlobalError("ocorreu um erro ao tentar salvar co orçarmento");
			erro.printStackTrace();
		}
	}

	@PostConstruct
	public void Listar() {

		try {
			CasamentoDao casamentoDao= new CasamentoDao(); 
			casamentos = casamentoDao.ListarCasamento();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("ocorreu um erro ao tentar listar os clientes");
			erro.printStackTrace();
		}
	}

	public String pagina() {
		return "casamento.xhtml";
	}

	public Casamento getCasamento() {
		return casamento;
	}

	public void setCasamento(Casamento casamento) {
		this.casamento = casamento;
	}

	public List<Casamento> getCasamentos() {
		return casamentos;
	}

	public void setCasamentos(List<Casamento> casamentos) {
		this.casamentos = casamentos;
	}

}

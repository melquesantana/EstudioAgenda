package br.com.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.dao.FotoDao;
import br.com.modelo.Foto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FotoBean implements  Serializable{
 private Foto foto= new Foto();
 private List<Foto>fotos = new ArrayList<>();
public List<Foto> getFotos() {
	return fotos;
}
public void setFotos(List<Foto> fotos) {
	this.fotos = fotos;
}
public Foto getFoto() {
	return foto;
}
public void setFoto(Foto foto) {
	this.foto = foto;
}


public void salvar(){		
	try {
	FotoDao fotoDao =  new FotoDao();
	 
			fotoDao.salvar(foto);
			 
	foto = new Foto();
 
Messages.addGlobalInfo("  salvo com sucesso!");
	 
} catch (RuntimeException erro) {
//erro ao tentar salvar cliente
	Messages.addGlobalError("ocorreu um erro ao tentar salvar  ");
	erro.printStackTrace();	 
}}
public void total(){
 
	
	
}
 
 
}

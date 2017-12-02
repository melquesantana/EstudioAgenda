package br.com.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.modelo.Freelancer;

@ManagedBean
@ViewScoped
public class FreelancerBean {
private Freelancer freelancer = new Freelancer();
private List<Freelancer> freelancers;












public Freelancer getFreelancer() {
	return freelancer;
}
public void setFreelancer(Freelancer freelancer) {
	this.freelancer = freelancer;
}
public List<Freelancer> getFreelancers() {
	return freelancers;
}
public void setFreelancers(List<Freelancer> freelancers) {
	this.freelancers = freelancers;
}



}
package com.Adrenaline.Adrenaline.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adrenaline implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nome;
	private String plataformas;
	private String generos;
	private String deseenvolvedor;
	private String data;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPlataformas() {
		return plataformas;
	}
	public void setPlataformas(String plataformas) {
		this.plataformas = plataformas;
	}
	public String getGeneros() {
		return generos;
	}
	public void setGeneros(String generos) {
		this.generos = generos;
	}
	public String getDeseenvolvedor() {
		return deseenvolvedor;
	}
	public void setDeseenvolvedor(String deseenvolvedor) {
		this.deseenvolvedor = deseenvolvedor;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

	
}
package br.com.application.models;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection = "alimentos")
public class Alimento implements Serializable {
	private static final long serialVersionUID = -5782963052534642796L;

	private Object id;
	private String descricao;
	private String quantidade;
	private String calorias;

}
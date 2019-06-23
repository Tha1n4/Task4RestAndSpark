package br.com.senai.sparkjava;

import static spark.Spark.*;

public class OlaMundoComSpark {
	
	public static void main(String[] args) {
		get("/Olá", (req, res) -> "Olá, Senai");

		get("/Olá/:nome", (req, res) -> {
			return "Olá: " + req.params(":nome");
		});
	}
}

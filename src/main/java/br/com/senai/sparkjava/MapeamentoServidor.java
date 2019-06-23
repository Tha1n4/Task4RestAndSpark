package br.com.senai.sparkjava;

import java.util.Collection;
import java.util.HashMap;

public class MapeamentoServidor {
	private HashMap<String, Usuario> map;

	public MapeamentoServidor() {
		map = new HashMap<>();
	}

	public void adicionarUsuario(Usuario user) {
		map.put(user.getId(), user);
	}

	public Collection<Usuario> pegarUsuarios() {
		return map.values();
	}

	public Usuario getUsuario(String id) {
		return map.get(id);
	}

    public Usuario editarUsuario(Usuario editar) {
        try {
            if (editar.getId() == null)
                throw new Exception("Error: id não pode ser nulo");

            Usuario usuario = map.get(editar.getId());

            if (usuario == null)
                throw new Exception("Usuário não foi encontrado");

            if (editar.getEmail() != null) {
                usuario.setEmail(editar.getEmail());
            }
            if (editar.getFirstName() != null) {
                usuario.setFirstName(editar.getFirstName());
            }
            if (editar.getId() != null) {
                usuario.setId(editar.getId());
            }

            return usuario;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
		return editar;
    }

	public void deletarUsuario(String id) {
		map.remove(id);
	}

	public boolean userExist(String id) {
		return map.containsKey(id);
	}

}

package br.com.senai.sparkjava;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.options;
import static spark.Spark.post;
import static spark.Spark.put;

import com.google.gson.Gson;

public class SparkComRest {
    public static void main(String[] args) {
        final MapeamentoServidor userService = new MapeamentoServidor();

        post("/usuário(s)", (request, response) -> {
            response.type("application/json");

            Usuario user = new Gson().fromJson(request.body(), Usuario.class);
            userService.adicionarUsuario(user);

            return new Gson().toJson(new TipoResposta(StatusResposta.SUCCESS));
        });

        get("/usuário(s)", (request, response) -> {
            response.type("application/json");

            return new Gson().toJson(new TipoResposta(StatusResposta.SUCCESS, new Gson().toJsonTree(userService.getUsers())));
        });

        get("/usuário(s)/:id", (request, response) -> {
            response.type("application/json");

            return new Gson().toJson(new TipoResposta(StatusResposta.SUCCESS, new Gson().toJsonTree(userService.getUsuario(request.params(":id")))));
        });

        put("/usuário(s)/:id", (request, response) -> {
            response.type("application/json");

            Usuario toEdit = new Gson().fromJson(request.body(), Usuario.class);
            Usuario editedUser = userService.editarUsuario(toEdit);

            if (editedUser != null) {
                return new Gson().toJson(new TipoResposta(StatusResposta.SUCCESS, new Gson().toJsonTree(editedUser)));
            } else {
                return new Gson().toJson(new TipoResposta(StatusResposta.ERROR, new Gson().toJson("Erro, usuário não encontrado")));
            }
        });

        delete("/usuário(s)/:id", (request, response) -> {
            response.type("application/json");

            userService.deletarUsuario(request.params(":id"));
            return new Gson().toJson(new TipoResposta(StatusResposta.SUCCESS, "Usuário deletado"));
        });

        options("/usuário(s)/:id", (request, response) -> {
            response.type("application/json");
            //Ternário condicional para verificar a existencia de usuário
            return new Gson().toJson(new TipoResposta(StatusResposta.SUCCESS, (userService.userExist(request.params(":id"))) ? "Usuário existe" : "Usuário não exite"));
        });

    }

}

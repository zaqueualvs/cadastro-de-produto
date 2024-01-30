package com.alves.backproduto.commons.exception;

import lombok.Getter;

@Getter
public enum ProblemType {
    ERRO_DOMAIN("erro-domain", "Violação de regra de negócio"),
    RECURSO_NAO_ENCONTRADO("recurso-não-encontrado", "Recurso não encontrado");

    private String title;
    private String uri;

    ProblemType(String uri, String title) {
        this.uri = "https://product/" + uri;
        this.title = title;
    }
}

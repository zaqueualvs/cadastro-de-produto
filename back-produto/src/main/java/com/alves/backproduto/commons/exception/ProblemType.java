package com.alves.backproduto.commons.exception;

import lombok.Getter;

@Getter
public enum ProblemType {
    ERRO_DOMAIN("erro-domain", "Violação de regra de negócio"),
    DADOS_INVALIDOS("/dados-invalidos", "Dados inválidos"),
    MENSAGEM_INCOMPREENSIVEL("/mensagem-incompreensivel", "Mensagem incompreensível"),
    METODO_NAO_SUPORTADO("metodo-não-suportado", "Método não suportado"),
    PARAMETRO_INVALIDO("/parametro-invalido", "Parâmetro inválido"),
    ERRO_DE_SISTEMA("/erro-de-sistema", "Erro de sistema"),
    RECURSO_NAO_ENCONTRADO("recurso-não-encontrado", "Recurso não encontrado");

    private String title;
    private String uri;

    ProblemType(String uri, String title) {
        this.uri = "https://product/" + uri;
        this.title = title;
    }
}

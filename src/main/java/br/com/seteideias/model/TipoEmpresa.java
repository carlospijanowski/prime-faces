package br.com.seteideias.model;

import br.com.seteideias.utils.StringUtils;

public enum TipoEmpresa {

    MEI(StringUtils.MEI),
    LTDA(StringUtils.LTDA),
    EIRELI(StringUtils.EIRELI),
    SA(StringUtils.SA);


    private final String descricao;

    private TipoEmpresa(String s) {
        this.descricao = s;
    }

    public String getDescricao() {
        return descricao;
    }
}

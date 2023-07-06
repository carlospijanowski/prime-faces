package br.com.seteideias.beans;

import br.com.seteideias.model.TipoEmpresa;
import br.com.seteideias.repository.entity.Empresa;
import br.com.seteideias.repository.Empresas;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
//import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

//@Named // era assim originalmente
@ManagedBean(name = "gestaoEmpresasBean")
@ViewScoped
public class GestaoEmpresasBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private Empresas empresas;

    private Empresa empresa = new Empresa();
    private List<Empresa> empresasList;
    public Empresa getEmpresa(){
        return empresa;
    }

    public void getEmpresasList(){
        empresasList = empresas.todasAsEmpresas();
    }
    public TipoEmpresa[] getTiposEmpresa(){
        return TipoEmpresa.values();
    }

    public void salvar(){
        System.out.println("salvando!!!\n" +
                "empresa.: "+empresa.getRazaoSocial()+"\n" +
                "nome fantasia.: "+empresa.getNomeFantasia() +"\n" +
                "data fundação.: " +empresa.getDataFundacao()
        );
    }

}

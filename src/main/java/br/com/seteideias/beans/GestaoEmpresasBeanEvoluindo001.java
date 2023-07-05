package br.com.seteideias.beans;

import br.com.seteideias.repository.entity.Empresa;
import br.com.seteideias.repository.EmpresasRepository;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "gestaoEmpresasBeanEvoluindo001")
@ViewScoped
public class GestaoEmpresasBeanEvoluindo001 implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private EmpresasRepository empresasRepository = new EmpresasRepository();

    private List<Empresa> listaEmpresas;
    public void todasEmpresas(){
        listaEmpresas = empresasRepository.todasAsEmpresas();
    }

    public List<Empresa> getListaEmpresas() {
        return listaEmpresas;
    }
}

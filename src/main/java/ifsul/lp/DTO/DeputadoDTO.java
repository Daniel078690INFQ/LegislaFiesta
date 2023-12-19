package ifsul.lp.DTO;

import java.util.List;
import java.util.stream.Collectors;

import ifsul.lp.entities.Deputado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeputadoDTO {

    private Integer id;
    private String nome;
    private String siglaPartido;
    private String siglaUf;

    public DeputadoDTO(Deputado deputado) {
        this.id = deputado.getId();
        this.nome = deputado.getNomeCivil();
        this.siglaPartido = deputado.getSiglaPartido();
        this.siglaUf = deputado.getSiglaPartido();
    }

    public static List<DeputadoDTO> converterLista(List<Deputado> listaDeputado) {
        return listaDeputado.stream().map(DeputadoDTO::new).collect(Collectors.toList());
    }

}
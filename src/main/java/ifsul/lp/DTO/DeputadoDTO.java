package ifsul.lp.DTO;

import java.util.List;
import java.util.stream.Collectors;

import ifsul.lp.entities.Deputado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class DeputadoDTO {

    private Long id;

    private String nome;

    private String siglaPartido;

    private String siglaUf;
}
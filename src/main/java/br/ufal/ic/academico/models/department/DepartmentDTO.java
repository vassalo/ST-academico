package br.ufal.ic.academico.models.department;

import br.ufal.ic.academico.models.secretary.SecretaryDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class DepartmentDTO {
    String name;
    SecretaryDTO gradution, postGraduation;

    public DepartmentDTO(Department entity) {
        this.name = entity.name;
        if (entity.graduation != null) {
            this.gradution = new SecretaryDTO(entity.graduation);
        }
        if (entity.postGraduation != null) {
            this.postGraduation = new SecretaryDTO(entity.postGraduation);
        }
    }
}
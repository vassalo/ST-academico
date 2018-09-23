package br.ufal.ic.academico.models.secretary;

import br.ufal.ic.academico.models.course.Course;
import br.ufal.ic.academico.models.course.CourseDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@RequiredArgsConstructor
public class Secretary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String type;

    @OneToMany(cascade = CascadeType.ALL)
    List<Course> courses;

    public Secretary(SecretaryDTO entity) {
        this.type = entity.type.toUpperCase().equals("POST-GRADUATION") ? "POST-GRADUATION" : "GRADUATION";
        this.courses = new ArrayList<>();
    }

    public Course addCourse(CourseDTO entity) {
        Course newCourse = new Course(entity);
        if (this.courses.add(newCourse)) {
            return newCourse;
        } else {
            return null;
        }
    }

    public void deleteCourse(Course c) {
        this.courses.remove(c);
    }
}

package by.vdavdov.todolist.domain.entity;

import by.vdavdov.todolist.constants.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100, name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "status")
    private Status status;

}

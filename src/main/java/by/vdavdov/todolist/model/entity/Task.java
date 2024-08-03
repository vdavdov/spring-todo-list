package by.vdavdov.todolist.model.entity;

import by.vdavdov.todolist.model.constants.Status;
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
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100, name = "description")
    private String description;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false, name = "status")
    private Status status;

}

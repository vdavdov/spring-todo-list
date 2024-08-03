package by.vdavdov.todolist.model.dto;

import by.vdavdov.todolist.model.constants.Status;
import lombok.Value;

@Value
public class TaskTo {
    Long id;
    String description;
    Status status;
}

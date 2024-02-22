package ru.gb.voronina.SpringHW5.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.voronina.SpringHW5.model.Task;
import ru.gb.voronina.SpringHW5.model.TaskStatus;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    /**
     *  Метод для получения списка задач по статусу
     * @param status искомый статус
     * @return список задач
     */
    List<Task> findTaskByStatus(TaskStatus status);
}

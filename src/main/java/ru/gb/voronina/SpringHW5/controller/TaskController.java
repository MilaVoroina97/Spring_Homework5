package ru.gb.voronina.SpringHW5.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.voronina.SpringHW5.model.Task;
import ru.gb.voronina.SpringHW5.model.TaskStatus;
import ru.gb.voronina.SpringHW5.services.TaskService;


import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    /**
     * Метод обработки GET запроса без параметров
     * @return список всех задач
     */

    @GetMapping()
    public List<Task> getAllTask() {
        return taskService.getAllTasks();
    }

    /**
     * метод обработки запроса добавления задачи через параметр
     * @param description тело задачи, передается через параметр
     * @return новая задача
     */
    @PostMapping()
    @ResponseBody
    public Task addTaskFromParam(@RequestParam("description") String description) {
        return taskService.createTask(description);
    }

    /**
     * метод обработки запроса списка задач с указанным статусом
     * @param status искомый статус
     * @return список задач
     */
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status) {
        return taskService.findTaskByStatus(status);
    }

    /**
     * метод обработки запроса изменения статуса задачи по id
     * @param id Id задачи
     * @return задача с измененным статусом
     */
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id) {
        return taskService.updateTaskStatus(id);
    }

    /**
     * метод обработки запроса удаления задачи по id
     * @param id Id задачи
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}

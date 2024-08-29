package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.xml.taskDtos.TasksRootDto;
import softuni.exam.models.entity.Mechanic;
import softuni.exam.models.entity.Task;
import softuni.exam.repository.TaskRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.MechanicService;
import softuni.exam.service.PartService;
import softuni.exam.service.TaskService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
  private static final String TASK_FILE_PATH = "src/main/resources/files/xml/tasks.xml";
  private final TaskRepository taskRepository;
  private final XmlParser xmlParser;
  private final ModelMapper modelMapper;
  private final ValidationUtil validationUtil;
  private final PartService partService;
  private final CarService carService;
  private final MechanicService mechanicService;

  public TaskServiceImpl(TaskRepository taskRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil, PartService partService, CarService carService, MechanicService mechanicService) {
    this.taskRepository = taskRepository;
    this.xmlParser = xmlParser;
    this.modelMapper = modelMapper;
    this.validationUtil = validationUtil;
    this.partService = partService;
    this.carService = carService;
    this.mechanicService = mechanicService;
  }

  @Override
  public boolean areImported() {
    return this.taskRepository.count() > 0;
  }

  @Override
  public String readTasksFileContent() throws IOException {
    return Files.readString(Path.of(TASK_FILE_PATH));
  }

  @Override
  public String importTasks() throws IOException, JAXBException {
    StringBuilder sb = new StringBuilder();

    var rootDto = this.xmlParser.fromFile(TASK_FILE_PATH, TasksRootDto.class);

    rootDto.getTasks()
            .stream()
            .filter(dto -> {
              boolean isValid = this.validationUtil.isValid(dto);


              if (!doesMechanicExist(dto.getMechanic().getFirstName())) {
                isValid = false;
              }

              sb.append(isValid
                      ? String.format("Successfully imported task %.2f",
                      dto.getPrice())
                      : "Invalid task")
                      .append(System.lineSeparator());

              return isValid;
            })
            .map(dto -> {
              Task task = this.modelMapper.map(dto, Task.class);
              task.setCar(this.carService.findCarById(dto.getCar().getId()));
              task.setMechanic(this.mechanicService.findMechanicByFirstName(dto.getMechanic().getFirstName()));
              task.setPart(this.partService.findPartById(dto.getPart().getId()));

              return task;
            })
            .forEach(this.taskRepository::save);

    System.out.println();
    return sb.toString().trim();
  }

  @Override
  public String getCoupeCarTasksOrderByPrice() {
    return null;
  }

  // Helpers
  private boolean doesMechanicExist(String firstName) {
    return mechanicService.findMechanicByFirstName(firstName) != null;
  }
}

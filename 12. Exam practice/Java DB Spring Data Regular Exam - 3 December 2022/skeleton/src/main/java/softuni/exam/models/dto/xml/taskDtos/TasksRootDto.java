package softuni.exam.models.dto.xml.taskDtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "tasks")
@XmlAccessorType(XmlAccessType.FIELD)
public class TasksRootDto {

  @XmlElement(name = "task")
  private List<TaskDto> tasks;

  public List<TaskDto> getTasks() {
    return tasks;
  }
}

package softuni.exam.service.impl;

import org.springframework.stereotype.Service;
import softuni.exam.service.JobService;

import java.io.IOException;

@Service
public class JobServiceImpl implements JobService {
  @Override
  public boolean areImported() {
    return false;
  }

  @Override
  public String readJobsFileContent() throws IOException {
    return null;
  }

  @Override
  public String importJobs() throws IOException {
    return null;
  }

  @Override
  public String getBestJobs() {
    return null;
  }
}

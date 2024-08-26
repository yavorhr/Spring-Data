package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.xml.JobsRootDto;
import softuni.exam.models.entity.Job;
import softuni.exam.repository.JobRepository;
import softuni.exam.service.CompanyService;
import softuni.exam.service.JobService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class JobServiceImpl implements JobService {
  private static final String JOBS_FILE_PATH = "src/main/resources/files/xml/jobs.xml";
  private final JobRepository jobRepository;
  private final CompanyService companyService;
  private final XmlParser xmlParser;
  private final ValidationUtil validationUtil;
  private final ModelMapper modelMapper;

  public JobServiceImpl(JobRepository jobRepository, CompanyService companyService, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper) {
    this.jobRepository = jobRepository;
    this.companyService = companyService;
    this.xmlParser = xmlParser;
    this.validationUtil = validationUtil;
    this.modelMapper = modelMapper;
  }

  @Override
  public boolean areImported() {
    return this.jobRepository.count() > 0;
  }

  @Override
  public String readJobsFileContent() throws IOException {
    return Files.readString(Path.of(JOBS_FILE_PATH));
  }

  @Override
  public String importJobs() throws IOException, JAXBException {
    StringBuilder sb = new StringBuilder();

    JobsRootDto rootDto =
            this.xmlParser.fromFile(JOBS_FILE_PATH, JobsRootDto.class);

    System.out.println();
    rootDto.getJobs()
            .stream()
            .filter(dto -> {
              boolean isValid = this.validationUtil.isValid(dto);

              sb.append(isValid
                      ? String.format("Successfully imported job %s",
                      dto.getTitle())
                      : "Invalid job")
                      .append(System.lineSeparator());

              return isValid;
            })
            .map(dto -> {
              Job job = this.modelMapper.map(dto, Job.class);
              job.getCompanies().add(this.companyService.findCompanyById(dto.getCompanyId()));

              return job;
            })
            .forEach(this.jobRepository::save);

    return sb.toString().trim();
  }

  @Override
  public String getBestJobs() {
    return null;
  }
}

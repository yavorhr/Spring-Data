package softuni.exam.service;

import java.io.IOException;

public interface JobService {

    boolean areImported();

    String readJobsFileContent() throws IOException;

    String importJobs() throws IOException;

    String getBestJobs();
}

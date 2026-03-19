package kg.attractor.lesson_49.service;

import kg.attractor.lesson_49.dao.ResumeDao;
import kg.attractor.lesson_49.model.Resume;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResumeService {

    private final ResumeDao resumeDao;

    public List<Resume> getAll() {
        return resumeDao.findAll();
    }

    public List<Resume> getByCategory(String category) {
        return resumeDao.findByCategory(category);
    }
}
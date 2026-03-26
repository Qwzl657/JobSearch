package kg.attractor.lesson_49.service;

import kg.attractor.lesson_49.dao.ResumeDao;
import kg.attractor.lesson_49.error.exception.BadRequestException;
import kg.attractor.lesson_49.model.Resume;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ResumeService {

    private final ResumeDao resumeDao;

    public List<Resume> getAll() {
        log.debug("Fetching all resumes");
        return resumeDao.findAll();
    }

    public void create(Resume resume) {
        log.info("Creating resume: {}", resume.getName());
        resumeDao.create(resume);
    }

    public void update(Resume resume) {
        log.warn("Updating resume id={}", resume.getId());
        resumeDao.update(resume);
    }

    public void delete(Long id) {
        log.error("Deleting resume id={}", id);
        resumeDao.delete(id);
    }
    public void update(Resume resume) {

        if (resume.getId() == null) {
            throw new BadRequestException("ID обязателен");
        }

        resumeDao.update(resume);
    }
    public void delete(Long id) {

        if (id == null) {
            throw new BadRequestException("ID не может быть null");
        }

        resumeDao.delete(id);
    }
}
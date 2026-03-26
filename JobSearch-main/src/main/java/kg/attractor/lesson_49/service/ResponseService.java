package kg.attractor.lesson_49.service;

import kg.attractor.lesson_49.dao.ResponseDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResponseService {

    private final ResponseDao responseDao;

    public void respond(Long userId, Long vacancyId) {
        responseDao.respond(userId, vacancyId);
    }
}
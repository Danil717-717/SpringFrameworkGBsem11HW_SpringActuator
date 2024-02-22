package ru.springgb.less11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.springgb.less11.model.Session;

public interface SessionRepository extends JpaRepository<Session,Long> {
}

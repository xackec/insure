package com.dev.insure.repository;

import com.dev.insure.model.Subject;
import org.springframework.data.repository.Repository;

public interface SubjectRepository extends Repository<Subject, Long> {

    Subject save(Subject subject);
}

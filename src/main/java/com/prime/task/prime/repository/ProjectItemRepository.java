package com.prime.task.prime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectItemRepository extends JpaRepository<ProjectItemModel,Long> {

}

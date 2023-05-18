package com.jscode.projectclassjiyoungb.repository;

import com.jscode.projectclassjiyoungb.model.Board2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface Board2Repository extends JpaRepository<Board2, Long> {
    List<Board2> findAllByOrderByCreatedAtDesc();
}

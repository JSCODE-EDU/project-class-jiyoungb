package com.jscode.projectclassjiyoungb.repository;

import com.jscode.projectclassjiyoungb.model.Board2;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
//public interface Board2Repository extends JpaRepository<Board2, Long> {
public interface Board2Repository extends PagingAndSortingRepository<Board2, Long> {
    //List<Board2> findAllByOrderByCreatedAtDesc();
    List<Board2> findAllByOrderByCreatedAtDesc(Pageable pageable);

    List<Board2> findByTitleContainingIgnoreCaseOrderByCreatedAtDesc(String keyword, Pageable pageable);
}

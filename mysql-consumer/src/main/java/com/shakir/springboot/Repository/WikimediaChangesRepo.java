package com.shakir.springboot.Repository;

import com.shakir.springboot.Entity.WikimediaChanges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikimediaChangesRepo extends JpaRepository<WikimediaChanges, Long> {
}

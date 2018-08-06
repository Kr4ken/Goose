package com.kr4ken.goose.repository;

import com.kr4ken.goose.domains.MediaFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.stream.Collectors;

public interface MediaFileRepository extends JpaRepository<MediaFile, Long> {
    Optional<MediaFile> findById(Long Id);
}

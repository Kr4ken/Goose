package com.kr4ken.goose.services.impl;

import com.kr4ken.goose.domains.MediaFile;
import com.kr4ken.goose.repository.MediaFileRepository;
import com.kr4ken.goose.services.DatabaseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseManagerImpl implements DatabaseManager {
    @Autowired
    MediaFileRepository mediaFileRepository;

    @Override
    public void saveMediaFile(MediaFile mediaFile) {
        mediaFileRepository.save(mediaFile);
    }
}

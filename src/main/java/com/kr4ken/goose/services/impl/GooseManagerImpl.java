package com.kr4ken.goose.services.impl;

import com.kr4ken.goose.services.DatabaseManager;
import com.kr4ken.goose.services.FileManager;
import com.kr4ken.goose.services.GooseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class GooseManagerImpl implements GooseManager {

    @Autowired
    private FileManager fileManager;
    @Autowired
    private DatabaseManager databaseManager;



    @Override
    public void updateRepository(){
        fileManager.getMediaFiles().forEach(databaseManager::saveMediaFile);
    }
}

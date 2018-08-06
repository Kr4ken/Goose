package com.kr4ken.goose.services.impl;

import com.kr4ken.goose.domains.MediaFile;
import com.kr4ken.goose.services.FileManager;
import com.kr4ken.goose.setting.GooseSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FileManagerImpl implements FileManager {
//public class FileManagerImpl {


    private GooseSetting gooseSetting;

    @Override
    public List<MediaFile> getImages() {
        return null;
    }

    @Override
    public List<MediaFile> getVideos() {
        return null;
    }

    @Override
    public List<MediaFile> getMusic() {
        return null;
    }

    @Override
    public List<MediaFile> getTexts() {
        return null;
    }

    @Override
    public void addImage(MediaFile file) {

    }

    @Override
    public void addVideo(MediaFile file) {

    }

    @Override
    public void addMusic(MediaFile file) {

    }

    @Override
    public void moveFile(File file, Path newPath) {

    }

    @Override
    public void deleteFile(File file) {

    }

    @Override
    public void addFile(File file) {

    }

    @Override
    public void addFile(String urlFile) {

    }

    @Autowired
    public FileManagerImpl(
            GooseSetting gooseSetting
    ) {
        this.gooseSetting = gooseSetting;
    }

//    @Override
    public List<String> getFilePaths() {
//        ArrayList<String> res =  new ArrayList<>();
//        res.add(gooseSetting.getMainDirectory());
        List<String> res = null;
        try (Stream<Path> paths = Files.walk(Paths.get(gooseSetting.getMainDirectory()))) {
            res = paths.filter(Files::isRegularFile)
                    .map(file -> file.getFileName().toString())
                    .collect(Collectors.toList());
        }catch (IOException exception){
            System.out.println("Disaster");
        }

        return res;
    }

    @Override
    public List<MediaFile> getMediaFiles() {
        List<MediaFile> res = null;
        try (Stream<Path> paths = Files.walk(Paths.get(gooseSetting.getMediaDirectory()))) {
            res = paths.filter(Files::isRegularFile)
                    .map(file -> MediaFile.getFromPath(file.toAbsolutePath().toString()))
                    .filter(file-> !Objects.isNull(file.getType()))
                    .map(file -> {System.out.println(file);return file;})
                    .collect(Collectors.toList());
        }catch (IOException exception){
            System.out.println("Disaster");
        }
        return res;
    }
}

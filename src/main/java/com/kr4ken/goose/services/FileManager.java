package com.kr4ken.goose.services;

import com.kr4ken.goose.domains.MediaFile;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

public interface FileManager {

    List<MediaFile> getMediaFiles();

    List<MediaFile> getImages();
    List<MediaFile> getVideos();
    List<MediaFile> getMusic();
    List<MediaFile> getTexts();

    void addImage(MediaFile file);
    void addVideo(MediaFile file);
    void addMusic(MediaFile file);

    void moveFile(File file, Path newPath);
    void deleteFile(File file);
    void addFile(File file);
    void addFile(String urlFile);

}

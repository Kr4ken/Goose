package com.kr4ken.goose.domains;


import com.kr4ken.goose.utils.HashUtils;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Data
public class MediaFile {
    //TODO: Перенести куда нибудь
    private final static String IMAGE_EXTENTIONS = "jpg;jpeg;gif;png";
    private final static String VIDEO_EXTENTIONS = "webm;mp4;avi";
    private final static String MUSIC_EXTENTIONS = "mp3;flac";
    private final static String TEXT_EXTENTIONS = "txt;log";

    @Id
    @GeneratedValue
    private Long id;
    private String path;
    private String url;
    @Enumerated(EnumType.STRING)
    private MediaFile.MediaFileType type;
    private String hash;

    public static MediaFile getFromPath(String path){
       MediaFile mediaFile = new MediaFile();
       mediaFile.setPath(path);
//       String ext =path.split(".")[path.split(".").length-1];
       if(Arrays.stream(IMAGE_EXTENTIONS.split(";")).anyMatch(path::endsWith))
       mediaFile.setType(MediaFileType.IMAGE);
       if(Arrays.stream(VIDEO_EXTENTIONS.split(";")).anyMatch(path::endsWith))
            mediaFile.setType(MediaFileType.VIDEO);
       if(Arrays.stream(MUSIC_EXTENTIONS.split(";")).anyMatch(path::endsWith))
            mediaFile.setType(MediaFileType.MUSIC);
       if(Arrays.stream(TEXT_EXTENTIONS.split(";")).anyMatch(path::endsWith))
            mediaFile.setType(MediaFileType.TEXT);
       return mediaFile;
    }

    public void setPath(String path){
       this.path = path;
       this.hash = HashUtils.MD5Hash(this);
    }

    @ToString
    public enum MediaFileType {

        IMAGE("IMAGE"),
        VIDEO("VIDEO"),
        TEXT("TEXT"),
        MUSIC("MUSIC");

        @Getter
        private final String value;

        MediaFileType(String value) {
            this.value = value;
        }


    }
}

package com.kr4ken.goose.controllers;

import com.kr4ken.goose.domains.MediaFile;
import com.kr4ken.goose.repository.MediaFileRepository;
import com.kr4ken.goose.services.FileManager;
import com.kr4ken.goose.services.GooseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class MainRestController {
    private FileManager fileManager;
    @Autowired
    MediaFileRepository mediaFileRepository;
    @Autowired
    GooseManager gooseManager;

    public MainRestController(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    @RequestMapping(value = "test",method = RequestMethod.GET)
    @ResponseBody
    private String testPost(){
//        MediaFile mediaFile = new MediaFile();
//        mediaFile.setPath("/home/kraken/temp/goose/media/alisa.jpg");
//        mediaFile.setType(MediaFile.MediaFileType.MUSIC);
//        mediaFileRepository.save(mediaFile);
//        mediaFile = new MediaFile();
//        mediaFile.setPath("/home/kraken/temp/goose/media/alisa.jpg_");
//        mediaFile.setType(MediaFile.MediaFileType.MUSIC);
//        mediaFileRepository.save(mediaFile);
        gooseManager.updateRepository();
        return "Success";
    }


    @RequestMapping(value = "post",method = RequestMethod.POST)
    @ResponseBody
    private String testPost(@RequestBody AddRequest request){
//        List<String> files = fileManager.getFilePaths();
//        AddRequest request  = new AddRequest();
//        request.setAction(AddRequest.Action.ADD);
//        request.setType(AddRequest.ResourceType.IMAGE);
//        request.setUrl("Https://youtube.com");

        return request.getUrl() + request.getAction().toString() + request.getType().toString();

//        return "Hello world";
//        return files.stream().reduce("",(file1,file2) -> file1 + "<br>" + file2);
    }
}

package com.kr4ken.goose.utils;

import com.kr4ken.goose.domains.MediaFile;
//import com.sun.org.apache.xml.internal.security.algorithms.MessageDigestAlgorithm;
//import org.apache.commons.codec.digest.MessageDigestAlgorithms.SHA_224;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class HashUtils {

    public static String MD5Hash(MediaFile mediaFile) {
        try( FileInputStream fis = new FileInputStream(mediaFile.getPath())){
            return DigestUtils.md5DigestAsHex(fis);
        }
        catch (FileNotFoundException exeption){
            //TODO логирование
            return "";
        }
        catch (IOException exeption){
            //TODO логирование
            return "";
        }
    }
}

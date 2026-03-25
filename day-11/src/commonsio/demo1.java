package commonsio;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class demo1 {
     public static void main(String[] args) throws  Exception{
         //目标：使用commons-io包中的IOUtils工具类
         FileUtils.copyFile( new File("day-10\\src\\demo1"), new File("day-10\\src\\demo2"));
         //JDK7提供的
         //Files.copy(Path.of( "day-10\\src\\demo1"),  Path.of("day-10\\src\\demo2"));
     }
}

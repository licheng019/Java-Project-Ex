package com.cheng.learningspringboot;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.crsh.vfs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {
	
	private ImageRepository repository;
	private ResourceLoader resourceLoader;
	private static String UPLOAD_ROOT = "upload-dir";
	
	@Autowired
	public ImageService(ImageRepository repository, ResourceLoader resourceLoader) {
		this.repository = repository;
		this.resourceLoader = resourceLoader;
	}
	
	public Resource findOneImage(String filename) {
		return resourceLoader.getResource("file:" + UPLOAD_ROOT + "/" + filename);
	}
	
	public void createImage(MultipartFile file) throws IOException {
		if (!file.isEmpty()) {
			Files.copy(file.getInputStream(), Paths.get(UPLOAD_ROOT, file.getOriginalFilename()));
			repository.save(new Image(file.getOriginalFilename()));
		}
	}
	
	public void deleteImage(String filename) throws IOException {
		Image byName = repository.findByName(filename);
		repository.delete(byName);
		Files.delete(Paths.get(UPLOAD_ROOT , filename));
	}
	
	@Bean
	CommandLineRunner Setup(ImageRepository repository) {
		return (args) -> {
			FileSystemUtils.deleteRecursively(new File(UPLOAD_ROOT));
			Files.createDirectories(Paths.get(UPLOAD_ROOT));
			FileCopyUtils.copy("Test File", new FileWriter(UPLOAD_ROOT + "/test"));
			repository.save(new Image("test"));
			
			FileCopyUtils.copy("Test1 File", new FileWriter(UPLOAD_ROOT + "/test1"));
			repository.save(new Image("test1"));
			
			FileCopyUtils.copy("Test2 File", new FileWriter(UPLOAD_ROOT + "/test2"));
			repository.save(new Image("test2"));
		};
	}
}

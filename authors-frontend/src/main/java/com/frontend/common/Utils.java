package com.frontend.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Pattern;

import org.apache.commons.io.FilenameUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;

public class Utils {
	private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
	private static final Pattern WHITESPACE = Pattern.compile("[\\s]");
	private static String UPLOADED_FOLDER = "/Users/trieunhu/Documents/jsp/images/authors/";

	public static String getUserLogined() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

	public static String getNameFileUpload(String name) {
		String type = FilenameUtils.getExtension(name);
		String _name = name.replaceAll("." + type, "");
		Random r = new Random();
		return _name + r.nextInt(10000000) + "." + type;
	}

	public static String makeSlug(String input) {
		String nowhitespace = WHITESPACE.matcher(input).replaceAll("-");
		String normalized = Normalizer.normalize(nowhitespace, Form.NFD);
		String slug = NONLATIN.matcher(normalized).replaceAll("");
		return slug.toLowerCase(Locale.ENGLISH);
	}
	
	
	public static String uploadFile(MultipartFile file,String oldNameImage) {
		String nameFile = Utils.getNameFileUpload(file.getOriginalFilename());
		if(oldNameImage != null) {
			File oldFile = new File(UPLOADED_FOLDER+oldNameImage);
			if(oldFile.exists()) {
				oldFile.delete();
			}
		}
		try {

			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + nameFile);
			Files.write(path, bytes);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return nameFile;
	}
	
	public static int[] getPagination(int current,int begin,int end) {
		int[] arrs = {0,0,0,0};
		int br = 3,j=0;
		if(current == 1) {
			arrs[0] = 1;
		}
		int k = current;
		if((k + br) > end) {
			k = end - br + 1;
			if(k < 1) {
				k = 1;
			}
		}
		int ep = 0;
		for(int i = k; i <= end;i++) {
			j++;
			if(i == end) {
				ep = i;
				break;
			}
			if(j == br) {
				ep = i;
				break;
			}
			
		}
		arrs[1] = k;
		arrs[2] = ep;
		if(current == end) {
			arrs[3] = 1;
		}
		return arrs;
	}
}






































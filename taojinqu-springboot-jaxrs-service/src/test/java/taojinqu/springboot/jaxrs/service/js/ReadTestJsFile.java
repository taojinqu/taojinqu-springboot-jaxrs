package taojinqu.springboot.jaxrs.service.js;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadTestJsFile {
	public static String readFileByLines(String fileName) throws IOException {
		String path = ReadTestJsFile.class.getResource("").getPath();
		File file = new File(path + "/" + fileName);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
			String str = null;
			StringBuffer sb = new StringBuffer();
			while ((str = reader.readLine()) != null) {
				sb.append(str.trim());
			}
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
		return "";
	}
}
package androidCallGragh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ClearComment {

	
	
	String pack = "";
	
	
	public ClearComment(){}
	
	public  void deepDir(String rootDir) throws FileNotFoundException,
			UnsupportedEncodingException {
		File folder = new File(rootDir);
		if (folder.isDirectory()) {
			String[] files = folder.list();
			for (int i = 0; i < files.length; i++) {
				File file = new File(folder, files[i]);
				if (file.isDirectory() && file.isHidden() == false) {
					deepDir(file.getPath());
				} else if (file.isFile()) {
					clearComment(file.getPath());
				}
			}
		} else if (folder.isFile()) {
			clearComment(folder.getPath());
		}
	}
	
	public  void clearComment(String filePathAndName)
			throws FileNotFoundException, UnsupportedEncodingException {
		StringBuffer buffer = new StringBuffer();
		String line = null;
		InputStream is = new FileInputStream(filePathAndName);
		BufferedReader reader = new BufferedReader(new InputStreamReader(is,
				"UTF-8"));
		try {
			line = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		while (line != null) {
			buffer.append(line);
			buffer.append("\r\n");
			try {
				line = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String filecontent = buffer.toString();
		Map<String, String> patterns = new HashMap<String, String>();
		patterns.put("([^:])\\/\\/.*", "$1");
		patterns.put("\\s+\\/\\/.*", "");
		patterns.put("^\\/\\/.*", "");
		patterns.put("^\\/\\*\\*.*\\*\\/$", "");
		patterns.put("\\/\\*.*\\*\\/", "");
		patterns.put("/\\*(\\s*\\*\\s*.*\\s*?)*\\*\\/", "");
		Iterator<String> keys = patterns.keySet().iterator();
		String key = null, value = "";
		while (keys.hasNext()) {
			key = keys.next();
			value = patterns.get(key);
			filecontent = replaceAll(filecontent, key, value);
		}
		try {
			File f = new File(filePathAndName);
			if (!f.getParentFile().exists()) {
				f.getParentFile().mkdirs();
			}
			FileOutputStream out = new FileOutputStream(filePathAndName);
			byte[] bytes = filecontent.getBytes("UTF-8");
			out.write(bytes);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public  String replaceAll(String fileContent, String patternString,
			String replace) {
		String str = "";
		Matcher m = null;
		Pattern p = null;
		try {
			p = Pattern.compile(patternString);
			m = p.matcher(fileContent);
			str = m.replaceAll(replace);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			m = null;
			p = null;
		}
		return str;
	}
	
	public String qukonghang(String filepath) {
		try {
			FileReader reader = new FileReader(filepath);
			BufferedReader br = new BufferedReader(reader);
			FileWriter writer = new FileWriter(filepath + ".noblank");
			BufferedWriter bw = new BufferedWriter(writer);
			String str = null;
			String temp;
			while ((str = br.readLine()) != null) {
				temp = str;
				if(str.contains("package")){
					String[] temp11 = str.split(" ");
					pack = temp11[1];
					
				}
				if (temp.trim().length() < 1)
					continue;
				else {
					bw.write(str+"\r\n");
				}
			}
			br.close();
			reader.close();
			bw.close();
			writer.close();
			return pack;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return pack;
		} catch (IOException e) {
			e.printStackTrace();
			return pack;
		}
	}
	

}

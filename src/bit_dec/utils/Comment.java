package bit_dec.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Comment {
	
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
}

package utils;


/**
 * 2010-4-12
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * ZIP鍘嬬缉宸ュ叿
 * 
 * @author <a href="mailto:zlex.dongliang@gmail.com">姊佹爧</a>
 * @since 1.0
 */
public abstract class ZipUtils {

	public static final String EXT = ".zip";
	private static final String BASE_DIR = "";

	// 绗﹀彿"/"鐢ㄦ潵浣滀负鐩綍鏍囪瘑鍒ゆ柇绗�
	private static final String PATH = "/";
	private static final int BUFFER = 1024;

	/**
	 * 鍘嬬缉
	 * 
	 * @param srcFile
	 * @throws Exception
	 */
	public static void compress(File srcFile) throws Exception {
		String name = srcFile.getName();
		String basePath = srcFile.getParent();
		String destPath = basePath + name + EXT;
		compress(srcFile, destPath);
	}

	/**
	 * 鍘嬬缉
	 * 
	 * @param srcFile
	 *            婧愯矾寰�
	 * @param destPath
	 *            鐩爣璺緞
	 * @throws Exception
	 */
	public static void compress(File srcFile, File destFile) throws Exception {

		// 瀵硅緭鍑烘枃浠跺仛CRC32鏍￠獙
		CheckedOutputStream cos = new CheckedOutputStream(new FileOutputStream(
				destFile), new CRC32());

		ZipOutputStream zos = new ZipOutputStream(cos);

		compress(srcFile, zos, BASE_DIR);

		zos.flush();
		zos.close();
	}

	/**
	 * 鍘嬬缉鏂囦欢
	 * 
	 * @param srcFile
	 * @param destPath
	 * @throws Exception
	 */
	public static void compress(File srcFile, String destPath) throws Exception {
		compress(srcFile, new File(destPath));
	}

	/**
	 * 鍘嬬缉
	 * 
	 * @param srcFile
	 *            婧愯矾寰�
	 * @param zos
	 *            ZipOutputStream
	 * @param basePath
	 *            鍘嬬缉鍖呭唴鐩稿璺緞
	 * @throws Exception
	 */
	private static void compress(File srcFile, ZipOutputStream zos,
			String basePath) throws Exception {
		if (srcFile.isDirectory()) {
			compressDir(srcFile, zos, basePath);
		} else {
			compressFile(srcFile, zos, basePath);
		}
	}

	/**
	 * 鍘嬬缉
	 * 
	 * @param srcPath
	 * @throws Exception
	 */
	public static void compress(String srcPath) throws Exception {
		File srcFile = new File(srcPath);

		compress(srcFile);
	}

	/**
	 * 鏂囦欢鍘嬬缉
	 * 
	 * @param srcPath
	 *            婧愭枃浠惰矾寰�
	 * @param destPath
	 *            鐩爣鏂囦欢璺緞
	 * 
	 */
	public static void compress(String srcPath, String destPath)
			throws Exception {
		File srcFile = new File(srcPath);

		compress(srcFile, destPath);
	}

	/**
	 * 鍘嬬缉鐩綍
	 * 
	 * @param dir
	 * @param zos
	 * @param basePath
	 * @throws Exception
	 */
	private static void compressDir(File dir, ZipOutputStream zos,
			String basePath) throws Exception {

		File[] files = dir.listFiles();

		// 鏋勫缓绌虹洰褰�
		if (files.length < 1) {
			ZipEntry entry = new ZipEntry(basePath + dir.getName() + PATH);

			zos.putNextEntry(entry);
			zos.closeEntry();
		}

		for (File file : files) {

			// 閫掑綊鍘嬬缉
			compress(file, zos, basePath + dir.getName() + PATH);

		}
	}

	/**
	 * 鏂囦欢鍘嬬缉
	 * 
	 * @param file
	 *            寰呭帇缂╂枃浠�
	 * @param zos
	 *            ZipOutputStream
	 * @param dir
	 *            鍘嬬缉鏂囦欢涓殑褰撳墠璺緞
	 * @throws Exception
	 */
	private static void compressFile(File file, ZipOutputStream zos, String dir)
			throws Exception {

		/**
		 * 鍘嬬缉鍖呭唴鏂囦欢鍚嶅畾涔�
		 * 
		 * <pre>
		 * 濡傛灉鏈夊绾х洰褰曪紝閭ｄ箞杩欓噷灏遍渶瑕佺粰鍑哄寘鍚洰褰曠殑鏂囦欢鍚�
		 * 濡傛灉鐢╓inRAR鎵撳紑鍘嬬缉鍖咃紝涓枃鍚嶅皢鏄剧ず涓轰贡鐮�
		 * </pre>
		 */
		ZipEntry entry = new ZipEntry(dir + file.getName());

		zos.putNextEntry(entry);

		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
				file));

		int count;
		byte data[] = new byte[BUFFER];
		while ((count = bis.read(data, 0, BUFFER)) != -1) {
			zos.write(data, 0, count);
		}
		bis.close();

		zos.closeEntry();
	}

	/**
	 * 瑙ｅ帇缂�
	 * 
	 * @param srcFile
	 * @throws Exception
	 */
	public static void decompress(File srcFile) throws Exception {
		String basePath = srcFile.getParent();
		decompress(srcFile, basePath);
	}

	/**
	 * 瑙ｅ帇缂�
	 * 
	 * @param srcFile
	 * @param destFile
	 * @throws Exception
	 */
	public static void decompress(File srcFile, File destFile) throws Exception {

		CheckedInputStream cis = new CheckedInputStream(new FileInputStream(
				srcFile), new CRC32());

		ZipInputStream zis = new ZipInputStream(cis);
		decompress(destFile, zis);

	 
		zis.close();

	}

	/**
	 * 瑙ｅ帇缂�
	 * 
	 * @param srcFile
	 * @param destPath
	 * @throws Exception
	 */
	public static void decompress(File srcFile, String destPath)
			throws Exception {
		decompress(srcFile, new File(destPath));

	}

	/**
	 * 鏂囦欢 瑙ｅ帇缂�
	 * 
	 * @param destFile
	 *            鐩爣鏂囦欢
	 * @param zis
	 *            ZipInputStream
	 * @throws Exception
	 */
	private static void decompress(File destFile, ZipInputStream zis)
			throws Exception {

		ZipEntry entry = null;
		while ((entry = zis.getNextEntry()) != null) {

			// 鏂囦欢
			String dir = destFile.getPath() + File.separator + entry.getName();

			File dirFile = new File(dir);

			// 鏂囦欢妫�煡
			fileProber(dirFile);

			if (entry.isDirectory()) {
				dirFile.mkdirs();
			} else {
				decompressFile(dirFile, zis);
			}
			zis.closeEntry();
		}
	}

	/**
	 * 鏂囦欢 瑙ｅ帇缂�
	 * 
	 * @param srcPath
	 *            婧愭枃浠惰矾寰�
	 * 
	 * @throws Exception
	 */
	public static void decompress(String srcPath) throws Exception {
		File srcFile = new File(srcPath);

		decompress(srcFile);
	}

	/**
	 * 鏂囦欢 瑙ｅ帇缂�
	 * 
	 * @param srcPath
	 *            婧愭枃浠惰矾寰�
	 * @param destPath
	 *            鐩爣鏂囦欢璺緞
	 * @throws Exception
	 */
	public static void decompress(String srcPath, String destPath)
			throws Exception {

		File srcFile = new File(srcPath);
		decompress(srcFile, destPath);
	}

	/**
	 * 鏂囦欢瑙ｅ帇缂�
	 * 
	 * @param destFile
	 *            鐩爣鏂囦欢
	 * @param zis
	 *            ZipInputStream
	 * @throws Exception
	 */
	private static void decompressFile(File destFile, ZipInputStream zis)
			throws Exception {

		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(destFile));

		int count;
		byte data[] = new byte[BUFFER];
		while ((count = zis.read(data, 0, BUFFER)) != -1) {
			bos.write(data, 0, count);
		}

		bos.write(data);

		bos.close();
	}

	/**
	 * 鏂囦欢鎺㈤拡
	 * 
	 * <pre>
	 * 褰撶埗鐩綍涓嶅瓨鍦ㄦ椂锛屽垱寤虹洰褰曪紒
	 * </pre>
	 * 
	 * @param dirFile
	 */
	private static void fileProber(File dirFile) {

		File parentFile = dirFile.getParentFile();
		if (!parentFile.exists()) {

			// 閫掑綊瀵绘壘涓婄骇鐩綍
			fileProber(parentFile);

			parentFile.mkdir();
		}

	}

}

package cn.ibizlab.util.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipUtils {

	private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(ZipUtils.class);

	public static void zip(File file, File zipFile) throws IOException {
		long nBeginTime = System.currentTimeMillis();
		try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFile))) {
			long nTime = System.currentTimeMillis();
			zip(file, zipOutputStream);
			log.debug(String.format("压缩文件[%1$s]耗时[%2$s]ms", file.getAbsolutePath(), System.currentTimeMillis() - nTime));
			zipOutputStream.flush();
			zipOutputStream.close();
		}
		log.debug(String.format("生成压缩文件[%1$s]耗时[%2$s]ms", zipFile.getAbsolutePath(), System.currentTimeMillis() - nBeginTime));
	}

	public static void zip(List<File> fileList, File zipFile) throws IOException {
		long nBeginTime = System.currentTimeMillis();
		try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFile))) {
			for(File file : fileList) {
				long nTime = System.currentTimeMillis();
				zip(file, zipOutputStream);
				log.debug(String.format("压缩文件[%1$s]耗时[%2$s]ms", file.getAbsolutePath(), System.currentTimeMillis() - nTime));
			}
			zipOutputStream.flush();
			zipOutputStream.close();
		}
		log.debug(String.format("生成压缩文件[%1$s]耗时[%2$s]ms", zipFile.getAbsolutePath(), System.currentTimeMillis() - nBeginTime));
	}
	
	public static void zip(File file, ZipOutputStream zipOutputStream) throws IOException {
		int nFolderLength = 0;
		if (file.isFile()) {
			nFolderLength = file.getParentFile().getAbsolutePath().length();
		} else {
			nFolderLength = file.getAbsolutePath().length();
		}
		zip(file, zipOutputStream, nFolderLength + 1);
	}

	public static void zip(File file, ZipOutputStream zipOutputStream, int nFolderLength) throws IOException {

		if (file.isFile()) {
			ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
			ZipEntry zipEntry = new ZipEntry(file.getAbsolutePath().substring(nFolderLength).replace("\\", "/"));
			zipEntry.setTime(file.lastModified());
			zipOutputStream.putNextEntry(zipEntry);

			try (FileInputStream fis = new FileInputStream(file); FileChannel channel = fis.getChannel();) {
				while (true) {
					byteBuffer.clear();
					int read = channel.read(byteBuffer);
					if (read == -1)
						break;
					zipOutputStream.write(byteBuffer.array(), 0, read);
				}
			}
			zipOutputStream.closeEntry();
		} else {
			File[] files = file.listFiles();
			if (files == null || files.length == 0) {
				ZipEntry zipEntry = new ZipEntry(file.getAbsolutePath().substring(nFolderLength).replace("\\", "/") + "/");
				zipEntry.setTime(file.lastModified());
				zipOutputStream.putNextEntry(zipEntry);
				zipOutputStream.closeEntry();
			} else {
				for (File item : files) {
					zip(item, zipOutputStream, nFolderLength);
				}
			}
		}


	}

	public static void unzip(File zipFile, File dstFolder) throws IOException {

		if (!dstFolder.exists()) {
			dstFolder.mkdirs();
		}

		String destDir = dstFolder.getAbsolutePath();

		// buffer to read and write data in the file
		byte[] buffer = new byte[1024];
		try(FileInputStream fis = new FileInputStream(zipFile); ZipInputStream zis = new ZipInputStream(fis); ) {
			ZipEntry ZE = zis.getNextEntry();
			while (ZE != null) {
				String fileName = ZE.getName();
				File newFile = new File(destDir + File.separator + fileName);
				new File(newFile.getParent()).mkdirs();
				FileOutputStream fos = new FileOutputStream(newFile);
				int len;
				while ((len = zis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				fos.close();
				// close this ZipEntry
				zis.closeEntry();
				ZE = zis.getNextEntry();
			}

		}
	}

	public static void main(String[] args) {

		try {
			long nTime = System.currentTimeMillis();
			ZipOutputStream zipOutputStream;
			zipOutputStream = new ZipOutputStream(new FileOutputStream(new File("d:/aa.zip")));

			zip(new File("I:\\code\\DEMO\\CBD466CC-A18A-47EC-A018-A6E7E5AB191F\\trunk\\TEST11\\model"), zipOutputStream);
			zipOutputStream.flush();
			zipOutputStream.close();

			nTime = System.currentTimeMillis() - nTime;
			System.out.print(String.format("压缩文件耗时[%1$s]ms", nTime));

			nTime = System.currentTimeMillis();
			unzip(new File("d:/aa.zip"), new File("d:/aaaa"));
			nTime = System.currentTimeMillis() - nTime;
			System.out.print(String.format("解压文件耗时[%1$s]ms", nTime));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

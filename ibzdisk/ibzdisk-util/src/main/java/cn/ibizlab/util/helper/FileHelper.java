package cn.ibizlab.util.helper;

import lombok.extern.slf4j.Slf4j;
import org.apache.tools.tar.TarEntry;
import org.apache.tools.tar.TarInputStream;
import org.springframework.util.StringUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

@Slf4j
public class FileHelper {

    /**
     * zip解压
     * @param zipFile  zip文件路径
     * @param descDir 解压目录
     */
    public static boolean unzip(File zipFile, String descDir , boolean exp) throws IOException
    {
        try {
            //解决zip文件中有中文目录或者中文文件
            ZipFile zip = new ZipFile(zipFile, Charset.forName("GBK"));
            String root = zipFile.getName().replace(".zip","/");
            for(Enumeration files = zip.entries(); files.hasMoreElements();)
            {
                ZipEntry file = (ZipEntry)files.nextElement();
                String fileName = exp?file.getName().replace(root,""):file.getName();
                InputStream in = zip.getInputStream(file);
                if(StringUtils.isEmpty(fileName)){
                    continue;
                }
                String outPath = (descDir+File.separator+fileName).replaceAll("\\\\", "/");
                //输出文件路径信息
                log.debug(outPath);
                //判断路径是否存在,不存在则创建文件路径
                File folder = new File(outPath.substring(0, outPath.lastIndexOf('/')));
                if(!folder.exists())
                {
                    folder.mkdirs();
                }
                //判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
                if(new File(outPath).isDirectory())
                {
                    continue;
                }

                OutputStream out = new FileOutputStream(outPath);
                byte[] buf1 = new byte[1024];
                int len;
                while((len=in.read(buf1))>0)
                {
                    out.write(buf1,0,len);
                }
                in.close();
                out.close();
            }
            log.debug("******************解压完毕********************");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * tar.gz解压
     * @param zipFile  zip文件路径
     * @param descDir 解压目录
     */
    public static void unTarGz(File zipFile, String descDir,boolean exp) throws IOException{
        TarInputStream tarIn = null;
        try{
            log.debug("***************************开始解压缩tar.gz格式文件***************************");
            tarIn = new TarInputStream(new GZIPInputStream(
                    new BufferedInputStream(new FileInputStream(zipFile))),
                    1024 * 2);
            //创建输出目录
            String root = zipFile.getName().replace(".tar.gz","/");
            createDirectory(descDir,null);
            TarEntry entry = null;
            String fileName = null;
            while((entry = tarIn.getNextEntry()) != null ){

                if(entry.isDirectory()){
                    continue;
                }else{
                    if(!root.equals(entry.getName().split("/")[0]) && entry.getName().contains("/")){
                        fileName = exp ? entry.getName().replace(entry.getName().split("/")[0],"") : entry.getName();
                    }else {
                        fileName = exp ? entry.getName().replace(root,"") : entry.getName();
                    }
                    //是文件
                    File tmpFile = new File(descDir + "/" + fileName);
                    log.debug("正在输出文件：{}",tmpFile.getPath());
                    //创建输出目录
                    createDirectory(tmpFile.getParent() + "/",null);
                    OutputStream out = null;
                    try{
                        out = new FileOutputStream(tmpFile);
                        int length = 0;

                        byte[] b = new byte[2048];

                        while((length = tarIn.read(b)) != -1){
                            out.write(b, 0, length);
                        }
                    }catch(IOException ex){
                        throw ex;
                    }finally{
                        if(out!=null){
                            out.close();
                        }
                    }
                }
            }
        }catch(IOException ex){
            throw new IOException("解压归档文件出现异常",ex);
        } finally{
            try{
                if(tarIn != null){
                    tarIn.close();
                }
            }catch(IOException ex){
                throw new IOException("关闭tarFile出现异常",ex);
            }
            log.debug("***************************解压缩tar.gz格式文件结束***************************");
        }
    }

    /**
     * 构建目录
     * @param outputDir
     * @param subDir
     */
    public static void createDirectory(String outputDir,String subDir) {
        File file = new File(outputDir);
        //子目录不为空
        if (!(subDir == null || subDir.trim().equals(""))) {
            file = new File(outputDir + "/" + subDir);
        }
        if (!file.exists()) {
            if (!file.getParentFile().exists())
                file.getParentFile().mkdirs();
            file.mkdirs();
        }
    }

    /**
     * 复制文件夹
     *
     * @param resource 源路径
     * @param target   目标路径
     */
    public static void copyFolder(String resource, String target) throws Exception {

        File resourceFile = new File(resource);
        if (!resourceFile.exists()) {
            throw new Exception("源目标路径：[" + resource + "] 不存在...");
        }
        File targetFile = new File(target);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        // 获取源文件夹下的文件夹或文件
        File[] resourceFiles = resourceFile.listFiles();
        for (File file : resourceFiles) {
            File file1 = new File(targetFile.getAbsolutePath() + File.separator + resourceFile.getName());
            // 复制文件
            if (file.isFile()) {
                log.debug(file.getPath());
                // 在 目标文件夹（B） 中 新建 源文件夹（A），然后将文件复制到 A 中
                // 这样 在 B 中 就存在 A
                if (!file1.exists()) {
                    file1.mkdirs();
                }
                File targetFile1 = new File(file1.getAbsolutePath() + File.separator + file.getName());
                copyFile(file, targetFile1);
            }
            // 复制文件夹
            if (file.isDirectory()) {// 复制源文件夹
                String dir1 = file.getAbsolutePath();
                // 目的文件夹
                String dir2 = file1.getAbsolutePath();
                copyFolder(dir1, dir2);
            }
        }

    }

    /**
     * 复制文件
     *
     * @param resource
     * @param target
     */
    public static void copyFile(File resource, File target) throws Exception {
        // 文件输入流并进行缓冲
        FileInputStream inputStream = new FileInputStream(resource);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

        // 文件输出流并进行缓冲
        FileOutputStream outputStream = new FileOutputStream(target);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

        // 缓冲数组
        // 大文件 可将 1024 * 2 改大一些，但是 并不是越大就越快
        byte[] bytes = new byte[1024 * 2];
        int len = 0;
        while ((len = inputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes, 0, len);
        }
        // 刷新输出缓冲流
        bufferedOutputStream.flush();
        //关闭流
        bufferedInputStream.close();
        bufferedOutputStream.close();
        inputStream.close();
        outputStream.close();
    }

    /**
     * 删除文件
     *
     * @param dirPath
     */
    public static void deleteDir(String dirPath) {
        File file = new File(dirPath);
        if (file.isFile()) {
            file.delete();
        } else {
            File[] files = file.listFiles();
            if (files == null) {
                file.delete();
            } else {
                for (int i = 0; i < files.length; i++) {
                    deleteDir(files[i].getAbsolutePath());
                }
                file.delete();
            }
        }
    }
}

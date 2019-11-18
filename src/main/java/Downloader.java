import lombok.SneakyThrows;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class Downloader {

    @SneakyThrows
    public void download(String mediaUrl, String rootPath) {
        URL url = new URL(mediaUrl);
        String fileName = url.getFile();
        String destName = rootPath + fileName.substring(fileName.lastIndexOf("/"));
        System.out.println(destName);
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(destName);
        byte[] b = new byte[2048];
        int length;
        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }
        is.close();
        os.close();
    }
}

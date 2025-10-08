package base.io;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * files
 *
 * @author relsola
 */
@Slf4j
public class files {

    public static void main(String[] args) throws IOException {
        File f = new File("././base/src/main/resources/hello.txt");
        log.info("File name: {}", f.getName());
        log.info("Absolute path: {}", f.getAbsolutePath());
        log.info("getCanonicalPath path: {}", f.getCanonicalPath());

        try (InputStream input = new FileInputStream(f)) {
            byte[] buffer = new byte[1000];
            int n;
            while ((n = input.read(buffer)) != -1) {
                log.info(new String(buffer, 0, n));
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        File file = new File("././base/src/main/resources/test.cc");
        if (file.createNewFile()) {
            try (OutputStream output = new FileOutputStream(file)) {
                output.write("int main() {\n".getBytes());
                output.write("  return 0;\n".getBytes());
                output.write("}\n".getBytes());
            }
        } else {
            log.info("File already exists.");
        }
    }
}

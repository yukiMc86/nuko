package base.except;

import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * except
 *
 * @author relsola
 */
@Slf4j
public class except {
    public static void main(String[] args) {
        byte[] bs = toGBK("中文");
        log.info(Arrays.toString(bs));
    }

    static byte[] toGBK(String s) {
        try {
            // 用指定编码转换String为byte[]:
            return s.getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
            // 如果系统不支持GBK编码，会捕获到UnsupportedEncodingException:
            log.info(e.getMessage()); // 打印异常信息
            return s.getBytes(); // 尝试使用默认编码
        } finally {
            log.info("END");
        }
    }
}

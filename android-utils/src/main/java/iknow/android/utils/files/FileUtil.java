package iknow.android.utils.files;

import android.text.TextUtils;

import java.io.File;

/**
 * Author：J.Chou
 * Date：  2016.07.20 11:51.
 * Email： who_know_me@163.com
 * Describe:
 */
@SuppressWarnings("ResultOfMethodCallIgnored")
public class FileUtil {
    /**
     *
     * @param filePath filePath
     * @return boolean
     */
    public static boolean isFileExist(String filePath) {
        if (TextUtils.isEmpty(filePath)) return false;
        File file = new File(filePath);
        return (file.exists() && file.isFile() && file.length() > 0);
    }

    /**
     *
     * @param path path
     * @return boolean
     */
    public static boolean deleteFile(String path) {
        if (TextUtils.isEmpty(path)) {
            return false;
        }

        File file = new File(path);
        if (!file.exists()) {
            return false;
        }
        if (file.isFile()) {
            return file.delete();
        }
        if (!file.isDirectory()) {
            return false;
        }
        for (File f : file.listFiles()) {
            if (f.isFile()) {
                f.delete();
            } else if (f.isDirectory()) {
                deleteFile(f.getAbsolutePath());
            }
        }
        return file.delete();
    }

    public static long getFileSize(String path) {
        if (!isFileExist(path)) return -1;
        File file = new File(path);
        return (file.exists() && file.isFile() ? file.length() : -1);
    }
}

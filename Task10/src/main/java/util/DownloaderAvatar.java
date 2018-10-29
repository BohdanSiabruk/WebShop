package util;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.awt.*;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class DownloaderAvatar {
    private static final String IMAGE_NAME = "file_name";
    private static final String DEFAULT_AVATAR = "avatar.png";
    private static final String EMAIL = "email";

    private DownloaderAvatar() {
    }

    public static String upload(HttpServletRequest req, String contextPath) throws IOException, ServletException {

        Part avatar = req.getPart(IMAGE_NAME);
        InputStream inputStream = avatar.getInputStream();
        Image image = ImageIO.read(inputStream);
        if (image == null) {
            return DEFAULT_AVATAR;
        }
        String imageName = req.getParameter(EMAIL) + ".png";
        ImageIO.write((RenderedImage) image, "png", new File(contextPath + imageName));
        return imageName;
    }

    public static class UserMapper {
    }
}

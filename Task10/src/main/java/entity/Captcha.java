package entity;

import java.awt.image.BufferedImage;
import java.util.UUID;

public class Captcha {

    private String uuid;
    private String value;
    private BufferedImage bufferedImage;

    public Captcha(String value, BufferedImage bufferedImage) {
        this.uuid = UUID.randomUUID().toString();

        this.value = value;
        this.bufferedImage = bufferedImage;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUuid() {
        return uuid;
    }


    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }


    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public void cleanValue() {
        this.value = "";
    }
}

package net.lainiao.dicom.common.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class QrImgUtils {

    private static Logger logger = LoggerFactory.getLogger(QrImgUtils.class);

    private static final int BLACK = 0xFF000000;
    private static final int WHITE = 0xFFFFFFFF;
    /**
     * 长
     * */
    private static final int HEIGHT = 300;
    /***
     * 宽
     * */
    private static final int WIDTH = 300;

    /**
     * 把生成的二维码存入到图片中
     * @param matrix zxing包下的二维码类
     * @return
     */
    public static BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
            }
        }
        return image;
    }
    /**
     * 生成二维码并写入文件
     * @param content 扫描二维码的内容
     * @param format 图片格式 jpg
     * @param file  文件
     * @throws Exception
     */
    public static void writeToFile(String content, String format, File file) throws IOException {
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        @SuppressWarnings("rawtypes")
        Map hints = new HashMap();
        //设置UTF-8， 防止中文乱码
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        //设置二维码四周白色区域的大小
        hints.put(EncodeHintType.MARGIN,12);
        //设置二维码的容错性
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        //画二维码
        BitMatrix bitMatrix = null;
        try {
            bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, WIDTH, HEIGHT, hints);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        BufferedImage image = toBufferedImage(bitMatrix);
        ImageIO.write(image, format, file);
    }

    /**
     * 给二维码图片加上文字
     * @param pressText 文字
     * @param qrFile  二维码文件
     * @param fontStyle
     * @param color
     * @param fontSize
     */
    public static void pressText(String pressText, File qrFile, int fontStyle, Color color, int fontSize) throws Exception {
        //pressText = new String(pressText.getBytes("UTF-8"),"UTF-8");
        Image src = ImageIO.read(qrFile);
        int imageW = src.getWidth(null);
        int imageH = src.getHeight(null);
        BufferedImage image = new BufferedImage(imageW, imageH, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.createGraphics();
        g.drawImage(src, 0, 0, imageW, imageH, null);
        //设置画笔的颜色
        g.setColor(color);
        //设置字体
        Font font = new Font("微软雅黑", fontStyle, fontSize);
        FontMetrics metrics = g.getFontMetrics(font);
        //文字在图片中的坐标 这里设置在中间
        String idStr = null;
        String patientStr = null;
        String tStr = null;
        int pY = 278;
        int pX = 0;
        int tY = 295;
        int tX = 0;
        if (pressText.indexOf("#") > -1){
            idStr = pressText.substring(0,pressText.indexOf("#"));
            patientStr = pressText.substring(pressText.indexOf("#") + 1,pressText.indexOf("&"));
            tStr = pressText.substring(pressText.indexOf("&") + 1);
            pX = (WIDTH - metrics.stringWidth(patientStr)) / 2;
            tX = (WIDTH - metrics.stringWidth(tStr)) / 2;
        }else {
            idStr = pressText.substring(0,pressText.indexOf("&"));
            tStr = pressText.substring(pressText.indexOf("&") + 1);
            tX = (WIDTH - metrics.stringWidth(tStr)) / 2;
        }
        int startX = (WIDTH - metrics.stringWidth(idStr)) / 2;
        int startY = 265;
        g.setFont(font);
        g.drawString(idStr, startX, startY);
        if (StringUtils.isNotEmpty(patientStr)){
            g.drawString(patientStr,pX,pY);
        }
        g.drawString(tStr,tX,tY);
        g.dispose();
        FileOutputStream out = new FileOutputStream(qrFile);
        ImageIO.write(image, "JPEG", out);
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        encoder.encode(image);
        out.close();
        logger.info("image press success");
    }

    public static void main(String[] args) throws Exception {
        File qrcFile = new File("D:/qr","google.jpg");
        writeToFile("http://localhost:8070/report-external/show?studyId=8&studyCode=39085C7F2AF69D1573460DBD2D786923", "jpg", qrcFile);
        pressText("ID: 10010#姓名:ok&请使用微信扫描二维码查看报告", qrcFile, 8, Color.black, 10);
    }

}

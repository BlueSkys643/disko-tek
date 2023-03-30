package IDScanner;

// Java code to read the QR code


import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class QRCode {

    // Function to read the QR file
    public static String readQR(String path, String charset, Map hashMap)
            throws FileNotFoundException, IOException, NotFoundException
    {
        BinaryBitmap binaryBitmap
                = new BinaryBitmap(new HybridBinarizer(
                new BufferedImageLuminanceSource(
                        ImageIO.read(
                                new FileInputStream(path)))));


        Result result
                = new MultiFormatReader().decode(binaryBitmap);


        return result.getText();
    }

    // Function to check if the person is over 21 years old
    public static boolean isOver21(Date birthDate) {
        Calendar birthCalendar = Calendar.getInstance();
        birthCalendar.setTime(birthDate);
        Calendar nowCalendar = Calendar.getInstance();
        nowCalendar.add(Calendar.YEAR, -21);
        return nowCalendar.after(birthCalendar);
    }

        // Driver code
    public static void main(String[] args)
            throws WriterException, IOException,
            NotFoundException {


        // Path where the QR code is saved
        String path = "path";


        // Encoding charset
        String charset = "UTF-8";


        Map<EncodeHintType, ErrorCorrectionLevel> hashMap
                = new HashMap<EncodeHintType,
                ErrorCorrectionLevel>();


        hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        String dob = getDOBFromQR(path, charset, hashMap);
        Date birthDate = parseDate(dob);

        if (isOver21(birthDate)) {
            System.out.println("The person is over 21 years old");
        } else {
            System.out.println("The person is under 21 years old");
        }


        System.out.println("QRCode output: " + readQR(path, charset, hashMap));
        System.out.println("Date of Birth: " + QRCode.getDOBFromQR(path, charset, hashMap));

    }


    public static String getDOBFromQR(String path, String charset, Map hashMap)
            throws FileNotFoundException, IOException, NotFoundException {BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(new FileInputStream(path)))));

        Result result = new MultiFormatReader().decode(binaryBitmap);

        String qrText = result.getText();
        String dob = qrText.substring(qrText.indexOf("DBB") + 3, qrText.indexOf("DBB") + 11);

        return dob;
    }

    private static Date parseDate(String dateString) {
        try {
            return new SimpleDateFormat("yyyyMMdd").parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }


}

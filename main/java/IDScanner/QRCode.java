package IDScanner;
// Java code to read the QR code

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class QRCode {

    // Function to read the QR file
    public static String readQR(String path, String charset, Map hashMap)
            throws FileNotFoundException, IOException, NotFoundException
    {
        // Create a binary bitmap from the QR code image
        BinaryBitmap binaryBitmap
                = new BinaryBitmap(new HybridBinarizer(
                new BufferedImageLuminanceSource(
                        ImageIO.read(
                                new FileInputStream(path)))));

        // Decode the binary bitmap to get the QR code text
        Result result
                = new MultiFormatReader().decode(binaryBitmap);

        // Return the QR code text
        return result.getText();
    }

    // Function to extract the date of birth from the QR code text
    public static String getDOBFromQR(String path)
            throws FileNotFoundException, IOException, NotFoundException {
        // Create a binary bitmap from the QR code image
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(new FileInputStream(path)))));

        // Decode the binary bitmap to get the QR code text
        Result result = new MultiFormatReader().decode(binaryBitmap);

        // Extract the date of birth from the QR code text
        String qrText = result.getText();
        String dob = qrText.substring(qrText.indexOf("DBB") + 3, qrText.indexOf("DBB") + 11);

        // Return the date of birth as a string
        return dob;
    }

    // Function to check if the person is over 21 years old
    public static boolean isOver21(String dob) {
        // Parse the date of birth string into a LocalDate object
        LocalDate birthDate = parseDOB(dob);

        // Get today's date
        LocalDate today = LocalDate.now();

        // Check if the person is over 21 years old
        if (birthDate != null) {
            if (Period.between(birthDate, today).getYears() >= 21) {
                // Open a new tab if user is over 21
                if (Desktop.isDesktopSupported()) {
                    try {
                        Desktop.getDesktop().browse(new URI("https://example.com"));
                    } catch (IOException | URISyntaxException e) {
                        e.printStackTrace();
                    }
                }
                // Return true if the person is over 21 years old
                return true;
            } else {
                // Return false if the person is not over 21 years old
                return false;
            }
        } else {
            // Return false if the DOB string could not be parsed
            return false;
        }
    }

    // Function to parse a DOB string in the format MMddyyyy into a LocalDate object
    public static LocalDate parseDOB(String dobStr) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
            return LocalDate.parse(dobStr, formatter);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Driver code
    public static void main(String[] args)
            throws WriterException, IOException,
            NotFoundException {

        // Path where the QR code is saved
        String path = "PATHHHHHH";

        // Encoding charset
        String charset = "UTF-8";

        Map<EncodeHintType, ErrorCorrectionLevel> hashMap
                = new HashMap<EncodeHintType,
                ErrorCorrectionLevel>();

        // Set error correction level to L
        hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

        // Get date of birth from QR code and print it
        String dobStr = QRCode.getDOBFromQR(path);
        System.out.println("Date of Birth: " + QRCode.getDOBFromQR(path));

        // Read QR code and print the content
        System.out.println("TOTAL QRCode output: " + QRCode.readQR(path, charset, hashMap));

        // Check if person is over 21 and print result
        LocalDate parsedDOB = QRCode.parseDOB(dobStr);
        if (parsedDOB != null) {
            System.out.println("Over 21: " + QRCode.isOver21(dobStr));
        } else {
            System.out.println("Failed to parse DOB.");
        }
    }
}

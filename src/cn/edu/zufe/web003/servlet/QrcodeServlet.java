package cn.edu.zufe.web003.servlet;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "QrcodeServlet",urlPatterns = "/QrcodeServlet")
public class QrcodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = "http://59.110.235.55/Web001";
        HashMap hints = new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        BitMatrix bitMatrix;
        try{
            bitMatrix = new MultiFormatWriter().encode(code, BarcodeFormat.QR_CODE, 300, 300, hints);
            response.setContentType("image/jpeg");
//            String filePath = this.getServletConfig().getServletContext().getRealPath("/") + "images" + File.separator;
            MatrixToImageWriter.writeToStream(bitMatrix, "jpg", response.getOutputStream());
        } catch (WriterException e){
            e.printStackTrace();
        }
    }
}

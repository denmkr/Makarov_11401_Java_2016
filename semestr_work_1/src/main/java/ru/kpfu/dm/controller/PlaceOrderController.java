package ru.kpfu.dm.controller;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.bouncycastle.jcajce.provider.symmetric.ARC4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.dm.entity.*;
import ru.kpfu.dm.modul.XMLParser;
import ru.kpfu.dm.repository.CartProductRepository;
import ru.kpfu.dm.service.*;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Denis on 22/03/2016.
 */

@Controller
@RequestMapping("/placeorder")
public class PlaceOrderController {

    @Autowired
    JavaMailSender mailSender;
    @Autowired
    CartProductService cartProductService;
    @Autowired
    OrderService orderService;

    String FONT;

    @RequestMapping(method = RequestMethod.GET)
    public String placeOrder(ModelMap model, HttpSession session) throws Exception {

        FONT = session.getServletContext().getRealPath("/WEB-INF/font/");
        Cart cart;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            if (session.getAttribute("cart") == null) session.setAttribute("cart", new Cart());
            cart = (Cart) session.getAttribute("cart");
            orderService.createOrder(cart);

            session.setAttribute("cart", null); // Очищаем корзину
        }
        else {
            cart = cartProductService.getCart();
            orderService.createOrder(cart);

            cartProductService.removeCart(cart);
        }

        pdfMail(cart);

        return "redirect:/cart";
    }

    public void pdfMail(Cart cart) throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");

        helper.setTo("webmaventest@gmail.com");
        helper.setSubject("This is the test message for testing gmail smtp server using spring mail");
        helper.setFrom("webmaventest@gmail.com");

        //now write the PDF content to the output stream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        writePdf(outputStream, cart);
        byte[] bytes = outputStream.toByteArray();

        //construct the pdf body part
        DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");
        MimeBodyPart pdfBodyPart = new MimeBodyPart();
        pdfBodyPart.setDataHandler(new DataHandler(dataSource));
        pdfBodyPart.setFileName("order_otrajenie.pdf");

        //construct the mime multi part
        MimeMultipart mimeMultipart = new MimeMultipart();
        mimeMultipart.addBodyPart(pdfBodyPart);

        mimeMessage.setContent(mimeMultipart);

        mailSender.send(mimeMessage);
    }

    public void htmlMail(Cart cart) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");

        helper.setTo("den.mkr@gmail.com");
        helper.setSubject("This is the test message for testing gmail smtp server using spring mail");
        helper.setFrom("den.mkr@gmail.com");

        String htmlMsg = "<h3>Ваш заказ</h3>";
        htmlMsg += "<div>";
        for (Product product : cart.getProducts()) {
            htmlMsg = htmlMsg + "<div style='font-size: 20px;color: #555;'>" + product.getName() + "</div>";
        }
        htmlMsg += "</div>";
        htmlMsg += "выавыаыва";
        mimeMessage.setContent(htmlMsg, "text/html; charset=utf-8");

        mailSender.send(mimeMessage);
    }

    public void writePdf(OutputStream outputStream, Cart cart) throws Exception {
        Document document = new Document();
        PdfWriter.getInstance(document, outputStream);
        document.open();

        Font font = FontFactory.getFont(FONT + "OpenSans-Regular.ttf", "Cp1251", BaseFont.EMBEDDED);
        font.setSize(12);
        font.setColor(new BaseColor(78, 127, 169));

        Font lfont = FontFactory.getFont(FONT + "OpenSans-Regular.ttf", "Cp1251", BaseFont.EMBEDDED);
        lfont.setSize(40);
        lfont.setColor(new BaseColor(78, 127, 169));

        Font pfont = FontFactory.getFont(FONT + "OpenSans-Regular.ttf", "Cp1251", BaseFont.EMBEDDED);
        pfont.setSize(14);

        Font dfont = FontFactory.getFont(FONT + "OpenSans-Regular.ttf", "Cp1251", BaseFont.EMBEDDED);
        dfont.setSize(12);
        dfont.setColor(new BaseColor(34, 34, 34));

        document.add(new Paragraph("Отражение", lfont));
        document.add(new Paragraph(" ", pfont));
        document.add(new Paragraph("Ваш заказ (№ " + "12233" + ")", pfont));
        document.add(new Paragraph(" ", pfont));
        document.add(new Paragraph(" ", pfont));

        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[] {2.0f, 4.0f, 2.0f});
        table.setSpacingBefore(10);

        PdfPCell cell = new PdfPCell();
        cell.setBorderColor(BaseColor.WHITE);
        cell.setBorderColorBottom(new BaseColor(78, 127, 169));
        cell.setBackgroundColor(BaseColor.WHITE);
        cell.setBorderWidthBottom(2);
        cell.setPadding(5);
        cell.setPaddingBottom(8);

        cell.setPhrase(new Phrase("Артикул", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Наименование", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Цена", font));
        table.addCell(cell);

        cell.setBorderColor(new BaseColor(204, 204, 204));
        cell.setBorderColorBottom(new BaseColor(204, 204, 204));
        cell.setBackgroundColor(BaseColor.WHITE);
        cell.setBorderWidthBottom(1);
        cell.setPadding(5);
        cell.setPaddingBottom(10);
        cell.setPaddingTop(10);

        int i = 1;
        for (Product product : cart.getProducts()) {
            if (i % 2 == 0) cell.setBackgroundColor(new BaseColor(238, 238, 238));
            else cell.setBackgroundColor(BaseColor.WHITE);
            cell.setPhrase(new Phrase(product.getArticule(), dfont));
            table.addCell(cell);
            cell.setPhrase(new Phrase(product.getName(), dfont));
            table.addCell(cell);
            cell.setPhrase(new Phrase(product.getPrice().toString() + " " + product.getCurrency(), dfont));
            table.addCell(cell);

            i++;
        }

        document.add(table);

        document.add(new Paragraph(" ", pfont));
        document.add(new Paragraph("Общая стоимость заказа: 6900.50 руб.", pfont));

        document.close();
    }


}

package ru.kpfu.dm.controller;
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
import ru.kpfu.dm.service.CartProductService;
import ru.kpfu.dm.service.GroupService;
import ru.kpfu.dm.service.ProductService;
import ru.kpfu.dm.service.UserService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Denis on 22/03/2016.
 */

@Controller
@RequestMapping("/placeorder")
public class PlaceOrderController {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    CartProductService cartProductService;

    @RequestMapping(method = RequestMethod.GET)
    public String sendMail(ModelMap model, HttpSession session) throws MessagingException {
        Cart cart;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken) {
            if (session.getAttribute("cart") == null) session.setAttribute("cart", new Cart());
            cart = (Cart) session.getAttribute("cart");
            session.setAttribute("cart", null); // Очищаем корзину
        }
        else {
            cart = cartProductService.getCart();
            cartProductService.removeCart(cart);
        }

        // creates a simple e-mail object
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


        return "redirect:/cart";
    }


}

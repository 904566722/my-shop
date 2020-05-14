package com.hhhqqq.my.shop.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName MainController
 * @Description TODO
 * @Author HHQ
 * @Date 2020/4/14 22:12
 * @Version 1.0
 */
@Controller
public class MainController {

    @RequestMapping(value = "main", method = RequestMethod.GET)
    public String main() {
        return "main";
    }



}

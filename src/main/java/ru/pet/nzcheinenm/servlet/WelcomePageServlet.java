package ru.pet.nzcheinenm.servlet;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class WelcomePageServlet extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws IOException {
        if (res instanceof HttpServletResponse httpServletResponse) {
            httpServletResponse.sendRedirect("/index.xhtml");
        }
    }
}

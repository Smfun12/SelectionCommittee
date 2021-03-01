package com.servlet.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface PdfCommand {
    String execute(HttpServletRequest request, HttpServletResponse response);
}

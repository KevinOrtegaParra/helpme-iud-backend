package com.helpmeiud.helpmeiud_backend.services.ifaces;

public interface IEmailService {

    boolean sendMail(String mensaje, String email, String asunto);
}

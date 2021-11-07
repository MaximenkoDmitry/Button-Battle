package com.itransition.buttonbattle.controller;

import com.itransition.buttonbattle.model.Click;
import com.itransition.buttonbattle.model.Message;
import com.itransition.buttonbattle.service.ButtonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;

@Controller
public class MessagingController {

    @Autowired
    private ButtonService buttonService;

    @MessageMapping("/buttonbattle")
    @SendTo("/topic/messages")
    public Message send(final Click click, final OAuth2AuthenticationToken token) {
        switch (token.getAuthorizedClientRegistrationId()) {
            case "google":
                click.setFrom(token.getPrincipal().getAttribute("name"));
                break;
            case "github":
                click.setFrom(token.getPrincipal().getAttribute("login"));
                break;
            case "facebook":
                click.setFrom(token.getPrincipal().getAttribute("name"));
                break;
            default:
                click.setFrom("anonymous");
        }
        return buttonService.saveClick(click);
    }

}

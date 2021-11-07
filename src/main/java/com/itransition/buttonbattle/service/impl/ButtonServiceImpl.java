package com.itransition.buttonbattle.service.impl;

import com.itransition.buttonbattle.model.Click;
import com.itransition.buttonbattle.model.Message;
import com.itransition.buttonbattle.repository.ButtonInMemoryRepository;
import com.itransition.buttonbattle.service.ButtonService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ButtonServiceImpl implements ButtonService {

    private static final String TIME_PATTERN = "HH:mm";

    private final ButtonInMemoryRepository buttonInMemoryRepository;

    public ButtonServiceImpl(final ButtonInMemoryRepository buttonInMemoryRepository) {
        this.buttonInMemoryRepository = buttonInMemoryRepository;
    }

    @Override
    public Message saveClick(final Click click) {
        final String messageTime = new SimpleDateFormat(TIME_PATTERN).format(new Date());
        final Message message = new Message(click.getFrom(), click.getButtonType(), messageTime);

        switch (message.getButtonType()) {
            case BRO:
                buttonInMemoryRepository.saveLastBroMessage(message);
                break;
            case SIS:
                buttonInMemoryRepository.saveLastSisMessage(message);
                break;
        }

        return message;
    }

    @Override
    public Message getLastBroMessage() {
        return buttonInMemoryRepository.getLastBroMessage();
    }

    @Override
    public Message getLastSisMessage() {
        return buttonInMemoryRepository.getLastSysMessage();
    }

    @Override
    public Long getNumberOfBroClicks() {
        return buttonInMemoryRepository.getNumberOfBroClicks();
    }

    @Override
    public Long getNumberOfSisClicks() {
        return buttonInMemoryRepository.getNumberOfSisClicks();
    }

}

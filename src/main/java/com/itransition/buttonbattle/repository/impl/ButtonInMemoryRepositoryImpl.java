package com.itransition.buttonbattle.repository.impl;

import com.itransition.buttonbattle.model.Message;
import com.itransition.buttonbattle.repository.ButtonInMemoryRepository;
import org.springframework.stereotype.Component;

@Component
public class ButtonInMemoryRepositoryImpl implements ButtonInMemoryRepository {

    private final Object broLock = new Object();
    private final Object sisLock = new Object();

    private Message lastBroMessage;
    private Message lastSisMessage;
    private long numberOfBroClicks;
    private long numberOfSisClicks;

    @Override
    public void saveLastBroMessage(final Message message) {
        synchronized (broLock) {
            numberOfBroClicks++;
            lastBroMessage = message;
        }
    }

    @Override
    public void saveLastSisMessage(final Message message) {
        synchronized (sisLock) {
            numberOfSisClicks++;
            lastSisMessage = message;
        }
    }

    @Override
    public Message getLastBroMessage() {
        Message lastBroMessageCopy = null;
        if (lastBroMessage != null) {
            synchronized (broLock) {
                lastBroMessageCopy = new Message(lastBroMessage.getFrom(), lastBroMessage.getButtonType(), lastBroMessage.getTime());
            }
        }
        return lastBroMessageCopy;
    }

    @Override
    public Message getLastSysMessage() {
        Message lastSisMessageCopy = null;
        if (lastSisMessage != null) {
            synchronized (sisLock) {
                lastSisMessageCopy = new Message(lastSisMessage.getFrom(), lastSisMessage.getButtonType(), lastSisMessage.getTime());
            }
        }
        return lastSisMessageCopy;
    }

    @Override
    public long getNumberOfBroClicks() {
        return numberOfBroClicks;
    }

    @Override
    public long getNumberOfSisClicks() {
        return numberOfSisClicks;
    }
}

package com.itransition.buttonbattle.repository;

import com.itransition.buttonbattle.model.Message;

public interface ButtonInMemoryRepository {

    void saveLastBroMessage(Message message);

    void saveLastSisMessage(Message message);

    Message getLastBroMessage();

    Message getLastSysMessage();

    long getNumberOfBroClicks();

    long getNumberOfSisClicks();
}

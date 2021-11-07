package com.itransition.buttonbattle.service;

import com.itransition.buttonbattle.model.Click;
import com.itransition.buttonbattle.model.Message;

public interface ButtonService {

    Message saveClick(Click message);

    Message getLastBroMessage();

    Message getLastSisMessage();

    Long getNumberOfBroClicks();

    Long getNumberOfSisClicks();

}

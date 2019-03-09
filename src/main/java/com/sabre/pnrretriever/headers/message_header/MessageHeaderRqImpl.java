package com.sabre.pnrretriever.headers.message_header;

import com.sabre.pnrretriever.config.properties.HeaderProperties;
import com.sabre.web_services.message_header.*;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Clock;

import static com.sabre.pnrretriever.headers.message_header.Action.SESSION_CREATE;

@Component
public class MessageHeaderRqImpl implements MessageHeaderRq {

    @Autowired
    private HeaderProperties headerProperties;

    @Override
    public MessageHeader getMessageHeader(Action action) {
        MessageHeader messageHeader = new MessageHeader();
        messageHeader.setConversationId(headerProperties.getConversationId());
        messageHeader.setCPAId(headerProperties.getCpaid());
        messageHeader.setAction(action.getValue());
        messageHeader.setFrom(getFromHeaderElement());
        messageHeader.setTo(getToHeaderElement());
        messageHeader.setMessageData(getMessageDataHeaderElement());

        if (action == SESSION_CREATE) {
            Service service = new Service();
            service.setValue(SESSION_CREATE.getValue());
            service.setType("SabreXML");
            messageHeader.setService(service);
        }

        return messageHeader;
    }

    @Override
    public From getFromHeaderElement() {
        From from = new From();
        PartyId partyId = new PartyId();
        partyId.setValue(headerProperties.getFromPartyId());
        from.getPartyId().add(partyId);
        return from;
    }

    @Override
    public To getToHeaderElement() {
        To to = new To();
        PartyId partyId = new PartyId();
        partyId.setValue(headerProperties.getToPartyId());
        to.getPartyId().add(partyId);
        return to;
    }

    @Override
    public MessageData getMessageDataHeaderElement() {
        MessageData messageData = new MessageData();
        messageData.setMessageId(headerProperties.getMessageId());
        messageData.setTimestamp(Clock.systemUTC().instant().toString());
        messageData.setTimeToLive(new XMLGregorianCalendarImpl());
        return messageData;
    }
}


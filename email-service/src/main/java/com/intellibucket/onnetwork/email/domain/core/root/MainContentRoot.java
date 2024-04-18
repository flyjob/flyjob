package com.intellibucket.onnetwork.email.domain.core.root;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.mail.MailContentID;
import az.rock.lib.valueObject.notification.NotificationContentType;

public class MainContentRoot extends AggregateRoot<MailContentID> {
    private String targetEmail;
    private String subject;
    private NotificationContentType content;
    private String contentData;
}

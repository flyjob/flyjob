package com.intellibucket.lib.payload.event.command.update;


import az.rock.flyjob.js.domain.core.root.detail.InterestRoot;
import com.intellibucket.lib.payload.event.abstracts.AbstractStartDomainEvent;


public class InterestUpdateEvent extends AbstractStartDomainEvent<InterestRoot> {
    public InterestUpdateEvent() {

    } public InterestUpdateEvent(InterestRoot root) {
        super(root);
    }

    public static InterestUpdateEvent of(InterestRoot root){
        return new InterestUpdateEvent(root);
    }


}

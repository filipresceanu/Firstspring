package ro.developmentfactory.myspringapi.model.exception;

import ro.developmentfactory.myspringapi.model.Item;

import java.text.MessageFormat;

public class CartNotFoundException extends RuntimeException{
    public CartNotFoundException(final Long id)
    {
        super(MessageFormat.format("Could not find item with id: {0}",id));
    }

}

package ro.developmentfactory.myspringapi.model.exception;

import org.aspectj.bridge.Message;

import java.text.MessageFormat;

public class ItemsIsAlreadyAssignedException extends RuntimeException{
    public ItemsIsAlreadyAssignedException(final Long itemId,final Long cartId)
    {
        super(MessageFormat.format("Item:{0} is alreaedy assigned to cart: {1}",itemId,cartId));
    }

}

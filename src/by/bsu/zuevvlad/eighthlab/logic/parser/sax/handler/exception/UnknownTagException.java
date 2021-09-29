package by.bsu.zuevvlad.eighthlab.logic.parser.sax.handler.exception;

import org.xml.sax.SAXException;

public final class UnknownTagException extends SAXException
{
    public UnknownTagException()
    {
        super();
    }

    public UnknownTagException(final String description)
    {
        super(description);
    }

    public UnknownTagException(final Exception cause)
    {
        super(cause);
    }

    public UnknownTagException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}

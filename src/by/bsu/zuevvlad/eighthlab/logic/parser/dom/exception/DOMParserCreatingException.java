package by.bsu.zuevvlad.eighthlab.logic.parser.dom.exception;

import by.bsu.zuevvlad.eighthlab.logic.parser.exception.XMLParserCreatingException;

public final class DOMParserCreatingException extends XMLParserCreatingException
{
    public DOMParserCreatingException()
    {
        super();
    }

    public DOMParserCreatingException(final String description)
    {
        super(description);
    }

    public DOMParserCreatingException(final Exception cause)
    {
        super(cause);
    }

    public DOMParserCreatingException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}

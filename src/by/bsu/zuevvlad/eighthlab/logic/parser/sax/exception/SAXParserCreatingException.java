package by.bsu.zuevvlad.eighthlab.logic.parser.sax.exception;

import by.bsu.zuevvlad.eighthlab.logic.parser.exception.XMLParserCreatingException;

public final class SAXParserCreatingException extends XMLParserCreatingException
{
    public SAXParserCreatingException()
    {
        super();
    }

    public SAXParserCreatingException(final String description)
    {
        super(description);
    }

    public SAXParserCreatingException(final Exception cause)
    {
        super(cause);
    }

    public SAXParserCreatingException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}

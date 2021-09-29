package by.bsu.zuevvlad.eighthlab.logic.parser.dom.xpath.exception;

import by.bsu.zuevvlad.eighthlab.logic.parser.exception.XMLParserCreatingException;

public final class XPathParserCreatingException extends XMLParserCreatingException
{
    public XPathParserCreatingException()
    {
        super();
    }

    public XPathParserCreatingException(final String description)
    {
        super(description);
    }

    public XPathParserCreatingException(final Exception cause)
    {
        super(cause);
    }

    public XPathParserCreatingException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}

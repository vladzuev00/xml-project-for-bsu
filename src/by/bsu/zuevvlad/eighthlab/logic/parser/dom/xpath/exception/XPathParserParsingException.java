package by.bsu.zuevvlad.eighthlab.logic.parser.dom.xpath.exception;

import by.bsu.zuevvlad.eighthlab.logic.parser.exception.XMLParserParsingException;

public final class XPathParserParsingException extends XMLParserParsingException
{
    public XPathParserParsingException()
    {
        super();
    }

    public XPathParserParsingException(final String description)
    {
        super(description);
    }

    public XPathParserParsingException(final Exception cause)
    {
        super(cause);
    }

    public XPathParserParsingException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}

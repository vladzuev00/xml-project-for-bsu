package by.bsu.zuevvlad.eighthlab.logic.parser.sax.exception;

import by.bsu.zuevvlad.eighthlab.logic.parser.exception.XMLParserParsingException;

public final class SAXParserParsingException extends XMLParserParsingException
{
    public SAXParserParsingException()
    {
        super();
    }

    public SAXParserParsingException(final String description)
    {
        super(description);
    }

    public SAXParserParsingException(final Exception cause)
    {
        super(cause);
    }

    public SAXParserParsingException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}

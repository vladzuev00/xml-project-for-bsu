package by.bsu.zuevvlad.eighthlab.logic.parser.dom.exception;

import by.bsu.zuevvlad.eighthlab.logic.parser.exception.XMLParserParsingException;

public final class DOMParserParsingException extends XMLParserParsingException
{
    public DOMParserParsingException()
    {
        super();
    }

    public DOMParserParsingException(final String description)
    {
        super(description);
    }

    public DOMParserParsingException(final Exception cause)
    {
        super(cause);
    }

    public DOMParserParsingException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}

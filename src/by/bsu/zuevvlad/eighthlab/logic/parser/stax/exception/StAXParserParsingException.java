package by.bsu.zuevvlad.eighthlab.logic.parser.stax.exception;

import by.bsu.zuevvlad.eighthlab.logic.parser.exception.XMLParserParsingException;

public final class StAXParserParsingException extends XMLParserParsingException
{
    public StAXParserParsingException()
    {
        super();
    }

    public StAXParserParsingException(final String description)
    {
        super(description);
    }

    public StAXParserParsingException(final Exception cause)
    {
        super(cause);
    }

    public StAXParserParsingException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}

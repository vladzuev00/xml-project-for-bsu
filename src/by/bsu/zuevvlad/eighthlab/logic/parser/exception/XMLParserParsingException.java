package by.bsu.zuevvlad.eighthlab.logic.parser.exception;

public class XMLParserParsingException extends XMLParserException
{
    public XMLParserParsingException()
    {
        super();
    }

    public XMLParserParsingException(final String description)
    {
        super(description);
    }

    public XMLParserParsingException(final Exception cause)
    {
        super(cause);
    }

    public XMLParserParsingException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}

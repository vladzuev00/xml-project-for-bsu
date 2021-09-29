package by.bsu.zuevvlad.eighthlab.logic.parser.exception;

public class XMLParserCreatingException extends XMLParserException
{
    public XMLParserCreatingException()
    {
        super();
    }

    public XMLParserCreatingException(final String description)
    {
        super(description);
    }

    public XMLParserCreatingException(final Exception cause)
    {
        super(cause);
    }

    public XMLParserCreatingException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}

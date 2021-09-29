package by.bsu.zuevvlad.eighthlab.logic.parser.exception;

public class XMLParserException extends Exception
{
    public XMLParserException()
    {
        super();
    }

    public XMLParserException(final String description)
    {
        super(description);
    }

    public XMLParserException(final Exception cause)
    {
        super(cause);
    }

    public XMLParserException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}

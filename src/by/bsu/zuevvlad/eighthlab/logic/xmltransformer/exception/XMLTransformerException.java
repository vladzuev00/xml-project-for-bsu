package by.bsu.zuevvlad.eighthlab.logic.xmltransformer.exception;

public class XMLTransformerException extends Exception
{
    public XMLTransformerException()
    {
        super();
    }

    public XMLTransformerException(final String description)
    {
        super(description);
    }

    public XMLTransformerException(final Exception cause)
    {
        super(cause);
    }

    public XMLTransformerException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}

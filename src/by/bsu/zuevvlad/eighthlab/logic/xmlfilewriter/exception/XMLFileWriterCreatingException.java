package by.bsu.zuevvlad.eighthlab.logic.xmlfilewriter.exception;

public class XMLFileWriterCreatingException extends XMLFileWriterException
{
    public XMLFileWriterCreatingException()
    {
        super();
    }

    public XMLFileWriterCreatingException(final String description)
    {
        super(description);
    }

    public XMLFileWriterCreatingException(final Exception cause)
    {
        super(cause);
    }

    public XMLFileWriterCreatingException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}

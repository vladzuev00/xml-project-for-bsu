package by.bsu.zuevvlad.eighthlab.logic.xmlfilewriter.exception;

public class XMLFileWriterException extends Exception
{
    public XMLFileWriterException()
    {
        super();
    }

    public XMLFileWriterException(final String description)
    {
        super(description);
    }

    public XMLFileWriterException(final Exception cause)
    {
        super(cause);
    }

    public XMLFileWriterException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}

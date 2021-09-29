package by.bsu.zuevvlad.eighthlab.logic.xmlfilewriter.exception;

public class XMLFileWriterWritingException extends XMLFileWriterException
{
    public XMLFileWriterWritingException()
    {
        super();
    }

    public XMLFileWriterWritingException(final String description)
    {
        super(description);
    }

    public XMLFileWriterWritingException(final Exception cause)
    {
        super(cause);
    }

    public XMLFileWriterWritingException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}

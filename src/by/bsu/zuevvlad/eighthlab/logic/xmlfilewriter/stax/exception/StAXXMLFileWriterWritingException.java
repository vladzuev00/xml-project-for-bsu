package by.bsu.zuevvlad.eighthlab.logic.xmlfilewriter.stax.exception;

import by.bsu.zuevvlad.eighthlab.logic.xmlfilewriter.exception.XMLFileWriterWritingException;

public final class StAXXMLFileWriterWritingException extends XMLFileWriterWritingException
{
    public StAXXMLFileWriterWritingException()
    {
        super();
    }

    public StAXXMLFileWriterWritingException(final String description)
    {
        super(description);
    }

    public StAXXMLFileWriterWritingException(final Exception cause)
    {
        super(cause);
    }

    public StAXXMLFileWriterWritingException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}

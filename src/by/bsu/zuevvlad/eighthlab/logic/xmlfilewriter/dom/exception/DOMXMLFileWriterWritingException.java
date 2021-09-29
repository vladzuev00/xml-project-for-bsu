package by.bsu.zuevvlad.eighthlab.logic.xmlfilewriter.dom.exception;

import by.bsu.zuevvlad.eighthlab.logic.xmlfilewriter.exception.XMLFileWriterWritingException;

public final class DOMXMLFileWriterWritingException extends XMLFileWriterWritingException
{
    public DOMXMLFileWriterWritingException()
    {
        super();
    }

    public DOMXMLFileWriterWritingException(final String description)
    {
        super(description);
    }

    public DOMXMLFileWriterWritingException(final Exception cause)
    {
        super(cause);
    }

    public DOMXMLFileWriterWritingException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}

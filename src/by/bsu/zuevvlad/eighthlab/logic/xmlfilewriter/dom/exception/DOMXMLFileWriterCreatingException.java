package by.bsu.zuevvlad.eighthlab.logic.xmlfilewriter.dom.exception;

import by.bsu.zuevvlad.eighthlab.logic.xmlfilewriter.exception.XMLFileWriterCreatingException;

public final class DOMXMLFileWriterCreatingException extends XMLFileWriterCreatingException
{
    public DOMXMLFileWriterCreatingException()
    {
        super();
    }

    public DOMXMLFileWriterCreatingException(final String description)
    {
        super(description);
    }

    public DOMXMLFileWriterCreatingException(final Exception cause)
    {
        super(cause);
    }

    public DOMXMLFileWriterCreatingException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}

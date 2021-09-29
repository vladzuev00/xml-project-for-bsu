package by.bsu.zuevvlad.eighthlab.logic.xmlsyntaxanalyzerrorhandler.exception;

import org.xml.sax.SAXException;

public final class XMLSyntaxAnalyzingException extends SAXException
{
    public XMLSyntaxAnalyzingException()
    {
        super();
    }

    public XMLSyntaxAnalyzingException(final String description)
    {
        super(description);
    }

    public XMLSyntaxAnalyzingException(final Exception cause)
    {
        super(cause);
    }

    public XMLSyntaxAnalyzingException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}

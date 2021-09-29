package by.bsu.zuevvlad.eighthlab.logic.xmlsyntaxanalyzerrorhandler;

import by.bsu.zuevvlad.eighthlab.logic.xmlsyntaxanalyzerrorhandler.exception.XMLSyntaxAnalyzingException;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

public final class XMLSyntaxAnalyzeErrorHandler implements ErrorHandler
{
    public XMLSyntaxAnalyzeErrorHandler()
    {
        super();
    }

    @Override
    public final void warning(final SAXParseException cause) throws XMLSyntaxAnalyzingException
    {
        throw new XMLSyntaxAnalyzingException(cause);
    }

    @Override
    public final void error(final SAXParseException cause) throws XMLSyntaxAnalyzingException
    {
        throw new XMLSyntaxAnalyzingException(cause);
    }

    @Override
    public final void fatalError(final SAXParseException cause) throws XMLSyntaxAnalyzingException
    {
        throw new XMLSyntaxAnalyzingException(cause);
    }
}

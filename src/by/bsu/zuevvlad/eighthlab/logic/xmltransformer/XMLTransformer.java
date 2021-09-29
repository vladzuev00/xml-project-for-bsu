package by.bsu.zuevvlad.eighthlab.logic.xmltransformer;

import by.bsu.zuevvlad.eighthlab.logic.xmltransformer.exception.XMLTransformerCreatingException;
import by.bsu.zuevvlad.eighthlab.logic.xmltransformer.exception.XMLTransformerTransformingException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public final class XMLTransformer
{
    private final Transformer transformer;

    private XMLTransformer(final Transformer transformer)
    {
        super();
        this.transformer = transformer;
    }

    public static XMLTransformer createXMLTransformer(final File fileOfStyleSheet)
            throws XMLTransformerCreatingException
    {
        try
        {
            final StreamSource streamSourceOfStyleSheet = new StreamSource(fileOfStyleSheet);
            final TransformerFactory transformerFactory = TransformerFactory.newInstance();
            final Transformer transformer = transformerFactory.newTransformer(streamSourceOfStyleSheet);
            return new XMLTransformer(transformer);
        }
        catch(final TransformerConfigurationException cause)
        {
            throw new XMLTransformerCreatingException(cause);
        }
    }

    public final void transform(final File transformedFile, final File fileToOutputTransformedFile)
            throws XMLTransformerTransformingException
    {
        try
        {
            final StreamSource streamSourceOfTransformedFile = new StreamSource(transformedFile);
            final StreamResult streamResultOfFileToOutputTransformedFile = new StreamResult(fileToOutputTransformedFile);
            this.transformer.transform(streamSourceOfTransformedFile, streamResultOfFileToOutputTransformedFile);
        }
        catch(final TransformerException cause)
        {
            throw new XMLTransformerTransformingException(cause);
        }
    }
}

package by.bsu.zuevvlad.eighthlab.logic.xmltransformer.exception;

public final class XMLTransformerTransformingException extends XMLTransformerException
{
    public XMLTransformerTransformingException()
    {
        super();
    }

    public XMLTransformerTransformingException(final String description)
    {
        super(description);
    }

    public XMLTransformerTransformingException(final Exception cause)
    {
        super(cause);
    }

    public XMLTransformerTransformingException(final String description, final Exception cause)
    {
        super(description, cause);
    }
}

package by.bsu.zuevvlad.eighthlab.logic.xmlfilewriter.dom.entitydocumentinjector;

import by.bsu.zuevvlad.eighthlab.entity.Entity;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public abstract class EntityDocumentInjector<TypeOfInjectedEntity extends Entity>
{
    private final Document document;
    private final Element rootElement;

    public EntityDocumentInjector(final Document document, final String nameOfRootElement)
    {
        this.document = document;
        this.rootElement = this.document.createElement(nameOfRootElement);
        this.document.appendChild(this.rootElement);
    }

    protected final Document getDocument()
    {
        return this.document;
    }

    protected final Element getRootElement()
    {
        return this.rootElement;
    }

    public abstract void injectEntity(final TypeOfInjectedEntity injectedEntity);
}

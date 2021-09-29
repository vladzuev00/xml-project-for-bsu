package by.bsu.zuevvlad.eighthlab.logic.parser.dom.entitybuilder;

import by.bsu.zuevvlad.eighthlab.entity.Entity;
import org.w3c.dom.Element;

public interface XMLEntityDOMBuilder<TypeOfBuiltEntity extends Entity>
{
    public abstract TypeOfBuiltEntity buildEntity(final Element elementOfXML);
}

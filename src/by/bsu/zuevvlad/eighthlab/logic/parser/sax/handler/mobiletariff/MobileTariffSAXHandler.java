package by.bsu.zuevvlad.eighthlab.logic.parser.sax.handler.mobiletariff;

import by.bsu.zuevvlad.eighthlab.entity.MobileTariff;
import by.bsu.zuevvlad.eighthlab.logic.parser.sax.handler.SAXHandler;
import by.bsu.zuevvlad.eighthlab.logic.parser.sax.handler.exception.UnknownTagException;
import org.xml.sax.Attributes;

import java.math.BigDecimal;

public final class MobileTariffSAXHandler extends SAXHandler<MobileTariff>
{
    public MobileTariffSAXHandler()
    {
        super();
    }

    @Override
    public final void startElement(final String uri, final String localName,
                                   final String qualifiedName, final Attributes attributes)
    {
        if(qualifiedName.equals(MobileTariffSAXHandler.QUALIFIED_NAME_OF_TAG_OF_MOBILE_TARIFF))
        {
            this.setCurrentParsedEntity(new MobileTariff());
        }
    }

    private static final String QUALIFIED_NAME_OF_TAG_OF_MOBILE_TARIFF = "mobile_tariff";

    @Override
    public final void endElement(final String uri, final String localName, final String qualifiedName)
            throws UnknownTagException
    {
        switch(qualifiedName)
        {
            case MobileTariffSAXHandler.QUALIFIED_NAME_OF_TAG_OF_ID:
                final long id = Long.parseLong(this.getCurrentContent());
                this.getCurrentParsedEntity().setId(id);
                break;
            case MobileTariffSAXHandler.QUALIFIED_NAME_OF_TAG_OF_NAME_OF_TARIFF:
                final String nameOfTariff = this.getCurrentContent();
                this.getCurrentParsedEntity().setNameOfTariff(nameOfTariff);
                break;
            case MobileTariffSAXHandler.QUALIFIED_NAME_OF_TAG_OF_NAME_OF_OPERATOR:
                final String nameOfOperator = this.getCurrentContent();
                this.getCurrentParsedEntity().setNameOfOperator(nameOfOperator);
                break;
            case MobileTariffSAXHandler.QUALIFIED_NAME_OF_TAG_OF_PAYROLL_PER_MONTH:
                final BigDecimal payrollPerMonth = new BigDecimal(this.getCurrentContent());
                this.getCurrentParsedEntity().setPayrollPerMonth(payrollPerMonth);
                break;
            case MobileTariffSAXHandler.QUALIFIED_NAME_OF_TAG_OF_PRICE_PER_MINUTE_OF_CALL_INSIDE_NETWORK:
                final BigDecimal priceOfCallPerMinuteInsideNetwork = new BigDecimal(this.getCurrentContent());
                this.getCurrentParsedEntity().updatePricePerMinuteOfTypeOfCall(
                        MobileTariff.TypeOfCall.INSIDE_NETWORK, priceOfCallPerMinuteInsideNetwork);
                break;
            case MobileTariffSAXHandler.QUALIFIED_NAME_OF_TAG_OF_PRICE_PER_MINUTE_OF_CALL_OUTSIDE_NETWORK:
                final BigDecimal priceOfCallPerMinuteOutsideNetwork = new BigDecimal(this.getCurrentContent());
                this.getCurrentParsedEntity().updatePricePerMinuteOfTypeOfCall(
                        MobileTariff.TypeOfCall.OUTSIDE_NETWORK, priceOfCallPerMinuteOutsideNetwork);
                break;
            case MobileTariffSAXHandler.QUALIFIED_NAME_OF_TAG_OF_PRICE_ON_LANDLINE_PHONE:
                final BigDecimal priceOfCallPerMinuteOnLandlinePhone = new BigDecimal(this.getCurrentContent());
                this.getCurrentParsedEntity().updatePricePerMinuteOfTypeOfCall(
                        MobileTariff.TypeOfCall.LANDLINE_PHONE, priceOfCallPerMinuteOnLandlinePhone);
                break;
            case MobileTariffSAXHandler.QUALIFIED_NAME_OF_TAG_OF_TYPES_OF_CALLS_AND_THEIR_PRICES_PER_MINUTE:
                break;
            case MobileTariffSAXHandler.QUALIFIED_NAME_OF_TAG_OF_PRICE_FOR_SMS:
                final BigDecimal priceForSms = new BigDecimal(this.getCurrentContent());
                this.getCurrentParsedEntity().setPriceForSms(priceForSms);
                break;
            case MobileTariffSAXHandler.QUALIFIED_NAME_OF_TAG_OF_MOBILE_TARIFF:
                this.getParsedEntities().add(this.getCurrentParsedEntity());
                break;
            case MobileTariffSAXHandler.QUALIFIED_NAME_OF_TAG_OF_MOBILE_TARIFFS:
                break;
            default:
                throw new UnknownTagException("Unknown tag '" + qualifiedName + "'.");
        }
    }

    private static final String QUALIFIED_NAME_OF_TAG_OF_ID = "id";
    private static final String QUALIFIED_NAME_OF_TAG_OF_NAME_OF_TARIFF = "name_of_tariff";
    private static final String QUALIFIED_NAME_OF_TAG_OF_NAME_OF_OPERATOR = "name_of_operator";
    private static final String QUALIFIED_NAME_OF_TAG_OF_PAYROLL_PER_MONTH = "payroll_per_month";
    private static final String QUALIFIED_NAME_OF_TAG_OF_PRICE_PER_MINUTE_OF_CALL_INSIDE_NETWORK = "inside_network";
    private static final String QUALIFIED_NAME_OF_TAG_OF_PRICE_PER_MINUTE_OF_CALL_OUTSIDE_NETWORK = "outside_network";
    private static final String QUALIFIED_NAME_OF_TAG_OF_PRICE_ON_LANDLINE_PHONE = "landline_phone";
    private static final String QUALIFIED_NAME_OF_TAG_OF_TYPES_OF_CALLS_AND_THEIR_PRICES_PER_MINUTE
            = "types_of_calls_and_their_prices_per_minute";
    private static final String QUALIFIED_NAME_OF_TAG_OF_PRICE_FOR_SMS = "price_for_sms";
    private static final String QUALIFIED_NAME_OF_TAG_OF_MOBILE_TARIFFS = "mobile_tariffs";
}

package by.bsu.zuevvlad.eighthlab.logic.xmlfilewriter.dom.entitydocumentinjector.mobiletariff;

import by.bsu.zuevvlad.eighthlab.entity.MobileTariff;
import by.bsu.zuevvlad.eighthlab.logic.xmlfilewriter.dom.entitydocumentinjector.EntityDocumentInjector;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public final class MobileTariffDocumentInjector extends EntityDocumentInjector<MobileTariff>
{
    public MobileTariffDocumentInjector(final Document document)
    {
        super(document, MobileTariffDocumentInjector.NAME_OF_ROOT_ELEMENT);
    }

    private static final String NAME_OF_ROOT_ELEMENT = "mobile_tariffs";

    @Override
    public final void injectEntity(final MobileTariff injectedMobileTariff)
    {
        final Document document = this.getDocument();
        final Element elementOfMobileTariff = document.createElement(
                MobileTariffDocumentInjector.NAME_OF_TAG_OF_MOBILE_TARIFF);
        final Element elementOfId = document.createElement(MobileTariffDocumentInjector.NAME_OF_TAG_OF_ID);
        final Element elementOfNameOfTariff = document.createElement(
                MobileTariffDocumentInjector.NAME_OF_TAG_OF_NAME_OF_TARIFF);
        final Element elementOfNameOfOperator = document.createElement(
                MobileTariffDocumentInjector.NAME_OF_TAG_OF_NAME_OF_OPERATOR);
        final Element elementOfNameOfPayrollPerMonth = document.createElement(
                MobileTariffDocumentInjector.NAME_OF_TAG_OF_PAYROLL_PER_MONTH);
        final Element elementOfTypesOfCallsAndTheirPricesPerMinute = document.createElement(
                MobileTariffDocumentInjector.NAME_OF_TAG_OF_TYPES_OF_CALLS_AND_THEIR_PRICES_PER_MINUTE);
        final Element elementOfPricePerMinuteOfCallInsideNetwork = document.createElement(
                MobileTariffDocumentInjector.NAME_OF_TAG_OF_PRICE_PER_MINUTE_OF_CALL_INSIDE_NETWORK);
        final Element elementOfPricePerMinuteOfCallOutsideNetwork = document.createElement(
                MobileTariffDocumentInjector.NAME_OF_TAG_OF_PRICE_PER_MINUTE_OF_CALL_OUTSIDE_NETWORK);
        final Element elementOfPricePerMinuteOfCallOnLandlinePhone = document.createElement(
                MobileTariffDocumentInjector.NAME_OF_TAG_OF_PRICE_PER_MINUTE_OF_CALL_ON_LANDLINE_PHONE);
        final Element elementOfPriceForSms = document.createElement(
                MobileTariffDocumentInjector.NAME_OF_TAG_OF_PRICE_FOR_SMS);

        final String contentOfTagOfId = Long.toString(injectedMobileTariff.getId());
        final Text textContentOfTagOfId = document.createTextNode(contentOfTagOfId);

        final String contentOfTagOfNameOfTariff = injectedMobileTariff.getNameOfTariff();
        final Text textContentOfTagOfNameOfTariff = document.createTextNode(contentOfTagOfNameOfTariff);

        final String contentOfTagOfNameOfOperator = injectedMobileTariff.getNameOfOperator();
        final Text textContentOfTagOfNameOfOperator = document.createTextNode(contentOfTagOfNameOfOperator);

        final String contentOfTagOfPayrollPerMonth = injectedMobileTariff.getPayrollPerMonth().toString();
        final Text textContentOfTagOfPayrollPerMonth = document.createTextNode(contentOfTagOfPayrollPerMonth);

        final String contentOfTagOfPricePerMinuteOfCallInsideNetwork
                = injectedMobileTariff.findPricePerMinuteOfTypeOfCall(MobileTariff.TypeOfCall.INSIDE_NETWORK).toString();
        final Text textContentOfTagOfPricePerMinuteOfCallInsideNetwork = document.createTextNode(
                contentOfTagOfPricePerMinuteOfCallInsideNetwork);

        final String contentOfTagOfPricePerMinuteOfCallOutsideNetwork = injectedMobileTariff
                .findPricePerMinuteOfTypeOfCall(MobileTariff.TypeOfCall.OUTSIDE_NETWORK).toString();
        final Text textContentOfTagOfPricePerMinuteOfCallOutsideNetwork = document.createTextNode(
                contentOfTagOfPricePerMinuteOfCallOutsideNetwork);

        final String contentOfTagOfPricePerMinuteOfCallOnLandlinePhone = injectedMobileTariff
                .findPricePerMinuteOfTypeOfCall(MobileTariff.TypeOfCall.LANDLINE_PHONE).toString();
        final Text textContentOfTagOfPricePerMinuteOfCallOnLandlinePhone = document.createTextNode(
                contentOfTagOfPricePerMinuteOfCallOnLandlinePhone);

        final String contentOfTagOfPriceForSms = injectedMobileTariff.getPriceForSms().toString();
        final Text textContentOfTagOfPriceForSms = document.createTextNode(contentOfTagOfPriceForSms);

        elementOfId.appendChild(textContentOfTagOfId);
        elementOfNameOfTariff.appendChild(textContentOfTagOfNameOfTariff);
        elementOfNameOfOperator.appendChild(textContentOfTagOfNameOfOperator);
        elementOfNameOfPayrollPerMonth.appendChild(textContentOfTagOfPayrollPerMonth);
        elementOfPricePerMinuteOfCallInsideNetwork.appendChild(textContentOfTagOfPricePerMinuteOfCallInsideNetwork);
        elementOfPricePerMinuteOfCallOutsideNetwork.appendChild(textContentOfTagOfPricePerMinuteOfCallOutsideNetwork);
        elementOfPricePerMinuteOfCallOnLandlinePhone.appendChild(textContentOfTagOfPricePerMinuteOfCallOnLandlinePhone);
        elementOfPriceForSms.appendChild(textContentOfTagOfPriceForSms);

        elementOfTypesOfCallsAndTheirPricesPerMinute.appendChild(elementOfPricePerMinuteOfCallInsideNetwork);
        elementOfTypesOfCallsAndTheirPricesPerMinute.appendChild(elementOfPricePerMinuteOfCallOutsideNetwork);
        elementOfTypesOfCallsAndTheirPricesPerMinute.appendChild(elementOfPricePerMinuteOfCallOnLandlinePhone);

        elementOfMobileTariff.appendChild(elementOfId);
        elementOfMobileTariff.appendChild(elementOfNameOfTariff);
        elementOfMobileTariff.appendChild(elementOfNameOfOperator);
        elementOfMobileTariff.appendChild(elementOfNameOfPayrollPerMonth);
        elementOfMobileTariff.appendChild(elementOfTypesOfCallsAndTheirPricesPerMinute);
        elementOfMobileTariff.appendChild(elementOfPriceForSms);

        this.getRootElement().appendChild(elementOfMobileTariff);
    }

    private static final String NAME_OF_TAG_OF_MOBILE_TARIFF = "mobile_tariff";
    private static final String NAME_OF_TAG_OF_ID = "id";
    private static final String NAME_OF_TAG_OF_NAME_OF_TARIFF = "name_of_tariff";
    private static final String NAME_OF_TAG_OF_NAME_OF_OPERATOR = "name_of_operator";
    private static final String NAME_OF_TAG_OF_PAYROLL_PER_MONTH = "payroll_per_month";
    private static final String NAME_OF_TAG_OF_TYPES_OF_CALLS_AND_THEIR_PRICES_PER_MINUTE
            = "types_of_calls_and_their_prices_per_minute";
    private static final String NAME_OF_TAG_OF_PRICE_PER_MINUTE_OF_CALL_INSIDE_NETWORK = "inside_network";
    private static final String NAME_OF_TAG_OF_PRICE_PER_MINUTE_OF_CALL_OUTSIDE_NETWORK = "outside_network";
    private static final String NAME_OF_TAG_OF_PRICE_PER_MINUTE_OF_CALL_ON_LANDLINE_PHONE = "landline_phone";
    private static final String NAME_OF_TAG_OF_PRICE_FOR_SMS = "price_for_sms";
}

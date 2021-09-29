package by.bsu.zuevvlad.eighthlab;

import by.bsu.zuevvlad.eighthlab.entity.MobileTariff;
import by.bsu.zuevvlad.eighthlab.logic.parser.XMLParser;
import by.bsu.zuevvlad.eighthlab.logic.parser.dom.exception.DOMParserCreatingException;
import by.bsu.zuevvlad.eighthlab.logic.parser.exception.XMLParserParsingException;
import by.bsu.zuevvlad.eighthlab.logic.parser.dom.xpath.exception.XPathParserCreatingException;
import by.bsu.zuevvlad.eighthlab.logic.parser.sax.exception.SAXParserCreatingException;
import by.bsu.zuevvlad.eighthlab.logic.parser.stax.StAXParser;
import by.bsu.zuevvlad.eighthlab.logic.parser.stax.entitybuilder.XMLStAXEntityBuilder;
import by.bsu.zuevvlad.eighthlab.logic.parser.stax.entitybuilder.XMLStAXMobileTariffBuilder;
import by.bsu.zuevvlad.eighthlab.logic.xmlfilewriter.XMLFileWriter;
import by.bsu.zuevvlad.eighthlab.logic.xmlfilewriter.dom.DOMXMLFileWriter;
import by.bsu.zuevvlad.eighthlab.logic.xmlfilewriter.dom.entitydocumentinjector.mobiletariff.MobileTariffDocumentInjector;
import by.bsu.zuevvlad.eighthlab.logic.xmlfilewriter.dom.exception.DOMXMLFileWriterCreatingException;
import by.bsu.zuevvlad.eighthlab.logic.xmlfilewriter.exception.XMLFileWriterWritingException;
import by.bsu.zuevvlad.eighthlab.logic.xmlfilewriter.stax.StAXXMLFileWriter;
import by.bsu.zuevvlad.eighthlab.logic.xmlfilewriter.stax.entityinjector.mobiletariff.StAXMobileTariffInjector;
import by.bsu.zuevvlad.eighthlab.logic.xmltransformer.XMLTransformer;
import by.bsu.zuevvlad.eighthlab.logic.xmltransformer.exception.XMLTransformerCreatingException;
import by.bsu.zuevvlad.eighthlab.logic.xmltransformer.exception.XMLTransformerTransformingException;

import java.io.File;
import java.util.List;

public class Runner
{
    public static void main(final String[] args) throws XMLParserParsingException, DOMParserCreatingException, XPathParserCreatingException, SAXParserCreatingException, DOMXMLFileWriterCreatingException, XMLFileWriterWritingException, XMLTransformerCreatingException, XMLTransformerTransformingException {
        final String pathOfParsedFile = "data/mobile_tariffs.xml";
        final File parsedFile = new File(pathOfParsedFile);

        //DOM parser:
        /*final XMLEntityDOMBuilder<MobileTariff> xmlEntityBuilder = new XMLMobileTariffDOMBuilder();
        final XMLParser<MobileTariff> domParser = DOMParser.<MobileTariff>createDOMParser(xmlEntityBuilder);
        System.out.println(domParser.parse(parsedFile));*/

        //XPath parser:
        /*final XMLEntityDOMBuilder<MobileTariff> xmlEntityBuilder = new XMLMobileTariffDOMBuilder();
        final String expressionFindNodeList = "/mobile_tariffs/mobile_tariff";
        final XMLParser<MobileTariff> xPathParser = XPathParser.<MobileTariff>createXPathParser(
                xmlEntityBuilder, expressionFindNodeList);
        System.out.println(xPathParser.parse(parsedFile));*/

        //SAXParser:
        /*final SAXHandler<MobileTariff> saxHandler = new MobileTariffSAXHandler();
        final XMLParser<MobileTariff> saxParser = SAXParser.<MobileTariff>createSAXParser(saxHandler);
        System.out.println(saxParser.parse(parsedFile));*/

        /*final XMLStAXEntityBuilder<MobileTariff> xmlStAXEntityBuilder = new XMLStAXMobileTariffBuilder();
        final XMLParser<MobileTariff> staxXMLParser = new StAXParser<MobileTariff>(xmlStAXEntityBuilder);
        final List<MobileTariff> mobileTariffs = staxXMLParser.parse(parsedFile);
        System.out.println(staxXMLParser.parse(parsedFile));

        final String pathOfFileForOutput = "data/out_mobile_tariffs.xml";
        final File fileForOutput = new File(pathOfFileForOutput);*/

        /*final XMLFileWriter<MobileTariff> xmlFileWriter = DOMXMLFileWriter.<MobileTariff>createDOMXMLFileBuilder(
                MobileTariffDocumentInjector.class);
        xmlFileWriter.writeToXMLFile(mobileTariffs, fileForOutput);*/

        /*final XMLFileWriter<MobileTariff> xmlFileWriter = new StAXXMLFileWriter<MobileTariff>(
                new StAXMobileTariffInjector());
        xmlFileWriter.writeToXMLFile(mobileTariffs, fileForOutput);*/

        final String pathOfFileOfStyleSheet = "data/template_of_transforming.xsl";
        final File fileOfStyleSheet = new File(pathOfFileOfStyleSheet);
        final XMLTransformer xmlTransformer = XMLTransformer.createXMLTransformer(fileOfStyleSheet);
        final String pathOfTransformedFile = "data/mobile_tariffs.xml";
        final File transformedFile = new File(pathOfTransformedFile);
        final String pathOfFileToOutputTransformedFile = "data/transformed_file.html";
        final File fileToOutputTransformedFile = new File(pathOfFileToOutputTransformedFile);
        xmlTransformer.transform(transformedFile, fileToOutputTransformedFile);
    }
}


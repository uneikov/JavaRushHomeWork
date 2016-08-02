package com.javarush.test.level33.lesson10.bonus01;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

import org.w3c.dom.*;

/* Комментарий внутри xml
Реализовать метод toXmlWithComment, который должен возвращать строку - xml представление объекта obj.
В строке перед каждым тэгом tagName должен быть вставлен комментарий comment.
Сериализация obj в xml может содержать CDATA с искомым тегом. Перед ним вставлять комментарий не нужно(???).

Пример вызова:  toXmlWithComment(firstSecondObject, "second", "it's a comment")
Пример результата:
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<first>
    <!--it's a comment-->
    <second>some string</second>
    <!--it's a comment-->
    <second>some string</second>
    <!--it's a comment-->
    <second><![CDATA[need CDATA because of < and >]]></second>
    <!--it's a comment-->
    <second/>
</first>

нужно обернуть с помощью инструментов DOM все текстовые поля которые содержат escape — последовательности  --> в CDATA

*/

public class Solution {

    public static String toXmlWithComment(Object obj, String tagName, String comment) {

        String result = null;

        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            marshaller.marshal(obj, doc);

            visitAndChangeCDATANodes(doc,doc);

            NodeList nodes = doc.getElementsByTagName(tagName);

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = doc.getElementsByTagName(tagName).item(i);
                Comment commentString = doc.createComment(comment);
                node.getParentNode().insertBefore(commentString, node);
            }

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            StringWriter out = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(out));
            result = out.toString();
        }catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void visitAndChangeCDATANodes(Node node, Document doc) {

        if (node.getNodeType() == Node.TEXT_NODE && node.getNodeValue().matches(".*[<>&'\"].*")){
            node.getParentNode().replaceChild(doc.createCDATASection(node.getTextContent()), node);
        }
        NodeList list = node.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            Node childNode = list.item(i);
            visitAndChangeCDATANodes(childNode, doc);
        }
    }
}

package com.javarush.test.level33.lesson10.bonus01;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Комментарий внутри xml
Реализовать метод toXmlWithComment, который должен возвращать строку - xml представление объекта obj.
В строке перед каждым тэгом tagName должен быть вставлен комментарий comment.
Сериализация obj в xml может содержать CDATA с искомым тегом. Перед ним вставлять комментарий не нужно.

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
*/

public class Solution {

    public static String xmlString =
            "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
                    "<first>\n" +
                    "    <second>some string</second>\n" +
                    "    <second>some string</second>\n" +
                    "        <third>\n" +
                    "            <second> some string </second>\n" +
                    "        </third>\n" +
                    "    <second><![CDATA[need CDATA because of <second>]]></second>\n" +
                    "    <second/>\n" +
                    "</first>";

    public static String toXmlWithComment(Object obj, String tagName, String comment) {

        StringBuilder result;

        List<Integer> beginChange = new LinkedList<>();
        List<Integer> indent = new ArrayList<>();
        List<Integer> beginSkip = new ArrayList<>();
        List<Integer> endSkip = new ArrayList<>();

        String xmlComment = "<!--" + comment + "-->";
        StringWriter writer = new StringWriter();

        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(obj, writer);
        }catch (JAXBException e) {
            e.printStackTrace();
        }
        //String _result = writer.toString();
        String _result = xmlString;

        Pattern patternToChange = Pattern.compile("[\\n]\\s*<" + tagName );
        //Pattern patternToChange = Pattern.compile("(^(<!\\[CDATA\\[))\\s*<" + tagName + "^(\\]\\]>)");
        Pattern patternToSkip = Pattern.compile("<!\\[CDATA\\[.*<" + tagName+".*\\]\\]>");

        result = new StringBuilder(_result);

        Matcher matcherToChange = patternToChange.matcher(_result);
        Matcher matcherToSkip = patternToSkip.matcher(_result);

        while (matcherToChange.find()){
            beginChange.add(matcherToChange.start());
            indent.add(matcherToChange.end() - matcherToChange.start() - tagName.length() - 2);
        }

        while (matcherToSkip.find()){
            beginSkip.add(matcherToSkip.start());
            endSkip.add(matcherToSkip.end());
        }
        for (int k = 0;k < beginChange.size(); k++){
            for (int i = 0; i < beginSkip.size(); i++) {
                if ((beginChange.get(k).compareTo(beginSkip.get(i)) > 0) && (beginChange.get(k).compareTo(endSkip.get(i)) < 0)){
                    beginChange.remove(k);
                }
            }
        }
        for (int i = beginChange.size() - 1; i >= 0; i--) {
            result.insert(beginChange.get(i),
                    "\n" + new String(new char[indent.get(i)]).replace('\0', ' ') +
                            xmlComment);
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Long lll = new Long("0");
        System.out.println(++lll);
        System.out.println(++lll);

        String[] sa = new String[]{"string array 1", "string array 2"};
        TestClass testClass = new TestClass(100, "text field", sa);
        String result = toXmlWithComment(testClass, "second", "it's a comment");
        System.out.println(result);
    }
}

@XmlRootElement
class TestClass{
    int x;
    String text;
    String[] second;

    public TestClass() {
    }

    public TestClass(int x, String text, String[] second) {
        this.x = x;
        this.text = text;
        this.second = second;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getSecond() {
        return second;
    }

    public void setSecond(String[] secretData) {
        this.second = secretData;
    }
}